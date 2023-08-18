#include <iostream>

using namespace std;

int main()
{    
    int n; cin >> n;
    long long t[36] = {0};
    t[0] = t[1] = 1;
    for (int i = 2; i <= n; i++)
    {
        long long tmp = 0;
        for (int j = 0; j <= i - 1; j++)
            tmp += (t[j] * t[i - 1 - j]);
        t[i] = tmp;
    }
    cout << t[n];
	return 0;
}