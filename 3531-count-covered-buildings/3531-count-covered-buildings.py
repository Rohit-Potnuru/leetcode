class Solution(object):
    def countCoveredBuildings(self, n, buildings):
        """
        :type n: int
        :type buildings: List[List[int]]
        :rtype: int
        """
        buildings = sorted(buildings, key = lambda x: (x[0], x[1]))
        xbuildingsMap = dict()
        ybuildingsMap = dict()
        for [x, y] in buildings:
            if x not in xbuildingsMap:
                xbuildingsMap[x] = []
            if y not in ybuildingsMap:
                ybuildingsMap[y] = []
            xbuildingsMap[x].append(y)
            ybuildingsMap[y].append(x)
        
        edgeSet = set()
        xKeys = xbuildingsMap.keys()
        for xKey in xKeys:
            edgeSet.add((xKey, xbuildingsMap[xKey][0]))
            edgeSet.add((xKey, xbuildingsMap[xKey][-1]))

        yKeys = ybuildingsMap.keys()
        for yKey in yKeys:
            edgeSet.add((ybuildingsMap[yKey][0], yKey))
            edgeSet.add((ybuildingsMap[yKey][-1], yKey))
        return len(buildings) - len(edgeSet)


"""         
[[1,2],[2,2],[3,2],[2,1],[2,3]]

3   X
2 X X X
1   X
  1 2 3
"""