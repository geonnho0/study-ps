#include<iostream>

using namespace std;

unsigned long long dp[101];
int n;

void calc() {
    dp[1] = dp[2] = dp[3] = 1;
    dp[4] = dp[5] = 2;
    for (int i = 6; i <= 100; i++) {
        dp[i] = dp[i-5] + dp[i-1];
    }
}

int main() {
    int t; cin >> t;
    calc();
    while (t--)
    {
        cin >> n;
        cout << dp[n] << endl;
    }
    return 0;
}