#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> dist(20001, 50001);

void bfs(int n, int start, vector<vector<int>>& edge) {
    queue<int> q;
    dist[start] = 0;
    q.push(start);
    
    while (!q.empty()) {
        int now = q.front(); q.pop();
        
        for (auto& next : edge[now]) {
            if (dist[next] == 50001) {
                dist[next] = dist[now] + 1;
                q.push(next);
            }
        }
    }
}

int solution(int n, vector<vector<int>> edge) {
    vector<vector<int>> graph(20001);
    for (auto& e : edge) {
        graph[e[0]].push_back(e[1]);
        graph[e[1]].push_back(e[0]);
    }
    bfs(n, 1, graph);
    int answer = 0, count = 0;
    int maxLength = *max_element(dist.begin() + 1, dist.begin() + n + 1);
    for (int d : dist)
        if (d == maxLength)
            answer++;
    return answer;
}
