import sys
t = 0
while(t<=0 or t>100):
    try:
        t = int(input().strip())
    except ValueError:
        continue

dictionary = {}
output = []

for _ in range(t):
    line = sys.stdin.readline().rstrip()

    if line.startswith("add "):
        _, eng, viet = line.split(' ', 2)
        dictionary[eng] = viet

    elif line.startswith("find "):
        eng = line.split(' ', 1)[1]
        if eng in dictionary:
            output.append(dictionary[eng])
        else:
            output.append("Not found")

print('\n'.join(output))
