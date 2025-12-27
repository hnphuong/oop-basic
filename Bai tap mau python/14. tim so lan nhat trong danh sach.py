ds = [3, 7, 5, 9, 12, 15, 18]
so_lon_nhat = ds[0]
for so in ds:
    if so > so_lon_nhat:
        so_lon_nhat = so
print("Số lớn nhất trong danh sách là:", so_lon_nhat)