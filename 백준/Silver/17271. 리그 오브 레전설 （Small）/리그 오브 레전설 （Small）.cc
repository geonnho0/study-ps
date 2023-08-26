#include<iostream>

#define MAXN 10001

using namespace std;

int n, m;
unsigned long long dp[MAXN] = {0};

void input() {
    cin >> n >> m;
}

void solution() {
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        if (i == m) {
            dp[i] = (dp[i - 1] + 1) % 1000000007;
        } else if (i > m) {
            dp[i] = (dp[i - 1] + dp[i - m]) % 1000000007;
        } else {
            dp[i] = dp[i - 1] % 1000000007;
        }
    }
    cout << dp[n];
}

int main() {
    input();
    solution();
    return 0;
}