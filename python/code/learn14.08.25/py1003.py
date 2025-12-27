s = ''
while len(s) != 9:
    s = input()

lst = list(s)
try:
    a = int(lst[0])
    b = int(lst[4])
    c = int(lst[8])
    if(a+b==c):
        print("YES")
    else:
        print("NO")
except:
    print("NO")