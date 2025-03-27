import sys

string = sys.stdin.readline()
target = sys.stdin.readline()
s = list(string[i:i+1] for i in range(0, len(string)-1))
t = list(target[i:i+1] for i in range(0, len(target)-1))

stk = []
i=0
found = 0 # 폭탄을 찾은 개수

for i in range(len(s)):
    stk.append(s[i])
    if stk[-1]==t[len(t)-1]: # target의 끝 글자와 같으면 스택에서 target만큼 꺼내서 target과 같은지 확인
        flag = False
        if len(stk)>=len(t):
            stk_value = stk[i-len(t)+1-(found*len(t)):i+1-(found*len(t))]
            if stk_value == t:
                flag = True
        if flag :
            found += 1
            for _ in range(len(t)):
                stk.pop()

if len(stk)==0:
    print('FRULA')
else:
    for i in stk:
        print(i,end="")



