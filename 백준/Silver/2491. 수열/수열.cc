#include <iostream>

using namespace std;

int main()
{
    int N; cin >> N;
    int arr[100001];
    for (int i = 0; i < N; i++)
        cin >> arr[i];

    int less[100001] = {0}, great[100001] = {0};
    less[0] = great[0] = 1;
    for (int i = 1; i < N; i++)
    {
        if (arr[i - 1] <= arr[i])
            great[i] = great[i - 1] + 1;
        else
            great[i] = 1;
    }
    for (int i = 1; i < N; i++)
    {
        if (arr[i - 1] >= arr[i])
            less[i] = less[i - 1] + 1;
        else
            less[i] = 1;
    }

    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        if (ans < less[i]) ans = less[i];
        if (ans < great[i]) ans = great[i];
    }
    cout << ans;
	return 0;
}