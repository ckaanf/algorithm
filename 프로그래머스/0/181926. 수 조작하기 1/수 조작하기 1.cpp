#include <string>
#include <vector>
#include <stdio.h>

using namespace std;

int solution(int n, string control) {
    int answer = 0;
    for (auto str : control) {
        switch(str) {
            case 'w' : n=n+1; break;
            case 's' : n=n-1; break;
            case 'd' : n=n+10; break;
            case 'a' : n=n-10; break;
        }
    }
    
    return n;
}