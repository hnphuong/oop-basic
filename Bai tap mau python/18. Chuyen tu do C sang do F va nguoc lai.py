def c_to_f(c):
    return c * 9 / 5 + 32

def f_to_c(f):
    return (f - 32) * 5 / 9
print("Chọn loại chuyển đổi:")
print("1: Độ C sang Độ F")
print("2: Độ F sang Độ C")

chon = input("Nhập lựa chọn (1 hoặc 2): ")

if chon == '1':
    c = float(input("Nhập nhiệt độ độ C: "))
    f = c_to_f(c)
    print(f"{c}°C = {f:.2f}°F")
elif chon == '2':
    f = float(input("Nhập nhiệt độ độ F: "))
    c = f_to_c(f)
    print(f"{f}°F = {c:.2f}°C")
else:
    print("Lựa chọn không hợp lệ.")