import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline
tree = []
while True:
    try:
        x = int(input())
        tree.append(x)
    except:
        break

def search(arr):
    if len(arr)==0:
        return
    if len(arr)==1:
        print(arr[0])
        return
    left, right = 0, 0
    for i in range(1, len(arr)):
        if arr[i] < arr[0]:
            left = i
            break
    for i in range(1, len(arr)):
        if arr[i] > arr[0]:
            right = i
            break
    if left>0 and right>0:
        search(arr[left:right])
        search(arr[right:len(arr)])
    else:
        search(arr[1:len(arr)])
    print(arr[0])
search(tree)
