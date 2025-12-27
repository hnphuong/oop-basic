def encode_string(s):
    if not s:
        return ""

    encoded_result = []
    n = len(s)
    i = 0
    
    while i < n:
        current_char = s[i]
        count = 1
        j = i + 1
        
        while j < n and s[j] == current_char:
            count += 1
            j += 1
        
        encoded_result.append(str(count))
        encoded_result.append(current_char)
        
        i = j
    return "".join(encoded_result)

t = 0
while t <= 0 or t > 10:
    t = int(input().strip())
for _ in range(t):
    s = input().strip()
    encoded_s = encode_string(s)
    print(encoded_s)
