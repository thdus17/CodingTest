import sys

input = sys.stdin.readline

n = int(input())

stk = []

for _ in range(n) :
    txt = input().rstrip()
    if "push" in txt :
        num = txt.split(' ')[1]
        num = int(num)
        stk.append(num)
    elif "pop" == txt :
        if len(stk) == 0:
            print(-1)
        else :
            print(stk.pop())
    elif "size" == txt :
        print(len(stk))
    elif "empty" == txt :
        if len(stk) == 0:
            print(1)
        else :
            print(0)
    elif "top" == txt :
        if len(stk) == 0:
            print(-1)
        else :
            print(stk[-1])