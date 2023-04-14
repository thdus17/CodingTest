#민겸수
#K가 끝임
#K는 5, M은 자리수?
#주어진 민겸수가 만들 수 있는 최대값 최소값

import sys

input = sys.stdin.readline

mk = input().rstrip()

#최소최대값 숫자 문자열
minN = ""
maxN = ""
#최소최대값 문자열
mkMin = ""
mkMax = ""

#최대값 최소값 구하기
for i in range(0, len(mk)) :
    mkMin += mk[i]
    mkMax += mk[i]
    #최대값으로 만들 문자열
    if mk[i] == "K" :
       n = len(mkMax)
       maxN += "5" + "0"*(n-1)
       mkMax = ""

    #최소값으로 만들 문자열
    if i != len(mk)-1 :
        if mk[i+1] =="M" and mk[i] =="M" :
            continue
        else :
            if mk[i] == "M" :
                minN += "1" + "0"*(len(mkMin)-1)
            else :
                minN += "5"
            mkMin = ""
#만약 mkMax 에 M이 남아있을 경우
if len(mkMax) > 0 :
    n = len(mkMax)
    maxN += "1"*n
if len(mkMin) > 0 :
    n = len(mkMin)
    if "K" not in mkMin :
        minN += "1" + "0"*(n-1)
    else :
        minN += "5"
print(maxN)
print(minN)