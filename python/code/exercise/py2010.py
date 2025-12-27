import sys

def tinh_bieu_thuc_hau_to(bieu_thuc_str):
    tokens = bieu_thuc_str.split()
    
    stack = []
    
    toan_tu = {'+', '-', '*', '/'}
    
    for token in tokens:
        if token in toan_tu:
            if len(stack) < 2:
                return "INVALID"
            op2 = stack.pop()
            op1 = stack.pop()
            
            if token == '+':
                ket_qua = op1 + op2
            elif token == '-':
                ket_qua = op1 - op2
            elif token == '*':
                ket_qua = op1 * op2
            elif token == '/':
                if op2 == 0:
                    return "INVALID" 
                ket_qua = op1 / op2
            
            stack.append(ket_qua)
            
        else:
            try:
                so = float(token)
                stack.append(so)
                
            except ValueError:
                return "INVALID"

    if len(stack) == 1:
        return stack[0]
    else:
        return "INVALID"

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
            bieu_thuc_str = sys.stdin.readline().strip()
            
            if not bieu_thuc_str:
                print("INVALID")
                continue

            ket_qua = tinh_bieu_thuc_hau_to(bieu_thuc_str)

            if ket_qua == "INVALID":
                print("INVALID")
            else:
                print(f"{ket_qua:.5f}")
            
        except Exception:
            print("INVALID")

if __name__ == "__main__":
    main()