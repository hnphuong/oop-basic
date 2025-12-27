def xoay_ma_tran_90_do(matrang):
    so_hang = len(matrang)
    so_cot = len(matrang[0])
    ket_qua = [[0] * so_hang for _ in range(so_cot)]
    
    for i in range(so_hang):
        for j in range(so_cot):
            ket_qua[j][so_hang - 1 - i] = matrang[i][j]
            
    return ket_qua

ma_tran = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

ma_tran_xoay = xoay_ma_tran_90_do(ma_tran)

print("Ma trận sau khi xoay 90 độ theo chiều kim đồng hồ:")
for hang in ma_tran_xoay:
    print(hang)