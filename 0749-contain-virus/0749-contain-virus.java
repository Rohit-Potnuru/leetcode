class Solution {
    public void dfs(int[][] isInfected, int v,int x, int y) {
        int m = isInfected.length, n = isInfected[0].length;
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] neighbor: neighbors) {
            int dx = x + neighbor[0], dy = y + neighbor[1];
            if(  0 <= dx && dx < m 
              && 0 <= dy && dy < n && isInfected[dx][dy] == 1) {
                isInfected[dx][dy] = v;
                dfs(isInfected, v, dx, dy);
            }
        }
    }

    public int[][] totalRegions(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isInfected[i][j] > 0) {
                    isInfected[i][j] = 1;
                }
            }
        }
        int v = 2;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isInfected[i][j] == 1) {
                    isInfected[i][j] = v;
                    dfs(isInfected, v, i, j);
                    v++;
                }
            }
        }
        return new int[2][v - 2];
    }

    public void quarantineVirus(int[][] isInfected, int v) {
        int m = isInfected.length, n = isInfected[0].length;
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(isInfected[x][y] == v) {
                    isInfected[x][y] = -1;
                }
            }
        }
    }

    public void spreadVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(isInfected[x][y] > 0) {
                    for(int[] neighbor: neighbors) {
                        int dx = x + neighbor[0], dy = y + neighbor[1];
                        if( 0 <= dx && dx < m 
                         && 0 <= dy && dy < n && isInfected[dx][dy] == 0) {
                            isInfected[dx][dy] = -isInfected[x][y];
                        }
                    }
                }
            }
        }
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(isInfected[x][y] != -1) {
                    isInfected[x][y] = Math.abs(isInfected[x][y]);
                }
            }
        }
    }

    public void getBoundaries(int[][] isInfected, int[][] regions) {
        int m = isInfected.length, n = isInfected[0].length;
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        HashSet<Integer> hashset = new HashSet<>();

        for(int i = 0; i < regions[0].length; i++) {
            regions[0][i] = 0;
            regions[1][i] = 0;
        }

        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(isInfected[x][y] == 0) {
                    hashset.clear();
                    for(int[] neighbor: neighbors) {
                        int dx = x + neighbor[0], dy = y + neighbor[1];
                        if( 0 <= dx && dx < m 
                            && 0 <= dy && dy < n && isInfected[dx][dy] > 0) {
                            if(!hashset.contains(isInfected[dx][dy])) {
                                hashset.add(isInfected[dx][dy]);
                                regions[0][isInfected[dx][dy] - 2] += 1;
                            }
                            regions[1][isInfected[dx][dy] - 2] += 1;
                        }
                    }
                }
            }
        }
    }

    public int getMaxIdx(int[] regions) {
        int max = 0, maxIdx = -1;
        for(int i = 0; i < regions.length; i++) {
            if(max < regions[i]) {
                max = regions[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public void print(int[][] isInfected) {
        for(int i = 0; i < isInfected.length; i++) {
            System.out.println(Arrays.toString(isInfected[i]));
        }
        System.out.println("");
    }

    public int containVirus(int[][] isInfected) {
        int walls = 0;
        int[][] regions;
        regions = totalRegions(isInfected);
        getBoundaries(isInfected, regions);
        int maxIdx = getMaxIdx(regions[0]);
        print(isInfected);
        while(maxIdx >= 0) {
            walls += regions[1][maxIdx];
            System.out.println("cellsSpread: " + Arrays.toString(regions[0]) + " " + maxIdx);
            System.out.println("wallsSpread: " + Arrays.toString(regions[1]) + " " + maxIdx);
            quarantineVirus(isInfected, maxIdx + 2);
            spreadVirus(isInfected);
            regions = totalRegions(isInfected);
            getBoundaries(isInfected, regions);
            print(isInfected);
            maxIdx = getMaxIdx(regions[0]);
        }
        return walls;
    }
}


// class Solution {
//     public void dfs(int[][] isInfected, int v,int x, int y) {
//         int m = isInfected.length, n = isInfected[0].length;
//         int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//         for(int[] neighbor: neighbors) {
//             int dx = x + neighbor[0], dy = y + neighbor[1];
//             if(  0 <= dx && dx < m 
//               && 0 <= dy && dy < n && isInfected[dx][dy] == 1) {
//                 isInfected[dx][dy] = v;
//                 dfs(isInfected, v, dx, dy);
//             }
//         }
//     }

//     public int[] totalRegions(int[][] isInfected) {
//         int m = isInfected.length, n = isInfected[0].length;
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(isInfected[i][j] > 0) {
//                     isInfected[i][j] = 1;
//                 }
//             }
//         }
//         int v = 2;
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(isInfected[i][j] == 1) {
//                     isInfected[i][j] = v;
//                     dfs(isInfected, v, i, j);
//                     v++;
//                 }
//             }
//         }
//         return new int[v - 2];
//     }

//     public void quarantineVirus(int[][] isInfected, int v) {
//         int m = isInfected.length, n = isInfected[0].length;
//         for(int x = 0; x < m; x++) {
//             for(int y = 0; y < n; y++) {
//                 if(isInfected[x][y] == v) {
//                     isInfected[x][y] = -1;
//                 }
//             }
//         }
//     }

//     public void spreadVirus(int[][] isInfected) {
//         int m = isInfected.length, n = isInfected[0].length;
//         int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//         for(int x = 0; x < m; x++) {
//             for(int y = 0; y < n; y++) {
//                 if(isInfected[x][y] > 0) {
//                     for(int[] neighbor: neighbors) {
//                         int dx = x + neighbor[0], dy = y + neighbor[1];
//                         if( 0 <= dx && dx < m 
//                          && 0 <= dy && dy < n && isInfected[dx][dy] == 0) {
//                             isInfected[dx][dy] = -isInfected[x][y];
//                         }
//                     }
//                 }
//             }
//         }
//         for(int x = 0; x < m; x++) {
//             for(int y = 0; y < n; y++) {
//                 if(isInfected[x][y] != -1) {
//                     isInfected[x][y] = Math.abs(isInfected[x][y]);
//                 }
//             }
//         }
//     }

//     public void getBoundaries(int[][] isInfected, int[] regions) {
//         int m = isInfected.length, n = isInfected[0].length;
//         int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//         int count;
//         for(int i = 0; i < regions.length; i++) {
//             regions[i] = 0;
//         }
//         for(int x = 0; x < m; x++) {
//             for(int y = 0; y < n; y++) {
//                 if(isInfected[x][y] > 0) {
//                     count = 0;
//                     for(int[] neighbor: neighbors) {
//                         int dx = x + neighbor[0], dy = y + neighbor[1];
//                         if( 0 <= dx && dx < m 
//                             && 0 <= dy && dy < n && isInfected[dx][dy] == 0) {
//                             count++;
//                         }
//                     }
//                     regions[isInfected[x][y] - 2] += count;
//                 }
//             }
//         }
//     }

//     public int getMaxIdx(int[] regions) {
//         int max = 0, maxIdx = -1;
//         for(int i = 0; i < regions.length; i++) {
//             if(max < regions[i]) {
//                 max = regions[i];
//                 maxIdx = i;
//             }
//         }
//         return maxIdx;
//     }

//     public void print(int[][] isInfected) {
//         for(int i = 0; i < isInfected.length; i++) {
//             System.out.println(Arrays.toString(isInfected[i]));
//         }
//         System.out.println("");
//     }

//     public int containVirus(int[][] isInfected) {
//         int walls = 0;
//         int[] regions;
//         regions = totalRegions(isInfected);
//         getBoundaries(isInfected, regions);
//         int maxIdx = getMaxIdx(regions);
//         print(isInfected);
//         while(maxIdx >= 0) {
//             walls += regions[maxIdx];
//             System.out.println("cellsSpread: " + Arrays.toString(regions) + " " + maxIdx);
//             quarantineVirus(isInfected, maxIdx + 2);
//             spreadVirus(isInfected);
//             regions = totalRegions(isInfected);
//             getBoundaries(isInfected, regions);
//             print(isInfected);
//             maxIdx = getMaxIdx(regions);
//         }
//         return walls;
//     }
// }