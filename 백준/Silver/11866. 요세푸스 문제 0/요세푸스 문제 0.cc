#include<iostream>
#include<vector>

using namespace std;

int main() {
    int n, k;

    cin >> n >> k;

    vector<int> peopleToKill(n, 1);
    vector<int> survived(n, 0);
    vector<int> ans;

    int kill = k;
    int i = k - 1;
    
    while (!survived.empty()) {
        if (kill == k) {
            survived.pop_back();
            peopleToKill[i] = 0;
            ans.push_back(i + 1);
            kill = 0;
        }

        i = (i == peopleToKill.size() - 1) ? 0 : i+1;

        if (peopleToKill[i]) kill++;
    }

    cout << "<";
    for (int j=0; j<ans.size() - 1; j++) cout << ans[j] << ", ";
    cout << ans.back() << ">";
}