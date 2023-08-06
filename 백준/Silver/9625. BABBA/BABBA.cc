#include<iostream>

using namespace std;

int main() {
    int k; cin>> k;
    int dpA[46], dpB[46];
    dpA[1] = 0; dpB[1] = 1;
    dpA[2] = 1; dpB[2] = 1;
    for (int i = 3; i <= k; i++)
    {
        dpA[i] = dpB[i - 1];
        dpB[i] = dpA[i - 1] + dpB[i - 1];
    }
    cout<< dpA[k]<< " "<< dpB[k]<< endl;
    return 0;
}