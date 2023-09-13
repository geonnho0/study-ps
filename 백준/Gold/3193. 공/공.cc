#include<iostream>

#define MAXN 1001

using namespace std;

pair<int, int> dxdy[] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

int N, K;
char board[MAXN][MAXN];
pair<int, int> ball;

void input() {
    cin >> N >> K;
    scanf("%d %d", &N, &K);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            char item;
            cin >> item;
            if (item == 'L') {
                ball = {i, j};
                item = '.';
            }
            board[i][j] = item;
        }
    }
}

void solution() {
    int mode = 1;
    char cmd;
    for (int k = 0; k < K; k++) {
        cin >> cmd;
        if (cmd == 'L') {
            mode++;
            if (mode == 4) mode = 0;
        } else {
            mode--;
            if (mode == -1) mode = 3;
        }
        while (1) {
            int nextX = ball.first + dxdy[mode].first, nextY = ball.second + dxdy[mode].second;
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) break;
            if (board[nextX][nextY] == 'X') break;
            ball.first = nextX;
            ball.second = nextY;
        }
    }
    board[ball.first][ball.second] = 'L';
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (mode == 1) printf("%c", board[i][j]);
            else if (mode == 2) printf("%c", board[j][N-1-i]);
            else if (mode == 3) printf("%c", board[N-1-i][N-1-j]);
            else printf("%c", board[N-1-j][i]);
        }
        printf("\n");
    }
}

int main() {
    input();
    solution();
    return 0;
}