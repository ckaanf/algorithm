#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int a;
    int b;

    cin >> a >> b;
    if (a > b) {
        return a * b;
    } else {
        return a / b;
    }
    return 0;
}