#include <iostream>
#include <stack>

using namespace std;

int main()
{    
    int N; scanf("%d", &N);
    stack<pair<int, int> > st;

    for (int i = 1; i <= N; i++)
    {
        int num; scanf("%d", &num);

        while (!st.empty())
        {
            if (st.top().second > num)
            {
                printf("%d ", st.top().first);
                break;
            }
            st.pop();
        }
        if (st.empty())
        {
            printf("0 ");
        }
        st.push({i, num});
    }
    return 0;
}