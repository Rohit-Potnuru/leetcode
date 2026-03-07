class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        adjMap = dict()
        for gene1 in bank:
            for gene2 in bank:
                count = 0
                for c in range(len(gene1)):
                    count += gene1[c] != gene2[c]
                if count == 1:
                    if gene1 not in adjMap:
                        adjMap[gene1] = []
                    adjMap[gene1].append(gene2)
                    if gene2 not in adjMap:
                        adjMap[gene2] = []
                    adjMap[gene2].append(gene1)
        
        q = deque()
        visitedGene = set()
        for gene in bank:
            count = 0
            for c in range(len(gene)):
                count += gene[c] != startGene[c]
            if count == 1:
                visitedGene.add(gene)
                q.append(gene)
        count = 0
        while len(q) > 0:
            size = len(q)
            count += 1
            while size > 0:
                gene = q.popleft()
                if gene == endGene:
                    return count
                if gene in adjMap:
                    for childGene in adjMap[gene]:
                        if childGene not in visitedGene:
                            visitedGene.add(childGene)
                            q.append(childGene)
                size -= 1
        return -1
