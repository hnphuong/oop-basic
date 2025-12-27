s=''
while len(s) <= 0 or len(s) > 100:
    s = input().strip()
isupper = 0
islower = 0
for i in s:
    if(i.isupper()):
        isupper += 1
    if(i.islower()):
        islower += 1
if isupper > islower:
    s = s.upper()
else:
    s = s.lower() 
print(s)