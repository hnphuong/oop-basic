import json
import sys
import os

input = sys.stdin.readline

# Đọc JSON đúng cấu trúc
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
json_path = os.path.join(BASE_DIR, "tips.json")

with open(json_path, "r", encoding="utf-8") as f:
    data = json.load(f)
    tips = data["tips"]

T = int(input())

for _ in range(T):
    sex, smoker = input().split()

    bills = [
        float(item["total_bill"])
        for item in tips
        if item["sex"] == sex and item["smoker"] == smoker
    ]

    if not bills:
        print("0.0000 0.0000 0.0000 0.0000")
        continue

    total_sum = sum(bills)
    avg = total_sum / len(bills)
    max_val = max(bills)
    min_val = min(bills)

    print(f"{total_sum:.4f} {avg:.4f} {max_val:.4f} {min_val:.4f}")
