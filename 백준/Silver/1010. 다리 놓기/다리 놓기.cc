#include<iostream>

using namespace std;

int main() {
    int T; cin>> T;
    while (T--) {
        int N, M; cin>> N>> M;
        long dp[31][31];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }
        for (int i = 2; i <= M; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= N; i++)
            for (int j = i + 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        cout<< dp[N][M]<< endl;
    }
}