#include<iostream>

#define MAXN 101
#define MAXK 10001

using namespace std;

int n, k;
int coins[MAXN];
unsigned long long dp[MAXK] = {0};

void input() {
    cin >> n >> k;
    for (int i = 0; i < n; i++)
        cin >> coins[i];
}

void solution() {
    dp[0] = 1;
    for (int i = 0; i < n; i++) {
        for (int j = coins[i]; j <= k; j++) {
            dp[j] = dp[j] + dp[j - coins[i]];
        }
    }
    cout << dp[k];
}

int main() {
    input();
    solution();
    return 0;
}