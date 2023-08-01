#include<iostream>

long ans1 = 0;
int ans2 = 0;
long fib[42];

long fib1(int x) {
    if (x <= 2) {
        ans1++;
        return 1;
    }
    return fib1(x - 1) + fib1(x - 2);
}

void makeFib(int x) {
    fib[1] = fib[2] = 1;
    for (int i = 3; i <= x; i++) {
        ans2++;
        fib[i] = fib[i - 1] + fib[i - 2];
    }
}

int main() {
    int n;
    scanf("%d", &n);
    fib1(n);
    makeFib(n);
    printf("%ld %d\n", ans1, ans2);
}