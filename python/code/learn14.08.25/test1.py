count_8 = 0
count_12 = 0
count_24 = 0

for i in range(5000, 10000):
    if i % 8 == 0:
        count_8 += 1
for i in range(5000, 10000):
    if i % 12 == 0:
        count_12 += 1
for i in range(5000, 10000):
    if i % 24 == 0:
        count_24 += 1

print(count_8 + count_12 - count_24)   # Kết quả: 876
