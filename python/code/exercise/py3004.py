import sys

def chia_tu_dien_con():
    try:
        nk_line = sys.stdin.readline().strip().split()
        if not nk_line or len(nk_line) < 2:
            return
            
        N = int(nk_line[0])
        K = int(nk_line[1])
        
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

    start_index = 0
    
    output_lines = []
    while start_index < len(danh_sach_cap):
        
        end_index = start_index + K
        sub_list = danh_sach_cap[start_index:end_index]
        
        parts = []
        for key, value in sub_list:
            parts.append(f"{key}:{value}")
            
        output_lines.append(" ".join(parts))
        
        start_index = end_index

    for line in output_lines:
        print(line)

if __name__ == "__main__":
    chia_tu_dien_con()