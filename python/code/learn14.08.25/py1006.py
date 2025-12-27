t = 0
while t <= 0 or t > 10:
    t = int(input().strip())
def valid_number(n: str) -> bool:
    return n.isdigit() and 1 <= len(n) <= 200
def isResult(a: str) -> str:
    for ch in a:
        if ch != '4' and ch != '7':
            return "NO"
    return "YES"
nums = []
for i in range(0,t):
    n = ''
    while valid_number(n)==False:
        n = input()
    nums.append(n)
for n in nums:
    print(isResult(n))

