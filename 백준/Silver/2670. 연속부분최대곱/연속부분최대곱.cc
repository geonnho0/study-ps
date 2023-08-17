#include <iostream>

using namespace std;

int main()
{
    int N; cin >> N;
    double arr[10001];
    for (int i = 0; i < N; i++)
        cin >> arr[i];

    double max = 0;
    for (int i = 1; i < N; i++)
    {
        if (arr[i] * arr[i - 1] >= arr[i])
        {
            arr[i] *= arr[i - 1];
        }
        max = max > arr[i] ? max : arr[i];
    }
    printf("%.3f", max);
	return 0;
}