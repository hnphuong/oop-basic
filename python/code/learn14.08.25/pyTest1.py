t = int(input())

for _ in range(t):
    n = input().strip()  
    if all(ch in '68' for ch in n):
        if n == n[::-1]:
            print("YES")
        else:
            print("NO")
    else:
        print("NO")
