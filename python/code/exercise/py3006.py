import sys
from collections import OrderedDict

def doc_tu_dien():
    try:
        n_line = sys.stdin.readline()
        if not n_line:
            return 0, OrderedDict()
        N = int(n_line.strip())
    except (ValueError, IndexError):
        return 0, OrderedDict()

    d = OrderedDict()
    
    for _ in range(N):
        try:
            line = sys.stdin.readline().strip().split()
            if len(line) == 2:
                key = line[0]
                value = int(line[1])
                d[key] = value
        except (ValueError, IndexError):
            continue
            
    return N, d

def gop_hai_tu_dien():
    N, d1 = doc_tu_dien()
    
    M, d2 = doc_tu_dien()

    d_result = OrderedDict(d1)
    
    keys_only_in_d2 = [] 
    for key, value in d2.items():
        if key in d_result:
            d_result[key] = value
        else:
            keys_only_in_d2.append((key, value))

    for key, value in d_result.items():
        print(f"{key} {value}")

    final_output = []
    for key, value in d1.items():
        new_value = d2.get(key, value)
        final_output.append((key, new_value))
        
    processed_keys = set(d1.keys())
    for key, value in d2.items():
        if key not in processed_keys:
            final_output.append((key, value))
    for key, value in final_output:
        print(f"{key} {value}")


if __name__ == "__main__":
    gop_hai_tu_dien()