t = 0
while t <= 0 or t > 10:
    t = int(input().strip())

for i in range(0,t):
    # n,x,m=0,0,0
    # while n <= 0 or n > 100000:
    #     n = float(input().strip())
    # while x <= 0 or x > 10:
    #     x = float(input().strip())
    # while m <= n or m > 100000:
    #     m = float(input().strip())
    n, x, m = map(float, input().strip().split())
    # print("n: ", n, " x: ", x, " m: ", m)
    cnt = 0
    money = n
    while money < m:
        money += money * x / 100
        cnt += 1
    print(cnt)