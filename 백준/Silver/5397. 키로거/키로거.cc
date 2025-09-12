#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    string s;

    while (N--) {
        cin >> s;
        list<char> L;
        auto it = L.begin();

        for (char c: s) {
            if (c == '<') {
                if (it != L.begin()) {
                    --it;
                }
            } else if (c == '>') {
                if (it != L.end()) {
                    ++it;
                }
            } else if (c == '-') {
                if (it != L.begin()) {
                    auto it2 = it;
                    --it2;
                    L.erase(it2);
                }
            } else {
                L.insert(it, c);
            }
        }
        for (char c: L) {
            cout << c;
        }
        cout << '\n';
    }
    return 0;
}
