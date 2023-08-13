#include <iostream>

using namespace std;

int main()
{
    int N; cin >> N;
    int a[200001];
    int min[200001];
    cin >> a[0];
    min[0] = a[0];
    int max = 0;
    for (int i = 1; i < N; i++)
    {
        cin>> a[i];
        if (a[i] < min[i - 1]) min[i] = a[i];
        else min[i] = min[i - 1];

        max = max < a[i] - min[i] ? a[i] - min[i] : max;
    }
    cout<< max;
	return 0;
}