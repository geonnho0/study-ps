#include<iostream>
#include<queue>

using namespace std;

int main() {
    string number1, number2;
    cin>> number1;
    cin>> number2;
    queue<int> que;
    for (int i = 0; i < number1.size(); i++) {
        que.push(number1[i] - '0');
        que.push(number2[i] - '0');
    }
    for (int i = 0; i < 14; i++) {
        for (int j = 0; j < 15 - i; j++) {
            int a = que.front(); que.pop();
            int b = que.front();
            que.push((a + b) % 10);
        }
        que.pop();
    }
    while (!que.empty()) {
        cout<< que.front(); que.pop();
    }
}