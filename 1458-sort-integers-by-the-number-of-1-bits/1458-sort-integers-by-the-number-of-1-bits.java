class Solution {
    public int countOne(int num) {
        int count = 0;
        while(num != 0) {
            count += num % 2;
            num /= 2;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        Integer[] arrArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arrArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a1, Integer a2) {
                int c1 = countOne(a1);
                int c2 = countOne(a2);
                if(c1 == c2)
                    return a1 - a2;
                return c1 - c2;
            }
        });
        return Arrays.stream(arrArray).mapToInt(Integer::intValue).toArray();
        
    }
}