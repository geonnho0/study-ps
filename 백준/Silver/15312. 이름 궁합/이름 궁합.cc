#include <iostream>

using namespace std;

int getCount(char c)
{
    switch (c)
    {
    case 'A':
    case 'E':
    case 'F':
    case 'H':
    case 'I':
        return 3;
    case 'B':
    case 'D':
    case 'G':
    case 'J':
    case 'K':
    case 'M':
    case 'N':
    case 'P':
    case 'Q':
    case 'R':
    case 'T':
    case 'X':
    case 'Y':
        return 2;
    case 'C':
    case 'L':
    case 'O':
    case 'S':
    case 'U':
    case 'V':
    case 'W':
    case 'Z':
        return 1;
    default:
        return -1;
    }
}

int main()
{
    string A, B;
	cin >> A;
    cin >> B;
    int dp[4002];
    int aLength = A.length();
    for (int i = 0; i < aLength; i++)
    {
        int countA = getCount(A[i]);
        int countB = getCount(B[i]);
        dp[2 * i] = countA;
        dp[2 * i + 1] = countB;
    }
    int jMax = 2 * aLength - 2, iMax = 2 * aLength;
    for (int j = 0; j < jMax; j++)
        for (int i = 0; i < iMax - j; i++)
        {
            dp[i] = (dp[i] + dp[i + 1]) % 10;
            
        }
    
    for (int i = 0; i < 2; i++)
        cout<< dp[i];
	return 0;
}