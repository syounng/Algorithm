N = int(input())

def fib(n):
    if n==0:
        return [0]
    elif n==1:
        return [0, 1]
    elif n==2:
        return [0, 1, 1]
    else:
        tmplist = fib(n-1)
        tmplist.append(tmplist[-1]+tmplist[-2])
        return tmplist

list = fib(N)
print(list[N])