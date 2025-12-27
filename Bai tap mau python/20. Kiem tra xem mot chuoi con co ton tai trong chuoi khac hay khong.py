chuoi_chinh = input("Nhập chuỗi chính: ")
chuoi_con = input("Nhập chuỗi con cần kiểm tra: ")
if chuoi_con in chuoi_chinh:
    print(f"Chuỗi '{chuoi_con}' tồn tại trong chuỗi '{chuoi_chinh}'.")
else:
    print(f"Chuỗi '{chuoi_con}' không tồn tại trong chuỗi '{chuoi_chinh}'.")