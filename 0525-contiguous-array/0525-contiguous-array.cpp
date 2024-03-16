class Solution {
public:
    int findMaxLength(vector<int>& nums) {  
        int n = nums.size();
        int sum = 0, ans = 0;
        map<int, int> mp;
        mp[0] =  -1;
        for(int i=0; i < n; i++) {
            sum += nums[i];
            if(mp.find(2*sum-i-1) == mp.end()) {
                mp[2*sum-i-1] = i;
            }
    ans = max(ans, i - mp[2*sum - i - 1]);
    }
return  ans; 
    }
};