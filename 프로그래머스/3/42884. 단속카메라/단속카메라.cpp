#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    sort(routes.begin(), routes.end(), [](const vector<int>& a, const vector<int>& b) {
        return a[1] < b[1];
    });
    int camera = routes[0][1];
    int answer = 1;
    for (auto r : routes) {
        if (r[0] > camera) {
            answer++;
            camera = r[1];
        }
    }
    return answer;
}
