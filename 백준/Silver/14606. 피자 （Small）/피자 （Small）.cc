#include <iostream>

using namespace std;

int dp[11];

void init()
{
    for (int i = 0; i < 11; i++)
        dp[i] = -1;
}

void getCount(int height)
{
    if (dp[height] != -1) return;
    if (height == 1) dp[height] = 0;
    else if (height == 2) dp[height] = 1;
    else
    {
        if (height % 2 == 0)
        {
            dp[height] = (height / 2) * (height / 2);
            dp[height] += 2 * dp[height / 2];
        }
        else
        {
            int a = height / 2;
            int b = a + 1;
            dp[height] = a * b;
            dp[height] += dp[a] + dp[b];
        }
    }
}

int main()
{
    int N;
	cin >> N;
    init();
    for (int i = 1; i <= N; i++)
        getCount(i);
    cout<< dp[N];
	return 0;
}