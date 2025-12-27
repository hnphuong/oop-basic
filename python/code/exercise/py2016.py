import sys

def xac_dinh_trang_thai(ki):
    if ki <= 10:
        return "N"
    elif 10 < ki <= 1000:
        return "S"
    elif 1000 < ki <= 10000:
        return "SS"
    elif ki > 100000:
        return None 
    elif 10000 < ki <= 100000:
        return "SS"

    return "?"


def xu_ly_test_case(danh_sach_ki):
    ket_qua = []
    may_da_no = False
    
    for ki in danh_sach_ki:
        if may_da_no:
            ket_qua.append("?")
            continue
        if ki > 100000:
            ket_qua.append("?")
            may_da_no = True
            continue
        
        trang_thai = ""
        if ki <= 10:
            trang_thai = "N"
        elif ki <= 1000:
            trang_thai = "S"
        elif ki <= 100000:
            trang_thai = "SS"
        else:
            trang_thai = "?"
            
        ket_qua.append(trang_thai)
        
    print(" ".join(ket_qua))


def main():
    try:
        t_line = sys.stdin.readline()
        if not t_line:
            return
        T = int(t_line.strip())
    except Exception:
        return

    for _ in range(T):
        try:
            sys.stdin.readline() 
            
            ki_line = sys.stdin.readline().strip().split()
            
            if not ki_line:
                continue

            danh_sach_ki = [int(x) for x in ki_line if x]
            
            xu_ly_test_case(danh_sach_ki)
            
        except Exception:
            continue

if __name__ == "__main__":
    main()