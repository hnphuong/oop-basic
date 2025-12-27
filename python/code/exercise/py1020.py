def reverse_number(n):
    return int(str(n)[::-1])

def find_divisible_by_7(n):
    steps = 0
    while steps < 1000:
        if n % 7 == 0:  
            return n
        reversed_n = reverse_number(n)
        n = n + reversed_n  
        if n % 7 == 0:  
            return n
        steps += 1
    return -1 

def main():
    t = int(input())
    for _ in range(t):
        n = int(input())  
        result = find_divisible_by_7(n)
        print(result)

main()