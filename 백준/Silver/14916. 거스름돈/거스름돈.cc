#include<iostream>
#include<algorithm>

using namespace std;

int main() {
    int n; cin>> n;
    int dp[100001];
    dp[0] = dp[1] = -1;
    dp[2] = 1;
    dp[3] = -1;
    dp[4] = 2;
    dp[5] = 1;
    for (int i = 6; i <= n; i++)
    {
        int minus2 = dp[i - 2];
        int minus5 = dp[i - 5];
        if (minus2 == -1)
        {
            if (minus5 == 0) dp[i] = -1;
            else dp[i] = minus5 + 1;
        }
        else
        {
            if (minus5 == -1) dp[i] = minus2 + 1;
            else dp[i] = min(minus2, minus5) + 1;
        }
    }
    cout<< dp[n]<< endl;
    return 0;
}