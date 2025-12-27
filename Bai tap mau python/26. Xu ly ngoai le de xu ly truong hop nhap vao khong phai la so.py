try:
    so = float(input("Nhập một số: "))
    print(f"Bạn đã nhập số: {so}")
except ValueError:
    print("Lỗi: Giá trị bạn nhập không phải là số.")