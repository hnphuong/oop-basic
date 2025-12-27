import math
t= 0
while (t<=0 or t>10):
    t = int(input())

def isPrime(a):
    if(a<=1):
        return 0
    for item in range(2, int(a ** 0.5) + 1):
        if(a%item==0):
            return 0
    return 1

nums = []
for i in range(t):
    n = 0
    while (n <= 0 or n > 10000):
        n = int(input())
    nums.append(n)

def isResult(a):
    K = 0
    for i in range(1, n):
        if math.gcd(i, n) == 1:
            K += 1
    if isPrime(K) == 1:
        return "YES"
    else:
        return "NO"

for n in nums:
    print(isResult(n))


