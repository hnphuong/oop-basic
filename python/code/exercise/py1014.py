def input_uppercase_string():
    s = ''
    while not s.isupper() or len(s) == 0 or len(s) > 100:
        s = input().strip()
    return s

def roll_back_string(input_s):
    n = len(input_s)
    s = ''
    for i in range(n):
        if(input_s[i].isalpha() and input_s[i+1].isdigit()):
            s += gen_string(input_s[i], int(input_s[i+1]))
    return s

def gen_string(s,n):
    res = ''
    for i in range(n):
        res += s
    return res

def main():
    t = 0
    while t <= 0 or t > 10:
        t = int(input().strip())

    for i in range(0,t):
        s = input_uppercase_string()
        rs = roll_back_string(s)
        print(rs)

main()