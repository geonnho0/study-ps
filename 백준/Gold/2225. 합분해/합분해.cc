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
    for (int k = 2; k <= K; k++) {
        for (int n = 1; n <= N; n++) {
            int total = 0;
            for (int tmp = 0; tmp <= n; tmp++) {
                total = (total + dp[k-1][n-tmp]) % 1000000000;
            }
            dp[k][n] = total;
        }
    }
    printf("%lld", dp[K][N]);
}

int main() {
    solution();
    return 0;
}