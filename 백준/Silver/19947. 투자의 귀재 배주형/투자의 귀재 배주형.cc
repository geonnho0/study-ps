#include <iostream>

using namespace std;

int main()
{
    int H, Y;
	cin >> H >> Y;
    int dp[11] = {0};
    dp[0] = H;
    for (int i = 1; i <= Y; i++)
    {
        if (i < 3) dp[i] = dp[i - 1] * 1.05;
        else if (i < 5)
        {
            int a = dp[i - 1] * 1.05;
            int b = dp[i - 3] * 1.2;
            dp[i] = a > b ? a : b;
        }
        else
        {
            int a = dp[i - 1] * 1.05;
            int b = dp[i - 3] * 1.2;
            int c = dp[i - 5] * 1.35;
            dp[i] = a > b ? (a > c ? a : c) : (b > c ? b : c);
        }
    }
    cout << dp[Y];
	return 0;
}