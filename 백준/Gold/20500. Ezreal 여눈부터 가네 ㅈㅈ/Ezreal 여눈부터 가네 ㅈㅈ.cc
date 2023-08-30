#include<iostream>

#define MAXN 1520
#define MOD 1000000007

using namespace std;

int N;
unsigned long long dp[MAXN][MAXN] = {0};

void solution() {
    cin >> N;
    dp[0][1] = 0;
    dp[0][2] = 1; dp[1][2] = 1; dp[2][2] = 0;
    
    for (int i = 3; i < N + 1; i++) {
        dp[0][i] = (dp[2][i - 1] + dp[1][i - 1]) % MOD;
		dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
		dp[2][i] = (dp[1][i - 1] + dp[0][i - 1]) % MOD;
    }

    cout << dp[0][N];
}

int main() {
    solution();
    return 0;
}