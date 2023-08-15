#include <iostream>
#include <cmath>

using namespace std;

int N, ans = 0;
int board[16] = {0};

bool isValid(int row)
{
    for (int i = 0; i < row; i++) {
		if (board[row] == board[i] || row - i == abs(board[row] - board[i]))
        {
			return false;
		}
	}
	return true;
}

void check(int row)
{
    if (row == N)
    {
        ans++;
        return;
    }

    for (int i = 0; i < N; i++)
    {
        board[row] = i;
        if (isValid(row))
            check(row + 1);
    }
}

int main()
{
    cin >> N;
    check(0);
    cout << ans;
	return 0;
}