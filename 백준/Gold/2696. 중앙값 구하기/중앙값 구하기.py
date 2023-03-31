import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T) :
    M = int(input())
    n = M/10
    k = M%10
    arr = []
    cnt = 0
    while n > 0 :
        tmp = list(map(int, input().split())) #한 줄에 10개씩
        arr += tmp
        n -= 1
        if n==0 :
            tmp = list(map(int, input().split()))
            arr += tmp
    if M % 2 == 1 :
        cnt = M // 2 + 1
    else :
        cnt = M / 2
    print(cnt)
    i = 0
    res = []
    while cnt > i :
        tmp = arr[0:i*2+1]
        tmp.sort()
        res.append(tmp[i])
        i += 1
    if cnt / 10 > 1 :
        for j in range(1, (cnt // 10) + 2) :
            if j*10 > cnt :
                result = ' '.join(map(str, res[(j-1)*10:]))
                print(result)
                break
            result = ' '.join(map(str, res[(j-1)*10:j*10]))
            print(result)
    else :
        result = ' '.join(map(str, res))
        print(result)