s = ''
while len(s) > 10 or len(s) == 0 or not s.isdigit() or int(s) > 2000000000:
    s = input().strip()
n = len(s)
strings = ''
count = 0
for i in range(n, 0, -1):
    strings=strings + s[i-1]
    count += 1
    if(count%3==0 and i!=0 and i!=1):
        strings= strings + ','

chuoi_dao_nguoc = '' 
for i in range(len(strings) - 1, -1, -1):
    chuoi_dao_nguoc += strings[i]

print(chuoi_dao_nguoc)