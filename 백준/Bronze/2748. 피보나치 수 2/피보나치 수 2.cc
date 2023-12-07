#include<iostream>
using namespace std;

int main() {

    int n;
    long long curr = 0;
    cin >> n;

    long long temp = 0;
    long long prev = 1;
    if (n <= 1) curr = n;
    else {
        for (int i=0; i<n; i++) {
            temp = curr;
            curr += prev;
            prev = temp;
        }
    }
    cout << curr;
}