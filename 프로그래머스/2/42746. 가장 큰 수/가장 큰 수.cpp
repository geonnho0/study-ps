#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> numbers) {
    vector<string> strs;
    for (int n : numbers)
        strs.push_back(to_string(n));
    sort(strs.begin(), strs.end(), [](const string& a, const string& b) {
        return a + b > b + a;
    });
    if (strs[0] == "0") return "0";
    string answer = "";
    for (string s : strs)
        answer += s;
    return answer;
}