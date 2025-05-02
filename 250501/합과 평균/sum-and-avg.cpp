#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int A, B;
    cin >> A >> B;

    cout << fixed;
    cout.precision(1);
    cout << A+B << " "<< (double)(A+B)/2 <<endl;
    return 0;
}