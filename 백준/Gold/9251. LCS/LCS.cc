#include<iostream>
#include<algorithm>

#define MAXN 1002

using namespace std;

string s1, s2;
unsigned long long dp[MAXN][MAXN] = {0};

void input() {
    cin >> s1 >> s2;
}

void solution() {
    int len1 = s1.length(), len2 = s2.length();
    for (int i = 1; i <= len1; i++) {
        for (int j = 1; j <= len2; j++) {
            if (s2[j-1] == s1[i-1])
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        }
    }
    cout << dp[len1][len2];
}

int main() {
    input();
    solution();
    return 0;
}