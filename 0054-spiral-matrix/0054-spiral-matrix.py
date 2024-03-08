class Solution(object):
    def spiralOrder(self, matrix):
        m, n = len(matrix), len(matrix[0])
        lowi, highi = 0, m
        lowj, highj = 0, n

        output = []
        while (lowi < highi and lowj < highj):
            # Case 1: left to right
            i = lowi
            for j in range(lowj, highj):
                output.append(matrix[i][j])
            lowi += 1

            # Case 2: top to bottom
            j = highj - 1
            for i in range(lowi, highi):
                output.append(matrix[i][j])
            highj -= 1

            # Case 3: right to left
            if(lowi < highi) :
                i = highi - 1
                for j in range(highj - 1, lowj - 1, -1):
                    output.append(matrix[i][j])
                highi -= 1

            # Case 4: bottom to up
            if(lowj < highj) :
                j = lowj
                for i in range(highi - 1, lowi - 1, -1):
                    output.append(matrix[i][j])
                lowj += 1
                       
        return output