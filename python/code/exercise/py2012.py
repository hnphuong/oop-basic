import sys

def tinh_tong_s(n):
    tong = 0.0
    if n % 2 != 0:
        start = 1
        step = 2
    else:
        start = 2
        step = 2
    for i in range(start, n + 1, step):
        tong += 1.0 / i  

    return tong

def main():
    try:
        t_line = sys.stdin.readline()
        if not t_line:
            return
        t = int(t_line.strip())
    except Exception:
        return

    for _ in range(t):
        try:
            n_line = sys.stdin.readline()
            if not n_line:
                continue
            n = int(n_line.strip())
            
            if n <= 1 or n >= 10000:
                 continue
            ket_qua = tinh_tong_s(n)
            print(f"{ket_qua:.6f}")
            
        except Exception:
            pass

if __name__ == "__main__":
    main()