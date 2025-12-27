import sys

def dem_so_tam_giac(danh_sach):
    n = len(danh_sach)
    if n < 3:
        return 0
    danh_sach.sort()
    
    so_tam_giac = 0
    for i in range(2, n):
        left = 0
        right = i - 1
        
        while left < right:
            if danh_sach[left] + danh_sach[right] > danh_sach[i]:
                so_tam_giac += (right - left)
                right -= 1
            else:
                left += 1
                
    return so_tam_giac

def main():
    try:
        t = int(sys.stdin.readline().strip())
    except Exception:
        return

    for _ in range(t):
        try:
            line = sys.stdin.readline().strip().split()
            danh_sach_canh = [int(x) for x in line if x.isdigit() and int(x) > 0]
            
            ket_qua = dem_so_tam_giac(danh_sach_canh)
            print(ket_qua)
            
        except Exception:
            pass

if __name__ == "__main__":
    main()