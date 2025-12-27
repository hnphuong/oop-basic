import sys

def xu_ly_chuoi():
    try:
        t_line = sys.stdin.readline()
        if not t_line:
            return
        t = int(t_line.strip())
    except Exception:
        return

    for _ in range(t):
        try:
            chuoi_goc = sys.stdin.readline().strip()
            
            if not chuoi_goc:
                print("")
                continue
            danh_sach_tu = chuoi_goc.split()
            
            danh_sach_ket_qua = []
            
            for tu in danh_sach_tu:
                tu_dao_nguoc = tu[::-1]
                tu_hoa = tu_dao_nguoc.upper()
                
                danh_sach_ket_qua.append(tu_hoa)
            ket_qua_cuoi = " ".join(danh_sach_ket_qua)
            print(ket_qua_cuoi)
            
        except Exception:
            pass

if __name__ == "__main__":
    xu_ly_chuoi()