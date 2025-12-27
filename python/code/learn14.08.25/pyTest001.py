t = int(input())
tests = []

for i in range(t):
    s1 = input().lower().split()
    s2 = input().lower().split()
    tests.append((s1, s2))

for s1, s2 in tests:
    set1 = set(s1)
    set2 = set(s2)
    common = sorted(set1 & set2)

    if common:
        print(" ".join(common))
    else:
        print("NO")
