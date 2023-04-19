def check():
    answer = 0
    while box:
        for c in crain:
            k = 0
            while k < len(box):
                if box[k] <= c:
                    del box[k]
                    break
                else:
                    if c < box[-1]:
                        i = len(crain)-1
                        while crain[i] <= c:
                            i -= 1
                            crain.pop()
                            if not crain:
                                return -1
                        break
                    else:
                        k += 1
        answer += 1
    return answer

n = int(input())
crain = sorted(list(map(int,input().split())),reverse=True)
m = int(input())
box = sorted(list(map(int,input().split())),reverse=True)
print(check())