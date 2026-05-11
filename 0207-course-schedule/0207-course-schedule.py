from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0] * numCourses
        adjMap =  defaultdict(list)
        for course, preCourse in prerequisites:
            inDegree[course] += 1
            adjMap[preCourse].append(course)
        
        def getLeafCourse():
            res = []
            for course, degree in enumerate(inDegree):
                if degree == 0:
                    res.append(course)
            return res

        courses = getLeafCourse()
        totalCourse = len(courses)
        queue = deque(courses)
        while len(queue) > 0:
            curr = queue.popleft()
            inDegree[curr] -= 1
            for course in adjMap[curr]:
                inDegree[course] -= 1
                if inDegree[course] == 0:
                    queue.append(course)
                    totalCourse += 1
            courses = getLeafCourse()
        return totalCourse == numCourses