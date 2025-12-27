t = 0
while t <=0 or t > 20:
    t = int(input().strip())
for i in range(t):
    number = ''
    while len(number) < 4 or len(number) > 18:
        number = input().strip()
    a = number[0:2]
    b = number[len(number)-2:len(number)]
    if(a == b):
        print("YES")
    else:
        print("NO")