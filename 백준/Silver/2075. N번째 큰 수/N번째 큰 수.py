import heapq

heap = []
n = int(input()) #n 크기 입력

for _ in range(n): #n번 입력받아서 heap에 최대값 5개 넣어두기
    numbers = map(int, input().split()) #5개 입력받기
    for number in numbers: 
        if len(heap) < n: # heap의 크기를 n개로 유지, 크기가 n 미만일 경우 계속 넣기
            heapq.heappush(heap, number)
        else: #아니라면 heap의 최소값과 입력받은 값 비교해서 넣어주기, heapq 이기에 0번째 값이 제일 작은 값
            if heap[0] < number:
                heapq.heappop(heap)
                heapq.heappush(heap, number)
print(heap[0])