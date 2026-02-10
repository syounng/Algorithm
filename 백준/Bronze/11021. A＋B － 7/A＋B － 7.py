n = int(input())

result = []
for _ in range(n):
    a, b = map(int, input().split())
    result.append(a+b)

for i in range(len(result)):
    print(f'Case #{i+1}: {result[i]}')