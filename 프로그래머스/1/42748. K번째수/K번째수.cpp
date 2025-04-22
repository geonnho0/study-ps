#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> subVector(vector<int>& array, int i, int j) {
    return vector<int>(array.begin() + i, array.begin() + j);
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for (auto& c : commands) {
        vector<int> temp = subVector(array, c[0] - 1, c[1]);
        sort(temp.begin(), temp.end());
        answer.push_back(temp[c[2] - 1]);
    }
    return answer;
}
