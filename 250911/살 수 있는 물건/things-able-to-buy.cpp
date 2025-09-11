#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    // 변수 선언
    int n;

    // 입력
    cin >> n;
    
    // 출력
    if(n >= 3000)
        cout << "book" << endl;
    else if(n >= 1000)
        cout << "mask" << endl;
    else
        cout << "no" << endl;
    return 0;
}