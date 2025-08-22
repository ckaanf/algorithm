#include <bits/stdc++.h>
using namespace std;

#define FASTIO ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)

int freq[26];

int main() {
    FASTIO;

    string s;
    cin >> s;

    for (const auto c: s) {
        freq[c - 'a']++;
    }

    for (const int i : freq) {
        cout << i << " ";
    }
    return 0;
}
