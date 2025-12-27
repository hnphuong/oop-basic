chuoi = input("Nhập một chuỗi: ")

chuoi_sach = chuoi.replace(" ", "").lower()

if chuoi_sach == chuoi_sach[::-1]:
    print("=> Đây là chuỗi đối xứng.")
else:
    print("=> Đây KHÔNG phải là chuỗi đối xứng.")