#include <iostream>
#include <queue>

using namespace std;

int main()
{    
    int N, K; cin >> N >> K;
    queue<int> que;
    for (int i = 1; i <= N; i++)
        que.push(i);

    int index = 0;
    if (que.size() == 1)
    {
        printf("<%d>", que.front());
    }
    else
    {
        while (!que.empty())
        {
            int curr = que.front(); que.pop();
            index++;
            if (index == K)
            {
                index = 0;
                if (que.size() == N - 1)
                {
                    printf("<%d, ", curr);
                }
                else if (que.empty())
                {
                    printf("%d>", curr);
                }
                else
                {
                    printf("%d, ", curr);
                }
            }
            else
            {
                que.push(curr);
            }
        }
    }
    return 0;
}