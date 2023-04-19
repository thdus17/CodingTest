#항구에 크레인 N대 1분에 박스를 하나씩 배에 실을 수 있다
#모든 크레인은 동시에 움직임
#무게 제한 있음, 제한보다 무거운 박스를 크레인으로 옮길 수 없음
#모든 박스를 배로 옮기는데 드는 시간의 최소값

import sys
input = sys.stdin.readline

N = int(input()) #크레인 개수
nArr = list(map(int, input().split())) #무게제한
M = int(input()) #박스 개수
mArr = list(map(int, input().split())) #박스 무게

nArr.sort(reverse=True)
mArr.sort(reverse=True)


if mArr[0] > nArr[0] :
    print(-1)
    
else :
    time = 0
    while mArr :
        for i in nArr :
            for j in mArr :
                if i >= j :
                    mArr.remove(j)
                    break
        time += 1
    print(time)





