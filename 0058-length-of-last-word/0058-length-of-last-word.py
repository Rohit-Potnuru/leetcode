class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        x=-1
        
        for i in range(len(s)):
            
            if s[i]==' ' and i<len(s)-1 and s[i+1]!=' ':
                x=i
        if x==-1 and len(s)==0:
            return 0
        else:
            i=len(s)-1
            c=0
            while(s[i]==' 'and i>=0):
                c=c+1
                i=i-1
                
            return len(s)-1-x-c
        
        