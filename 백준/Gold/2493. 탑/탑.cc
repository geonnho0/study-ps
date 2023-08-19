#include <iostream>
#include <stack>

using namespace std;

int main()
{    
    cin.tie(0);
    ios_base::sync_with_stdio(false);
    int N; cin >> N;
    stack<pair<int, int> > st;

    for (int i = 1; i <= N; i++)
    {
        int num; cin >> num;

        while (!st.empty())
        {
            if (st.top().second > num)
            {
                cout << st.top().first << " ";
                break;
            }
            st.pop();
        }
        if (st.empty())
        {
            cout << "0 ";
        }
        st.push({i, num});
    }
    return 0;
}