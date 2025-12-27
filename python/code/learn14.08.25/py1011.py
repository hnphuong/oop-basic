t = 0
while t <= 0 or t > 10:
    t = int(input().strip())
def findUC(a):
    arr = []
    for i in range(a):
        print("i: ", i)
        if(i==0):
            continue
        if(a%i==0):
            arr.append(i)
    return arr

def UCLN(a,b):
    for i in range(min(a, b), 0, -1):
        if(a%i==0 and b%i==0):
            return i
    return -1

def isPrime(a):
    if(a<=1):
        return 0
    for item in range(2, int(a ** 0.5) + 1):
        if(a%item==0):
            return 0
    return 1

for i in range(t):
    a,b = map(int, input().strip().split())
    ucln = str(UCLN(a, b))
    prime = 0
    for i in range(len(ucln)):
        prime += int(ucln[i])
    if(isPrime(prime)):
        print("YES")
    else:
        print("NO")