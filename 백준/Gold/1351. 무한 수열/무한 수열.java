import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    long N = parseLong(line[0]);
    long P = parseLong(line[1]);
    long Q = parseLong(line[2]);
    Map<Long, Long> map = new HashMap<>();
    map.put(0L, 1L);
    System.out.println(getValue(map, N, P, Q));
  }

  static Long getValue(Map<Long, Long> map, Long N, Long P, Long Q) {
    if (map.containsKey(N))
      return map.get(N);
    Long first = getValue(map, (long) Math.floor((double) N / P), P, Q);
    Long second = getValue(map, (long) Math.floor((double) N / Q), P, Q);
    map.put(N, first + second);
    return first + second;
  }

  static long parseLong(String s) {
    return Long.parseLong(s);
  }

}