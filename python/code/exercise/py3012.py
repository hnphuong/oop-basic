def input_data():
    t = 0
    while (t<=0 or t>100 or not isinstance(t, int)):
        try:
            t = int(input().strip())
        except ValueError:
            continue
    lines = []
    for _ in range(t):
        parts = input().strip().split()
        count = int(parts[0])
        words = parts[1:]
        if len(words) != count:
            print("Warning: số lượng từ không khớp!")
            continue
        lines.append(words)

    return lines

def dictionary():
    t = 0
    while (t<=0 or t>100 or not isinstance(t, int)):
        try:
            t = int(input().strip())
        except ValueError:
            continue
    score = {} 
    for _ in range(t):
        word, value = input().split()
        score[word] = int(value)   
    return score

def main():
    lines = input_data()
    score = dictionary()
    rs = ''
    for words in lines:
        total = 0
        for word in words:
            if word in score:
                total += score[word]
        rs += str(total) + ' '
    print(rs.strip())
    

main()  