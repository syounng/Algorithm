import sys

# 4의 배수이면서 100의 배수가 아닐 때
# 400의 배수일 때

year = int(sys.stdin.readline())

if (year%4==0 and year%100!=0) or year%400==0:
    print(1)
else:
    print(0)
