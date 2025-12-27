chuoi = input("Nhập một chuỗi bất kỳ: ")

tan_suat = {}

for ky_tu in chuoi:
    if ky_tu in tan_suat:
        tan_suat[ky_tu] += 1
    else:
        tan_suat[ky_tu] = 1
print("Số lần xuất hiện của mỗi ký tự:")
for ky_tu, so_lan in tan_suat.items():
    print(f"'{ky_tu}': {so_lan}")