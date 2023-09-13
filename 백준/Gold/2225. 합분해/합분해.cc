#include<iostream>

#define MAXK 201
#define MAXN 201

using namespace std;

int N, K;
long dp[MAXK][MAXN] = {0};

void solution() {
    scanf("%d %d", &N, &K);
    for (int i = 1; i <= N; i++) dp[1][i] = 1;
    for (int i = 1; i <= K; i++) dp[i][0] = 1;
    for (int i = 2; i <= K; i++) {
        for (int j = 1; j <= N; j++) {
            dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
        }
    }
    printf("%lld", dp[K][N]);
}

int main() {
    solution();
    return 0;
}