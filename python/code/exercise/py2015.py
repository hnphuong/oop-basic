def doi_thu_tu_ten():
    t = int(input())
    while t <= 0 or t > 10:
        t = int(input())

    for _ in range(t):
        words = input().strip().split()

        ho = words[0]
        ten_chinh = words[-1]
        ten_dem = words[1:-1]

        result = " ".join([ten_chinh, ho] + ten_dem)
        print(result)

doi_thu_tu_ten()
