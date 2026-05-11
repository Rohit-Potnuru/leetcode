from collections import defaultdict
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        inDegree = [0] * numCourses
        adjMap = defaultdict(list)

        for course, pre in prerequisites:
            inDegree[course] += 1
            adjMap[pre].append(course)
        
        res = []
        queue = deque(i for i in range(numCourses) if inDegree[i] == 0)
        while queue:
            curr = queue.popleft()
            res.append(curr)
            for neighbor in adjMap[curr]:
                inDegree[neighbor] -= 1
                if inDegree[neighbor] == 0:
                    queue.append(neighbor)
        return res if len(res) == numCourses else []