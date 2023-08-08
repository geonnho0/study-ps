#include <iostream>

using namespace std;

int main()
{
	int N; cin >> N;
    long long dp[10010];
    dp[1] = 4; dp[2] = 6;
	for (int i = 3; i <= N; i++)
		dp[i] = dp[i - 1] + dp[i - 2];
	cout << dp[N] << endl;
	return 0;
}