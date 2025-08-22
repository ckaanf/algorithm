#include <bits/stdc++.h>
using namespace std;

int arr[10];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    while (N > 0) {
        arr[N % 10]++;
        N /= 10;
    }

    int max_val = 0;
    for (int i = 0; i < 10; i++) {
        if (i == 6 || i == 9) {
            continue;
        }
        max_val = max(max_val, arr[i]);
    }
    max_val = max(max_val, (arr[6] + arr[9] + 1) / 2);
    cout << max_val << '\n';
}
