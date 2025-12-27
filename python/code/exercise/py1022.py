def check_tang_giam(n_str):
    n = len(n_str)
    
    if n < 3:
        return False

    for peak_index in range(1, n - 1):
        is_tang_chat = True
        for i in range(peak_index):
            if n_str[i] >= n_str[i+1]:
                is_tang_chat = False
                break
        
        if not is_tang_chat:
            continue
        is_giam_chat = True
        for j in range(peak_index, n - 1):
            if n_str[j] <= n_str[j+1]:
                is_giam_chat = False
                break
        if is_tang_chat and is_giam_chat:
            return True
            
    return False

def main():
    try:
        t = int(input())
    except EOFError:
        return
    except ValueError:
        return
    for _ in range(t):
        try:
            n_str = input().strip()
            
            if check_tang_giam(n_str):
                print("YES")
            else:
                print("NO")
                
        except EOFError:
            break
        except Exception:
            print("NO")

if __name__ == "__main__":
    main()