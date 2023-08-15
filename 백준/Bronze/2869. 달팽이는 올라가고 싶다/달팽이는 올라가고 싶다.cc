#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    int A, B, V; cin >> A >> B >> V;
    int ans = ceil((double) (V - B) / (A - B));
    cout << ans;
	return 0;
}