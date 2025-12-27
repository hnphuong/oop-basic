import sys

def solve():
    try:
        t_str = sys.stdin.readline().strip()
        if not t_str:
            return
        t = int(t_str)
    except:
        return

    for _ in range(t):
        s = sys.stdin.readline().strip() 
        
        n = len(s)
        is_valid_input = (3 <= n <= 18) and s.isdigit()
        
        if not is_valid_input:
            print("NO")
            continue 

        total_sum = 0
        for char in s:
            total_sum += int(char)
        
        check1 = total_sum % 10 == 0

        check2 = True
        for i in range(n - 1):
            if abs(int(s[i]) - int(s[i+1])) != 2:
                check2 = False
                break
        if check1 and check2:
            print("YES")
        else:
            print("NO")

solve()