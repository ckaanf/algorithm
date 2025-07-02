#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int a;
    int b;
    int result;

    cin >> a >> b;
    if (a > b) {
        result =  a * b;
    } else {
        result = b / a;
    }

    cout << result << endl;
}