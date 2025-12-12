class Solution(object):
    def countMentions(self, numberOfUsers, events):
        """
        :type numberOfUsers: int
        :type events: List[List[str]]
        :rtype: List[int]
        """
        mentions = [0] * numberOfUsers
        offline = [0] * numberOfUsers
        allCount = 0
        events = sorted(events, key = lambda event: (int(event[1]), event[0] != "OFFLINE"))
        print(events)
        for event in events:
            [status, timestamp, mString] = event

            if status == "OFFLINE":
                offline[int(mString)] = int(timestamp) + 60
            else:
                if mString == "ALL":
                    allCount = allCount + 1
                elif mString == "HERE":
                    for i in range(numberOfUsers):
                        if offline[i] <= int(timestamp):
                            mentions[i] = mentions[i] + 1
                else:
                    users = mString.replace("id", "").split(" ")
                    for user in users:
                        mentions[int(user)] = mentions[int(user)] + 1

        for i in range(numberOfUsers):
            mentions[i] = mentions[i] + allCount
        return mentions
        