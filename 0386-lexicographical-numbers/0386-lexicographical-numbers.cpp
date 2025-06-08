class Solution {
vector<int> res;
public:
    void lexicalOrder(int prefix, int n) {
        for(int i = 0; i < 10; i++) {
            if(prefix * 10 + i <= n) {
                res.push_back(prefix * 10 + i);
                lexicalOrder(prefix * 10 + i, n);
            }
        }
        return;
    }
    vector<int> lexicalOrder(int n) {
        res.clear(); 
        for(int i = 1; i < 10; i++) {
            if(i <= n) {
                res.push_back(i);
                lexicalOrder(i, n);
            }
        }
        return res;
    }
};