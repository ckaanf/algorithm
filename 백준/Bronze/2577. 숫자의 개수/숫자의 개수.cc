#include <bits/stdc++.h>
using namespace std;

int arr[10];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int A, B, C;
    cin >> A >> B >> C;

    int multiply = A * B * C;

    while (multiply > 0) {
        arr[multiply % 10]++;
        multiply /= 10;
    }

    for (const int i : arr) {
        cout << i << '\n';
    }
}
