class Solution:
    def constructAdjMap(self, equations: List[List[str]], values: List[float]):
        adjMap = dict()
        for edge, cost in zip(equations, values):
            fromNode, toNode = edge
            if not(fromNode in adjMap):
                adjMap[fromNode] = []
            adjMap[fromNode].append((toNode, cost))

            if not(toNode in adjMap):
                adjMap[toNode] = []
            adjMap[toNode].append((fromNode, 1.0/cost))
        return adjMap

    def dfs(self, adjMap, nodeState, node, val, grpId): 
        for toNode, cost in adjMap[node]:
            if toNode not in nodeState:
                nodeState[toNode] = (grpId, val / cost)
                self.dfs(adjMap, nodeState, toNode, val / cost, grpId)

    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        adjMap = self.constructAdjMap(equations, values)

        totalNodes = len(adjMap)
        nodeState = {}
        grpId = 0
        for node in adjMap:
            if node not in nodeState:
                val = 1.0
                grpId += 1
                nodeState[node] = (grpId, val)
                self.dfs(adjMap, nodeState, node, val, grpId)
        print(nodeState)
        res = []
        for fromNode, toNode in queries:
            if (fromNode in nodeState) and (toNode in nodeState) and nodeState[fromNode][0] == nodeState[toNode][0]:
                res.append(nodeState[fromNode][1]/nodeState[toNode][1])
            else:
                res.append(-1.0)
        return res
"""
a = 2.0b

a/b = 2.0.   
 |
b/c = 3.0
c = b/3.0

a/c
b/a
a/e
a/a
x/x

O(E)
O(Ve)

O(E)
"""