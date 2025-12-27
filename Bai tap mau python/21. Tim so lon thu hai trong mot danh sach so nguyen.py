def tim_so_lon_thu_hai(danh_sach):
    danh_sach_khac_nhau = list(set(danh_sach))

    if len(danh_sach_khac_nhau) < 2:
        return None  

    danh_sach_khac_nhau.sort(reverse=True)
    return danh_sach_khac_nhau[1]

ds = [5, 3, 9, 9, 7, 3, 2]
ket_qua = tim_so_lon_thu_hai(ds)

if ket_qua is not None:
    print("Số lớn thứ hai trong danh sách là:", ket_qua)
else:
    print("Không có số lớn thứ hai trong danh sách.")