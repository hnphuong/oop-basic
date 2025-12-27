n = 0
m = 0
for i in range(5000,10000):
    if(i%8==0):
        # print(i)
        n=n+1
for i in range(5000,10000):
    if(i%12==0):
        # print(i)
        n=n+1
for i in range(5000,10000):
    if(i%8==0 and i%12==0):
        # print(i)
        m=m+1
print(n-m)