#include <string>
#include <vector>
#include <stdio.h>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    int last = num_list[num_list.size() - 1];
    int preLast = num_list[num_list.size()- 2];
    int a;
    if (last > preLast) {
         a = last - preLast;
    } else {
         a = last * 2;
    }
    num_list.push_back(a);
    return num_list;
}