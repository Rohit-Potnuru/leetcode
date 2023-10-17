class Solution {
    public int find(int i,int[] unionFindArray) {
        while(unionFindArray[i] >= 0) {
            i = unionFindArray[i];
        }
        return i;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] unionFindArray = new int[n];
        int curr, left, right;
        for(int i = 0; i < n; i++)
            unionFindArray[i] = -1;
        
        for(int i = 0; i < n; i++) {
            left = leftChild[i];
            right = rightChild[i];
            if((left >= 0 && unionFindArray[left] >= 0) || (right >= 0 && unionFindArray[right] >= 0))
                return false;
            
            curr = find(i,unionFindArray);
            if(left >= 0) {
                unionFindArray[curr] += unionFindArray[left];
                unionFindArray[left] = curr;
            }

            if(right >= 0) {
                unionFindArray[curr] += unionFindArray[right];
                unionFindArray[right] = curr;
            }
            
        }

        for(int i = 0; i < n; i++)
            if(unionFindArray[i] < 0 && -unionFindArray[i] == n)
                return true;
        return false;
    }
}

/*
0 1 2

*/