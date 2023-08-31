#include<iostream>
#include<algorithm>
#include<limits.h>

#define MAXN 201
#define MAXT 202

using namespace std;

int N, S, T;
int arr[MAXN];
int dp[MAXT][MAXN] = {0};  // i번째 때, j번 칸에 도착 시, 최대로 얻을 수 있는 코인

void run();

void solution() {
    while (1) {
        scanf("%d", &N);
        if (N == 0) break;
        scanf("%d %d", &S, &T);
        for (int i = 1; i <= N; i++)
            scanf("%d", arr + i);
        run();
    }
}

void run() {
    for (int i = 1; i < T; i++) {
        for (int j = 1; j <= N + 1; j++) {
            dp[i][j] = INT_MIN;
        }
    }
    for (int i = 1; i <= S; i++) {
        dp[1][i] = arr[i];
    }
    for (int i = 2; i < T; i++) {
        for (int j = i; j <= i * S; j++) {
            for (int k = 1; k <= S; k++) {
                int prev = j - k;
                if (prev <= N && prev > 0 && dp[i-1][prev] != INT_MIN) {
                    dp[i][j] = max(dp[i][j], dp[i-1][prev] + arr[j]);
                }
            }
        }
    }
    int ans = INT_MIN;
    for (int i = 0; i < S; i++) {
        ans = max(ans, dp[T-1][N-i]);
    }
    printf("%d\n", ans);
}

int main() {
    solution();
    return 0;
}