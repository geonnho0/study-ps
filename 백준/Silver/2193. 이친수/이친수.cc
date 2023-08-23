#include<iostream>

#define MAXN 91

using namespace std;

int main()
{
    int n; cin >> n;
    unsigned long long dp[MAXN][2];
    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 2; i <= n; i++) {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        dp[i][1] = dp[i - 1][0];
    }
    cout << dp[n][0] + dp[n][1];
    return 0;
}