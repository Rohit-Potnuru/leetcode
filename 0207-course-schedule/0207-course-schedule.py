from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0] * numCourses
        adjMap =  defaultdict(list)
        for course, preCourse in prerequisites:
            inDegree[course] += 1
            adjMap[preCourse].append(course)

        completed = 0
        queue = deque(i  for i in range(numCourses) if inDegree[i] == 0)
        while queue:
            curr = queue.popleft()
            completed += 1
            for neighbor in adjMap[curr]:
                inDegree[neighbor] -= 1
                if inDegree[neighbor] == 0:
                    queue.append(neighbor)
        return completed == numCourses