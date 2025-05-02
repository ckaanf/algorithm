#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int a, b, c;
    int hap;
    double avg;
    int cha;

    cin >> a >> b >> c;
    hap = a + b + c;
    avg = (hap) / 3;
    cha = hap - avg;

    cout << hap << endl;
    cout << avg << endl;
    cout << cha << endl;
    return 0;
}