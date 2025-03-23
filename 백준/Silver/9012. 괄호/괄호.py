import sys
n = int(sys.stdin.readline())

for _ in range(n):
    stk = []
    string = sys.stdin.readline().strip()
    flag = True
    length = len(string)

    for i in range(length):
        val = string[i:i+1]
        top = len(stk)-1

        if val=='(': # (가 입력되면 스택에 넣기
            stk.append(val)
            continue

        if top<0: # 스택이 비어있다면 VPS가 아님
            flag = False
            break

        if stk[top]=='(': # top이 (이라면 하나 pop하기
            stk.pop()
            continue
        else: # top이 )이라면 VPS가 아님
            flag = False
            break

    if len(stk)>0: # 마지막까지 수행했는데도 스택이 비어있지 않으면 VPS가 아님
        flag = False

    if flag:
        print('YES')
    else:
        print('NO')


