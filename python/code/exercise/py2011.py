import sys

def tim_hoan_vi_ngay_truoc(digits):
    n = len(digits)
    
    i = n - 2
    while i >= 0 and digits[i] <= digits[i + 1]:
        i -= 1
    if i < 0:
        return None
    
    j = n - 1
    while digits[j] >= digits[i]:
        j -= 1
        
    digits[i], digits[j] = digits[j], digits[i]
    
    left, right = i + 1, n - 1
    while left < right:
        digits[left], digits[right] = digits[right], digits[left]
        left += 1
        right -= 1
        
    return digits

def main():
    try:
        t_line = sys.stdin.readline()
        if not t_line:
            return
        t = int(t_line.strip())
    except Exception:
        return

    for _ in range(t):
        try:
            n_str = sys.stdin.readline().strip()
            
            if not n_str:
                print("NO")
                continue
            digits = list(n_str)
            
            result_digits = tim_hoan_vi_ngay_truoc(digits)
            if result_digits is None:
                print("NO")
            else:
                result_str = "".join(result_digits)
                print(result_str)
                
        except Exception:
            pass

if __name__ == "__main__":
    main()