#include <vector>
using namespace std;

vector<int> solution(int n, int k) {
    // n/k 만큼 결과가 나올 것이므로 미리 공간 확보
    int count = n / k;
    vector<int> answer;
    answer.reserve(count);

    // k의 배수들을 push
    for (int multiple = k; multiple <= n; multiple += k) {
        answer.push_back(multiple);
    }

    return answer;
}
