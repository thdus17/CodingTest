import sys

input = sys.stdin.readline

#N명의 원생들을 키 순서대로 일렬로 줄, K개의 조로 나눔
#각 조에는 원생이 적어도 한 명 있어야 함, 같은 조에 속한 원생들은 서로 인접해야 함
#조별로 인원수가 같을 필요는 없다

#티셔츠 맞추는 비용은 조에서 가장 키가 큰 원생과 키가 작은 원생의 키 차이만큼든다
#최대한 비용 아껴서 티셔츠 만드는 비용의 합을 최소로 !!!

#원생의 수 나타내는 자연수 N, 조 개수 K
#원생의 키 N개

N, K = map(int,input().split())
cmArr = list(map(int, input().split()))

tmpArr = []
res = 0

for i in range(1, len(cmArr)) :
    tmpArr.append(cmArr[i]-cmArr[i-1]) #각 인접값들의 차이를 구해서 list에 담기
tmpArr.sort(reverse=True) #내림차순 정렬
resArr = tmpArr[K-1:] #K-1개 제외한 결과값
res = sum(resArr) #합의 최소값
print(res)
