import sys

def xu_ly_dao_nguoc_va_tinh_gia_tri():
    try:
        n_line = sys.stdin.readline()
        if not n_line:
            return
        N = int(n_line.strip())
        
    except Exception:
        return

    danh_sach_cap = []

    for _ in range(N):
        try:
            line = sys.stdin.readline().strip().split()
            if len(line) == 2:
                key = line[0]
                value = int(line[1])
                danh_sach_cap.append((key, value))
            
        except Exception:
            continue

    danh_sach_dao_nguoc = danh_sach_cap[::-1]

    vi_tri_moi = 1
    
    for key, value_ban_dau in danh_sach_dao_nguoc:
        
        gia_tri_moi = value_ban_dau * vi_tri_moi
        print(f"{key} {gia_tri_moi}")
        
        vi_tri_moi += 1

if __name__ == "__main__":
    xu_ly_dao_nguoc_va_tinh_gia_tri()