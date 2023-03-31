import sys
input = sys.stdin.readline
from heapq import heappop,heappush
from collections import defaultdict


N = int(input())
min_heap = []
max_heap = []
in_list = defaultdict(bool) #value 타입 bool 로 제한
for _ in range(N):
    P, L = map(int, input().split())
    heappush(min_heap,[L,P]) #쉬운 문제 추천을 위한 heap
    heappush(max_heap,[-L,-P]) #어려운 문제 추천을 위한 heap
    in_list[P] = True #해당 문제 번호를 키로 True 값 넣기
#in_list 딕셔너리
M = int(input())
for _  in range(M):
    command = input().split()
    if command[0]=='recommend':
        if command[1]=='1':
            while not in_list[-max_heap[0][1]]: #False 처리된 애들 차례로 뱉어내기
                heappop(max_heap)
            print(-max_heap[0][1])
        else:
            while not in_list[min_heap[0][1]]: #False 처리된 애들 차례로 뱉어내기
                heappop(min_heap)
            print(min_heap[0][1])
    elif command[0]=='solved': #푼 문제 False 로 값 변경
        in_list[int(command[1])] = False
    else:
        P = int(command[1])
        L = int(command[2])
        # 같은 번호의 다른 난이도 문제가 삽입되어 이미 죽은 문제인데 True로 나와 출력되는 것을 방지.
        while not in_list[-max_heap[0][1]]:
            heappop(max_heap)
        while not in_list[min_heap[0][1]]:
            heappop(min_heap)
        in_list[P] = True
        heappush(max_heap,[-L,-P])
        heappush(min_heap,[L,P])