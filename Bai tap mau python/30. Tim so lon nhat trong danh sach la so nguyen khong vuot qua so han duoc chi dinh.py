danh_sach = input("Nhập danh sách các số nguyên (cách nhau bởi dấu cách): ")

so_nguyen = list(map(int, danh_sach.split()))

gioi_han = int(input("Nhập giới hạn: "))

so_lon_nhat = None
for so in so_nguyen:
    if so <= gioi_han:
        if (so_lon_nhat is None) or (so > so_lon_nhat):
            so_lon_nhat = so

if so_lon_nhat is not None:
    print("Số lớn nhất trong danh sách không vượt quá", gioi_han, "là:", so_lon_nhat)
else:
    print("Không có số nào trong danh sách nhỏ hơn hoặc bằng giới hạn đã cho.")