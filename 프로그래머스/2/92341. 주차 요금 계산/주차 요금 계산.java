import java.util.*;

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> map = new HashMap<>();
        for (String record: records) {
            String[] line = record.split(" ");
            int time = parseTime(line[0]);
            String carNum = line[1];
            boolean isIn = line[2].equals("IN");
            if (isIn) {
                Car car = map.getOrDefault(carNum, new Car(carNum, time));
                car.in(time);
                map.put(carNum, car);
                continue;
            }
            Car car = map.get(carNum);
            car.out(time);
        }
        int endTime = parseTime("23:59");
        List<Car> cars = new ArrayList<>();
        for (String carNum : map.keySet()) {
            Car car = map.get(carNum);
            if (car.isIn) {
                car.out(endTime);
                map.put(carNum, car);
            }
            cars.add(car);
        }
        Collections.sort(cars, (c1, c2) -> c1.number.compareTo(c2.number));
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            answer[i] = car.getFee(fees[0], fees[1], fees[2], fees[3]);
        }
        return answer;
    }
    
    int parseTime(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h * 60 + m;
    }
    
}

class Car {
    String number;
    boolean isIn;
    int inTime, totalTime;
    
    public Car(String number, int inTime) {
        this.number = number;
        this.inTime = inTime;
        isIn = true;
    }
    
    public void in(int inTime) {
        this.inTime = inTime;
        isIn = true;
    }
    
    public void out(int outTime) {
        totalTime += outTime - inTime;
        isIn = false;
    }
    
    public int getFee(int baseLen, int baseFee, int perTime, int perFee) {
        if (totalTime <= baseLen) {
            return baseFee;
        }
        return baseFee + (int) (Math.ceil((double) (totalTime - baseLen) / perTime)) * perFee;
    }
}