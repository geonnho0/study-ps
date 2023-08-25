#include<iostream>
#include<algorithm>

#define MAXN 1001

using namespace std;

int n, m;
unsigned long long dp[MAXN][MAXN] = {0};

void input() {
    cin >> n >> m;
}

void solution() {
    for (int i = 1; i <= m; i++)
        dp[1][i] = 1;
    for (int i = 1; i <= n; i++)
        dp[i][1] = 1;
    dp[1][1] = 1;
    for (int j = 2; j <= n; j++)
        for (int i = 2; i <= m; i++)
            dp[j][i] = (dp[j][i - 1] + dp[j - 1][i] + dp[j - 1][i - 1]) % 1000000007;
    
    cout << dp[n][m];
}

int main() {
    input();
    solution();
    return 0;
}