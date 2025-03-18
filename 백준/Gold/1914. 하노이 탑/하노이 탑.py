# 하노이의 탑
def move(n: int, x: int, y: int) -> None:
    # n개의 원반을 x기둥에서 y기둥으로 옮김
    if n>20:
        return
    if n==1: # 원판 한 개일 때
        print(x, y) # 원판 1을 1에서 3으로 옮기기
        return
    else:
        move(n-1, x, 6-x-y) # n-1개의 원판을 1에서 2로 옮기고
        print(x, y) # n번 원판을 1에서 3으로 옮기고
        move(n-1, 6-x-y, y) # n-1개의 원판을 2에서 3으로 옮기기

n = int(input())
print(2**n-1)
move(n, 1, 3) # n개의 원반을 1기둥에서 3기둥으로 옮김
