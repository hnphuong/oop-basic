so_1 = int(input("Nhập số thứ nhất: "))
so_2 = int(input("Nhập số thứ hai: "))
if so_2 == 0:
    print("Lỗi: Không thể chia cho 0.")
else:
    phan_du = so_1 % so_2
    print("Phần dư của hai số là:", phan_du)