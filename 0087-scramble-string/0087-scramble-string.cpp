class Solution {
public:
    bool hashEqual(int h1[256], int h2[256]){
        for(int i=0; i<256; i++){
            if(h1[i] != h2[i]) return false;
        }
        return true;
    }
    
    int scrambleIndex(string s1, string s2){
        int hash[256] = {0};
        for(int i=0; i<s1.length(); i++){
            hash[s1[i]]++;
            hash[s2[i]]--;
            for(int i=0; i<256; i++){
                if(hash[i] != 0) continue;
            }
            return i;
        }
        return -1;
    }

    string reverseString(string s){
        int l=0;
        int r= s.length()-1;
        for(l=0; l<r; l++, r--){
            char buf = s[l];
            s[l] = s[r];
            s[r] = buf;
        }
        return s;
    }

    bool isScramble(string s1, string s2) {
        
        if(s1.compare(s2) == 0) return true;
        
        int size = scrambleIndex(s1,s2);
        if(size == -1) return false;
        if(size == s1.length())
        s2 = reverseString(s2);
        size = scrambleIndex(s1, s2);

        int len = s1.length();
        string l1 = s1.substr(0, size);
        string l2 = s2.substr(0, size);
        string r1 = s1.substr(size, len-size);
        string r2 = s1.substr(size, len-size);

        return isScramble(l1,l2) && isScramble(r1,r2);
    }
};