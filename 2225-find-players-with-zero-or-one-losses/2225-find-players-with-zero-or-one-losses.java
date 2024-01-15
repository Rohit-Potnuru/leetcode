class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer>[] lose = new HashSet[3];
        for(int i = 0; i < 3; i++) lose[i] = new HashSet<>();
        int winner, loser;
        boolean flag;
        for(int i = 0; i < matches.length; i++) {
            winner = matches[i][0];
            loser = matches[i][1];

            //adding winner
            if(!lose[2].contains(winner) && !lose[1].contains(winner)) {
                lose[0].add(winner);
            }

            flag = true;
            for(int j = 0; j < 3; j++) {
                if(lose[j].contains(loser)) {
                    lose[j].remove(loser);
                    lose[Math.min(j + 1, 2)].add(loser);
                    flag = false;
                    break;
                }
            }
            if(flag) lose[1].add(loser);
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(lose[0]));
        ans.add(new ArrayList<>(lose[1]));
        Collections.sort(ans.get(0)); 
        Collections.sort(ans.get(1)); 
        return ans;
    }
}