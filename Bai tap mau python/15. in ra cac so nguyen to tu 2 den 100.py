def la_so_nguyen_to(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

print("Các số nguyên tố từ 2 đến 100 là:")
for num in range(2, 101):
    if la_so_nguyen_to(num):
        print(num, end=' ')