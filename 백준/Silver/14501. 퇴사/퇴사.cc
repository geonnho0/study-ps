#include<iostream>
#include<algorithm>

#define MAXN 25

using namespace std;

int N;
int T[MAXN], P[MAXN];
int dp[MAXN] = {0};

void input() {
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> T[i] >> P[i];
}

void solution() {
    int ans = 0;
    for (int i = 0; i <= N; i++) {
        dp[i] = max(dp[i], ans);
        int endDay = i + T[i];
        if (endDay <= N) {
            dp[endDay] = max(dp[endDay], dp[i] + P[i]);
        }
        ans = max(ans, dp[i]);
    }
    cout << ans;
}

int main() {
    input();
    solution();
    return 0;
}