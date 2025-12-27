a, K, N = 0, 0, 0
while K <= 0 or K > 1e10 or N <= 0 or N > 1e10 or a <= 0 or a > 1e10:
    nums = input().strip().split()
    nums = [x for x in nums if x.isdigit()]
    if len(nums) == 3:
        a, K, N = map(int, nums)

def isCheck(a, K, N):
    b = N - a
    arr = []
    for i in range(1, b + 1):
        if (a + i) % K == 0:
            arr.append(i)
    return arr

result = isCheck(a, K, N)
if not result:
    print("-1")
else:
    print(*result)