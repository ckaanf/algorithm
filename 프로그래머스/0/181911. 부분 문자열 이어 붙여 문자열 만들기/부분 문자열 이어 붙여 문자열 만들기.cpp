#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<string> my_strings, vector<vector<int>> parts) {
    string answer = "";
    for (int i = 0; i < my_strings.size(); i++) {
        int start = parts[i][0];
        int end   = parts[i][1];
        answer += my_strings[i].substr(start, end - start + 1);
    }
    return answer;
}