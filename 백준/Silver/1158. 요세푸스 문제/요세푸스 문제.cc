#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    queue<int> q;
    for (int i = 1; i <= N; i++) {
        q.push(i);
    }

    vector<int> result;
    result.reserve(N);

    while (!q.empty()) {
        // K-1 번 회전
        for (int i = 1; i < K; i++) {
            int x = q.front();
            q.pop();
            q.push(x);
        }
        // K번째 사람 제거
        result.push_back(q.front());
        q.pop();
    }

    // 출력 형식 맞추기
    cout << "<";
    for (int i = 0; i < N; i++) {
        cout << result[i];
        if (i != N - 1) cout << ", ";
    }
    cout << ">\n";

    return 0;
}
