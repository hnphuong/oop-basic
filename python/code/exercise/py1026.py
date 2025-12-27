import sys

def tach_danh_sach(danh_sach, k):
    n = len(danh_sach)

    if k >= n:
        print("INVALID")
        return
    
    danh_sach_con = []
    for i in range(0, n, k):
        sub_list = danh_sach[i : i + k]
        danh_sach_con.append(sub_list)

    output = []
    for sub in danh_sach_con:
        output.append(str(sub))
        
    print(" ".join(output))


def main():
    try:
        t = int(sys.stdin.readline().strip())
    except Exception:
        return

    for _ in range(t):
        try:
            danh_sach_str = sys.stdin.readline().strip().split()
            danh_sach = [int(x) for x in danh_sach_str if x]
            k = int(sys.stdin.readline().strip())
            tach_danh_sach(danh_sach, k)
            
        except Exception:
            pass

if __name__ == "__main__":
    main()