#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    int a = n;
    while (a > 1) {
        if(a % 2 == 0) {
            answer.push_back(a);
            a = a/2;
        } else {
            answer.push_back(a);
            a = 3 * a + 1;
        }
    }
    
    answer.push_back(1);
    
    return answer;
}