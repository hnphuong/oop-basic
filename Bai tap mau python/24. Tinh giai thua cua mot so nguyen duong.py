def tinh_giai_thua(n):
    if n < 0:
        return None 
    giai_thua = 1
    for i in range(1, n + 1):
        giai_thua *= i
    return giai_thua

so = int(input("Nhập một số nguyên dương: "))
ket_qua = tinh_giai_thua(so)

if ket_qua is not None:
    print(f"Giai thừa của {so} là: {ket_qua}")
else:
    print("Giai thừa không xác định cho số âm.")
