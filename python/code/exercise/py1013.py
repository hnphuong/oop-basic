def check_non_decreasing(s_num):
    n = len(s_num)
    for i in range(n - 1):
        if s_num[i] > s_num[i+1]:
            return "NO"
    return "YES"

def main():
    t = 0
    while t <= 0 or t > 10:
        t = int(input().strip())
    for i in range(0,t):
        number_str = input().strip()
        result = check_non_decreasing(number_str)
        print(result)

main()