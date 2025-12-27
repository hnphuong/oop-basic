import sys
from collections import defaultdict

def tim_tan_so_uoc_so_toi_uu():
    input_lines = sys.stdin.readlines()
    if not input_lines:
        return

    line_index = 0
    
    try:
        T = int(input_lines[line_index].strip())
        line_index += 1
    except (IndexError, ValueError):
        return

    results = []
    
    for _ in range(T):
        try:
            N_str = input_lines[line_index].strip()
            line_index += 1
            A_line = input_lines[line_index].strip().split()
            line_index += 1
            
            if not A_line:
                results.append("{}")
                continue
                
            A = [int(x) for x in A_line if x.isdigit() and int(x) >= 1] 
            
            if not A: 
                results.append("{}")
                continue
            
        except (IndexError, ValueError):
            continue
            
        freq_a = defaultdict(int)
        for x in A:
            freq_a[x] += 1
            
        M = max(A)
        
        divisor_freq = {}
        
        for k in range(1, M + 1):
            count = 0
            for j in range(k, M + 1, k):
                if j in freq_a:
                    count += freq_a[j]
            
            if count > 0:
                divisor_freq[k] = count

        output_parts = []
        for k, fk in divisor_freq.items():
            output_parts.append(f"{k}: {fk}")
            
        final_output = "{" + ", ".join(output_parts) + "}"
        results.append(final_output)

    for res in results:
        print(res)

if __name__ == "__main__":
    tim_tan_so_uoc_so_toi_uu()