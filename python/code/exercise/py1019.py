s = ''
while len(s) > 100 or len(s) == 0:
    s = input().strip()
dang_sach = s.split()
for i in range(len(dang_sach)):
    print(dang_sach[i])