#include <iostream>

using namespace std;

int main()
{
    int N; cin >> N;
    int dp[5001] = {0};
    dp[3] = 1; dp[5] = 1;
    for (int i = 6; i <= N; i++)
    {
        if (dp[i - 3] != 0)
        {
            dp[i] = dp[i - 3] + 1;
            if (dp[i - 5] != 0) {
                int tmp = dp[i - 5] + 1;
                dp[i] = dp[i] < tmp ? dp[i] : tmp;
            }
        }
        else if (dp[i - 5] != 0)
        {
            dp[i] = dp[i - 5] + 1;
        }
    }
    cout << (dp[N] == 0 ? -1 : dp[N]);
	return 0;
}