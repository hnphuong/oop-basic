import sys
from collections import defaultdict

def tinh_histogram_anh_xam():
    try:
        line = sys.stdin.readline().strip().split()
        if not line:
            return
            
        H = int(line[0]) 
        W = int(line[1]) 
        
    except Exception:
        return

    histogram = defaultdict(int)

    total_pixels = H * W
    pixels_read = 0
    
    while pixels_read < total_pixels:
        try:
            line = sys.stdin.readline().strip()
            if not line:
                break

            levels = line.split() 
            
            for level_str in levels:
                if pixels_read >= total_pixels:
                    break
                    
                level = int(level_str)
                
                if 0 <= level <= 255:
                    histogram[level] += 1
                    pixels_read += 1
                    
        except Exception:
            continue

    cac_muc_xam = list(histogram.keys())
    
    cac_muc_xam.sort()

    for muc_xam in cac_muc_xam:
        so_luong = histogram[muc_xam]
        print(f"{muc_xam} {so_luong}")

if __name__ == "__main__":
    tinh_histogram_anh_xam()