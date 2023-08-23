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
    for (int i = 0; i <= N; i++) {
        if (i != 0) {
            dp[i] = max(dp[i], dp[i-1]);
        }
        int endDay = i + T[i];
        if (endDay <= N) {
            dp[endDay] = max(dp[endDay], dp[i] + P[i]);
        }
    }
    cout << dp[N];
}

int main() {
    input();
    solution();
    return 0;
}