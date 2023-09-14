#include<iostream>
#include<map>

#define MAXN 101

using namespace std;

int N;
map<int, int> lines;
int dp[MAXN];

void input() {
    cin >> N;
    int A, B;
    for (int i = 0; i < N; i++) {
        cin >> A >> B;
        lines[A] = B;
    }
}

void solution() {
    int i = 1, max = 0;
    for (auto it = lines.begin(); it != lines.end(); it++, i++) {
        dp[i] = 1;
        int j = 1;
        for (auto tmp = lines.begin(); tmp != it; tmp++, j++) {
            if (tmp->second < it->second) {
                dp[i] = dp[i] < (dp[j] + 1) ? (dp[j] + 1) : dp[i];
            }
        }
        max = max < dp[i] ? dp[i] : max;
    }
    cout << N - max;
}

int main() {
    input();
    solution();
    return 0;
}