def kiem_tra_co_so_3(chuoi):

    if not chuoi:
        return False
        
    for ky_tu in chuoi:
        if ky_tu not in ('0', '1', '2'):
            return False
            
    return True

def main():
    try:
        t = int(input())
    except EOFError:
        return
    except ValueError:
        return

    for _ in range(t):
        try:
            day_bieu_dien = input().strip()
            
            if kiem_tra_co_so_3(day_bieu_dien):
                print("YES")
            else:
                print("NO")
                
        except EOFError:
            break
        except Exception:
            print("NO")

if __name__ == "__main__":
    main()