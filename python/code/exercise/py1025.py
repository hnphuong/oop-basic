def remove_duplicates():
    k = int(input())  
    numbers = []  
    seen = set()  

    for _ in range(k):
        num = int(input()) 
        if num not in seen:  
            numbers.append(num) 
            seen.add(num) 

    print(" ".join(map(str, numbers))) 

remove_duplicates()
