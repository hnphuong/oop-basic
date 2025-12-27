
t = int(input())
while t <= 0 or t > 10:
    t = int(input()) 

def check_string(s: str) -> None:
    total_sum = 0
    n = len(s)
    
    check2 = True
    for i in range(n-1):
        if abs(int(s[i]) - int(s[i+1])) != 2:
            check2 = False
    
    for i in range(n):
        total_sum += int(s[i])
    
    check1 = total_sum % 10 == 0
    
    if check1 and check2:
        print("YES")
    else:
        print("NO")

for _ in range(t):
    s = input().strip()
    if len(s) >= 3 and len(s) <= 18 and s.isdigit():
        check_string(s)
    else:
        print("NO")
