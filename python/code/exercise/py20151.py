import sys

def doi_thu_tu_ten():
    try:
        t_line = sys.stdin.readline()
        if not t_line:
            return
        T = int(t_line.strip())
        
    except Exception:
        return

    for _ in range(T):
        while True:
            try:
                full_name_line = sys.stdin.readline().strip()
                
                if not full_name_line:
                    break 

                words = full_name_line.split()
                
                if len(words) >= 3:
                    break
                else:
                    continue 

            except Exception:

                break 

        if not words or len(words) < 3:
            continue
        ho = words[0]
        ten_chinh = words[-1]
        ten_dem = words[1:-1]
        ket_qua_list = []
        ket_qua_list.append(ten_chinh)
        ket_qua_list.append(ho)
        ket_qua_list.extend(ten_dem)
        result = " ".join(ket_qua_list)
        print(result)

if __name__ == "__main__":
    doi_thu_tu_ten()