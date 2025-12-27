ds = [3, 7, 5, 9, 12, 15, 18]
so_chan_dau_tien = None
for so in ds:
    if so % 2 == 0:
        so_chan_dau_tien = so
        break
if so_chan_dau_tien is not None:
    print("Số chẵn đầu tiên trong danh sách là:", so_chan_dau_tien)
else:
    print("Không có số chẵn trong danh sách.")