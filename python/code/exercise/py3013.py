def input_dictionary1():
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
    score = input_dictionary1()
    print(score)

main()