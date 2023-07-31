#include<iostream>

long long dp[15][15];

void makeDP() {
    for (int i = 1; i <= 14; i++) {
        dp[0][i] = (long long) i;
    }
    for (int i = 1; i <= 14; i++) {
        for (int j = 1; j <= 14; j++) {
            for (int k = 1; k <= j; k++) {
                dp[i][j] += dp[i - 1][k];
            }
        }
    }
}

int main() {
    int T;
    scanf("%d", &T);
    makeDP();
    while (T--) {
        int k, n;
        scanf("%d", &k);
        scanf("%d", &n);
        printf("%d\n", dp[k][n]);
    }
}