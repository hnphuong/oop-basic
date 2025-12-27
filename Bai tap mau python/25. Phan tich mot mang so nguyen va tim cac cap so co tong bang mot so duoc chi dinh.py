def tim_cap_tong_bang_k(mang, tong_can_tim):
    ket_qua = []
    da_gap = set()  

    for so in mang:
        hieu = tong_can_tim - so
        if hieu in da_gap:
            ket_qua.append((hieu, so))  
        da_gap.add(so)

    return ket_qua
