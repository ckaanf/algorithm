#include <bits/stdc++.h>
using namespace std;

#define FASTIO ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)

int main() {
    FASTIO;

    string s;
    cin >> s;
    // 문제 풀이 코드
    for (char a = 'a'; a <= 'z'; a++) {
        int count = 0;
        for (auto c: s) {
            if (a == c) count++;
        }
        cout << count << ' ';
    }
    return 0;
}
