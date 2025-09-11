#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int N;
    cin >> N;

    if (N >= 100) {
        cout << "vapor";
    } else if (N < 0) {
        cout << "ice";
    } else {
        cout << "water";
    }
    return 0;
}