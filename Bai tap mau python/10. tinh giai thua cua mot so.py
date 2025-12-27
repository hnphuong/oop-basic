n = int(input("Nhập một số nguyên không âm: "))
if n < 0:
    print("Giai thừa không xác định cho số âm.")
else:
    giai_thua = 1
    for i in range(1, n + 1):
        giai_thua *= i
    print(f"Giai thừa của {n} là: {giai_thua}")
