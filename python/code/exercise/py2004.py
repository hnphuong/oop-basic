import sys
from collections import defaultdict

def tinh_tan_so_va_sap_xep():
    word_counts = defaultdict(int)
    
    try:
        n_line = sys.stdin.readline()
        if not n_line:
            return
            
        n = int(n_line.strip())
        for _ in range(n):
            line = sys.stdin.readline().strip()
            words = line.split() 
            for word in words:
                word_counts[word] += 1
                
    except Exception:
        return
    items = list(word_counts.items())
    
    items.sort(key=lambda item: (-item[1], item[0]))

    for word, count in items:
        print(f"{word} {count}")

if __name__ == "__main__":
    tinh_tan_so_va_sap_xep()