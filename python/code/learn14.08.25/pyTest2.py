n = int(input())
teams = []

for _ in range(n):
    name = input().strip()
    win, lose, fairplay = map(int, input().split())
    teams.append((name, win, lose, fairplay))

teams.sort(key=lambda x: (-x[1], -x[3]))

for t in teams:
    print(f"{t[0]} {t[1]} {t[2]} {t[3]}")
