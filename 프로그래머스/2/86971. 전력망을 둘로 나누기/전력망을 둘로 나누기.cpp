#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> parent;

void initialize(int n) {
    parent = vector<int>(n + 1);
    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }
}

int find(int x) {
    if (parent[x] == x)
        return x;
    return parent[x] = find(parent[x]);
}

void unionNodes(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);
    if (aRoot != bRoot)
        parent[bRoot] = aRoot;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 1000000000;
    int len = wires.size();
    for (int i = 0; i < len; i++) {
        initialize(n);
        for (int j = 0; j < len; j++) {
            if (i != j) {
                unionNodes(wires[j][0], wires[j][1]);
            }
        }
        
        int count1 = 1;
        int count2 = 0;
        int temp = find(1);
        for (int j = 2; j <= n; j++) {
            if (temp == find(j)) count1++;
            else count2++;
        }
        answer = min(answer, abs(count1 - count2));
    }
    return answer;
}
