#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numLog) {
    string answer = "";
    for(int i = 0; i < numLog.size() - 1; i++) {
        int diff = numLog[i+1] - numLog[i];
        if (diff == 1) {
            answer = answer + "w";
        } else if (diff == -1) {
            answer = answer + "s";
        } else if (diff == 10) {
            answer = answer + "d";
        } else {
            answer = answer + "a";
        }
    }
    return answer;
}