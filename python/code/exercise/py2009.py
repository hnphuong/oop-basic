import sys

def decode_string(s):
    decoded_part = ""
    num = 0
    
    i = 0
    while i < len(s):
        char = s[i]
        
        if '0' <= char <= '9':
            num = num * 10 + int(char)
            i += 1
            
        elif char == '[':
            balance = 1
            j = i + 1
            start_index = i + 1
            
            while j < len(s):
                if s[j] == '[':
                    balance += 1
                elif s[j] == ']':
                    balance -= 1
                
                if balance == 0:
                    end_index = j
                    break
                j += 1
            
            sub_string = s[start_index:end_index]
            decoded_sub = decode_string(sub_string)
            if num == 0:
                num = 1
            
            decoded_part += decoded_sub * num
            
            num = 0
            i = end_index + 1
            
        elif char == ']':
            i += 1
            
        else:
            decoded_part += char
            i += 1
            
    return decoded_part

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
            s = sys.stdin.readline().strip()
            
            if not s:
                print("")
                continue

            result = decode_string(s)
            print(result)
            
        except Exception:
            pass

if __name__ == "__main__":
    main()