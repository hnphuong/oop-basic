import sys
def solve():
    try:
        line = sys.stdin.readline().strip()
        if not line:
            return
        a, K, N = map(int, line.split())
        print (a, K, N)
    except EOFError:
        return
    except ValueError:
        return

solve()