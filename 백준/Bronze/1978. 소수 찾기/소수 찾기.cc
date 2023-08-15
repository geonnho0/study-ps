#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(int num) {
    if (num == 1) return false;
    for (int i = 2; i <= sqrt(num); i++)
    {
        if (num % i == 0) return false;
    }
    return true;
}

int main()
{
    int N; cin >> N;
    int cnt = 0;
    while (N--)
    {
        int num; cin >> num;
        if (isPrime(num)) cnt++;
    }
    cout << cnt;
	return 0;
}