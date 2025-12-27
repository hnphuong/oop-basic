import sys

def tim_day_con_ly_tuong():
    try:
        n_line = sys.stdin.readline()
        if not n_line:
            return
        n = int(n_line.strip())
        a_line = sys.stdin.readline().strip().split()
        if not a_line:
            return
        A = list(map(int, a_line))
        
    except Exception:
        return
    max_val = max(A) if A else None
    
    if not A:
        return
        
    ideal_sub_array = [max_val] 
    max_sum = max_val
    has_increasing_sub = False
    current_sub_array = [A[0]]
    current_sum = A[0]
    for i in range(1, n):
        if A[i] > A[i-1]:
            current_sub_array.append(A[i])
            current_sum += A[i]
            if not has_increasing_sub:
                has_increasing_sub = True

        else:
            if current_sum > max_sum:
                max_sum = current_sum
                ideal_sub_array = list(current_sub_array) 
            
            current_sub_array = [A[i]]
            current_sum = A[i]
            
    if current_sum > max_sum:
        max_sum = current_sum
        ideal_sub_array = current_sub_array
    
    print(*(ideal_sub_array))


if __name__ == "__main__":
    tim_day_con_ly_tuong()