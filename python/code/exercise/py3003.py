import sys
from collections import defaultdict

def tim_ky_tu_lap_lai_lan_dau():
    try:
        s = sys.stdin.readline().strip()
    except Exception:
        print("None")
        return

    if not s:
        print("None")
        return
    counts = defaultdict(int)
    for char in s:
        counts[char] += 1
    ket_qua = []
    
    da_them = set()

    for char in s:
        if counts[char] > 1 and char not in da_them:
            ket_qua.append(char)
            da_them.add(char)
            
    
    if ket_qua:
        print(" ".join(ket_qua))
    else:
        print("None")

if __name__ == "__main__":
    tim_ky_tu_lap_lai_lan_dau()