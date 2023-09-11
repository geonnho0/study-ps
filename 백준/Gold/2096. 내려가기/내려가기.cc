#include <iostream>
#include <algorithm>

using namespace std;

int N;
pair<int, int> arr[2][3];

int main() {
    cin >> N;
    cin >> arr[0][0].first >> arr[0][1].first >> arr[0][2].first;
    for (int j = 0; j < 3; j++)
        arr[0][j].second = arr[0][j].first;
    while (--N) {
        cin >> arr[1][0].first >> arr[1][1].first >> arr[1][2].first;
        for (int j = 0; j < 3; j++)
            arr[1][j].second = arr[1][j].first;
        arr[1][0].first += max(arr[0][0].first, arr[0][1].first);
        arr[1][0].second += min(arr[0][0].second, arr[0][1].second);
        arr[1][1].first += max(max(arr[0][0].first, arr[0][1].first), arr[0][2].first);
        arr[1][1].second += min(min(arr[0][0].second, arr[0][1].second), arr[0][2].second);
        arr[1][2].first += max(arr[0][1].first, arr[0][2].first);
        arr[1][2].second += min(arr[0][1].second, arr[0][2].second);
        for (int j = 0; j < 3; j++) {
            arr[0][j] = arr[1][j];
        }
    }
    cout << max(max(arr[0][0].first, arr[0][1].first), arr[0][2].first) << " "<< min(min(arr[0][0].second, arr[0][1].second), arr[0][2].second);
    return 0;
}