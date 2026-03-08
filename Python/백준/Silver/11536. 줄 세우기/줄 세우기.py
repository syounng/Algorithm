num = int(input())
names = []

for _ in range(num):
    names.append(input())

def compare(name1, name2):
    if(name1 < name2): # name1이 더 앞인 경우
        return True
    else: # name2가 더 앞인 경우
        return False

result = 0
for i in range(num-1):
    cmp = compare(names[i], names[i+1])
    if(cmp):
        result -= 1
    else:
        result += 1
    
if(result + (num-1) == 0):
    print('INCREASING')
elif(result == (num-1)):
    print('DECREASING')
else:
    print('NEITHER')


