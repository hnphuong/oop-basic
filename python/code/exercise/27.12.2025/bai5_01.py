import json
import os

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
json_path = os.path.join(BASE_DIR, 'tips.json')

with open(json_path, encoding='utf-8') as f:
    du_lieu = json.load(f)['tips']

n = int(input())

for _ in range(n):
    dong = input().strip().split()
    gioi_tinh = dong[0]
    hut_thuoc = dong[1]

    # Lấy danh sách total_bill phù hợp
    hoa_don_phu_hop = []

    for item in du_lieu:
        if item['sex'] == gioi_tinh and item['smoker'] == hut_thuoc:
            hoa_don_phu_hop.append(float(item['total_bill']))

    if hoa_don_phu_hop:
        tong = sum(hoa_don_phu_hop)
        tb = tong / len(hoa_don_phu_hop)
        lon_nhat = max(hoa_don_phu_hop)
        nho_nhat = min(hoa_don_phu_hop)

        print(f"{tong:.4f} {tb:.4f} {lon_nhat:.4f} {nho_nhat:.4f}")
    else:
        print("0.0000 0.0000 0.0000 0.0000")
