
def search(n):
    start = 2
    end = n-1
    # start~end-1 범위 중에서 합이 end인 소수 두 개 찾기
    mid = (start+end)//2
    left = mid
    right = mid

    while True:
        # left right 모두 소수이면
        if numbers[left] and numbers[right]:
            # 둘의 합이 n인지 확인
            if left + right > n:
                # 둘의 합이 n보다 크면 left를 왼쪽으로 한 칸 이동
                left-=1
            elif left + right < n:
                # 둘의 합이 n보다 작으면 right를 오른쪽으로 한 칸 이동
                right+=1
            else:
                # 둘의 합이 n이면 골드바흐의 수
                return left, right
        if not numbers[left]: # left가 소수가 아니면 왼쪽으로 한 칸 이동
            left-=1
        if not numbers[right]: # right가 소수가 아니면 오른쪽으로 한 칸 이동
            right+=1



# 에라토스테네스의 체로 소수 구하기
numbers = {} # 해시맵 선언
for i in range(10000): # 해시맵을 10000개의 원소로 초기화
    numbers[i] = True

numbers[0] = False # 0은 제외
numbers[1] = False # 1은 소수가 아님

for i in range(2, 10001): # 전체 수 중에서
    if numbers[i]: # true인 수(소수)를 찾으면
        for j in range(i*2, 10001, i): # 소수의 배수들을 모두
            numbers[j] = False # false로 만들기


t = int(input())
for i in range(t):
    n = int(input())
    p1, p2 = search(n) # 2부터 n-1까지 숫자 중에서 numbers[]=True인 숫자는 소수임. 그 소수들을 가운데서부터 투포인터로 인덱스 조절해가면서 둘의 합이 n인지 검사하기
    print(min(p1, p2), max(p1, p2))



