n = int(input("Vui lòng nhập một số nguyên dương: "))
tong_so_chan = 0
for i in range(1, n + 1):
    if i % 2 == 0:
        tong_so_chan += i
print(f"Tổng của tất cả các số chẵn từ 1 đến {n} là: {tong_so_chan}")