#include <iostream>
#include <string>
#include <cmath>

using namespace std;

void hanoi(int num, int from, int tmp, int to) {
    if (num == 1)
        printf("%d %d\n", from, to);
    else
    {
        hanoi(num - 1, from, to, tmp);
        printf("%d %d\n", from, to);
        hanoi(num - 1, tmp, from, to);
    }
}

int main()
{
    int N; cin >> N;
    string str = to_string(pow(2, N));
    int point = str.find('.');
    str = str.substr(0, point);
    str[str.length() - 1] -= 1;
    cout << str << "\n";

    if (N <= 20)
        hanoi(N, 1, 2, 3);
	return 0;
}