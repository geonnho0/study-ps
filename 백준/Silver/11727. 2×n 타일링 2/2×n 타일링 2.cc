#include<iostream>

#define MAXN 1001

using namespace std;

int main()
{
    int n; cin >> n;

    unsigned long long dp[MAXN] = {0};
    dp[1] = 1;
    dp[2] = 3;

    for (int i = 3; i <= n; i++)
        dp[i] = dp[i - 1] % 10007 + 2 * dp[i - 2] % 10007;

    cout << dp[n] % 10007;

    return 0;
}