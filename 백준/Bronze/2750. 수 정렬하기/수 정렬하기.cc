#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int N; cin >> N;
    
    vector<int> arr;

    while (N--)
    {
        int num; cin >> num;
        arr.push_back(num);
    }

    sort(arr.begin(), arr.end());

    for (auto it: arr)
        cout << it << endl;

	return 0;
}