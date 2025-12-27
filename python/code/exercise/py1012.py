import sys
def solve():
    try:
        line = sys.stdin.readline().strip()
        if not line:
            return
        a, K, N = map(int, line.split())
    except EOFError:
        return
    except ValueError:
        return
    
    S_min = a + 1
    
    r_min = S_min % K

    if r_min == 0:
        P_start = S_min
    else:
        P_start = S_min + (K - r_min)
    P_end = N

    if P_start > P_end:
        print("-1")
        return
    
    result = []
    
    P = P_start
    while P <= P_end:
        b = P - a
        result.append(b)
        P += K

    if not result:
        print("-1")
    else:
        print(*result)

solve()