t= 0
while (t<=0 or t>10):
    t = int(input())

def check_string(s: str) -> bool:
    if s[-2:] == "86":
        print("YES")
    else:
        print("NO")

for _ in range(t):
    s = ''
    while len(s) > 500 or len(s) == 0 or not s.isdigit():
        s = input().strip()
    check_string(s)