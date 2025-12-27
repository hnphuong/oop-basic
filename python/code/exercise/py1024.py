import sys

def tinh_hinh_chu_nhat():
    try:
        line = sys.stdin.readline().strip()
        
        if not line:
            print("0 0")
            return
        
        parts = line.split() 
        
        if len(parts) < 2:
            print("0 0")
            return

        a = int(parts[0])
        b = int(parts[1])
        
    except (ValueError, IndexError):
        print("0 0")
        return
    if a <= 0 or b <= 0:
        print("0 0")
    else:
        chu_vi = 2 * (a + b)
        dien_tich = a * b
        print(f"{chu_vi} {dien_tich}")
if __name__ == "__main__":
    tinh_hinh_chu_nhat()