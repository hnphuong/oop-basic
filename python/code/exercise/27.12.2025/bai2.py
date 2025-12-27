import re
t = 0
while(t<=0 or t>100):
    try:
        t = int(input().strip())
    except ValueError:
        continue
for _ in range(t):
    s = input().strip()
    cleaned = re.sub(r'[^A-Za-z ]', '', s)
    lengths = [str(len(word)) for word in cleaned.split() if len(word) > 0]
    print(' '.join(lengths))