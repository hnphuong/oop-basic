n = int(input("Nhập số lượng số Fibonacci đầu tiên: "))

a, b = 0, 1
tong = 0

for i in range(n):
    tong += a
    a, b = b, a + b  

print("Tổng của", n, "số Fibonacci đầu tiên là:", tong)