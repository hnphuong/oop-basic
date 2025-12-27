def is_beautiful_number(n):
    n_str = str(n)
    
    unique_digits = set(n_str)
    if len(unique_digits) != 2:
        return False
    
    for i in range(len(n_str) - 2):
        if n_str[i] != n_str[i + 2]:
            return False
    
    return True

def main():
    t = int(input()) 
    for _ in range(t):
        n = input().strip()  
        if is_beautiful_number(n):
            print("YES")
        else:
            print("NO")

main()
