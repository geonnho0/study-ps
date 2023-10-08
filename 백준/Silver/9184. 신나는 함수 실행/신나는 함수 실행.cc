#include<iostream>
#define MAXN 21

using namespace std;

unsigned long long dp[MAXN][MAXN][MAXN];

void initDP() {
    for (int a = 0; a <= 20; a++) {
        for (int b = 0; b <= 20; b++) {
            for (int c = 0; c <= 20; c++) {
                if (a <= 0 || b <= 0 || c <= 0) {
                    dp[a][b][c] = 1;
                } else if (a < b && b < c) {
                    dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
                } else {
                    dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
                }
            }
        }
    }
}

int main() {
    initDP();
    while (1) {
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);
        if (a == -1 && b == -1 && c == -1) {
            break;
        } else if (a <= 0 || b <= 0 || c <= 0) {
            printf("w(%d, %d, %d) = 1\n", a, b, c);
        } else if (a > 20 || b > 20 || c > 20) {
            printf("w(%d, %d, %d) = %lld\n", a, b, c, dp[20][20][20]);
        } else {
            printf("w(%d, %d, %d) = %lld\n", a, b, c, dp[a][b][c]);
        }
    }
    return 0;
}