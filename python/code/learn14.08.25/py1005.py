n = ''
def valid_number(n: str) -> bool:
    return n.isdigit() and 1 <= len(n) <= 18
while valid_number(n)==False:
    n = input()
l2,l6=0,0
l2, l6 = 0, 0
for ch in n:
    if ch == '2':
        l2 += 1
    elif ch == '6':
        l6 += 1

if l2 + l6 == 2 or l2 + l6 == 6:
    print("YES")
else:
    print("NO")