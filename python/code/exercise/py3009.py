import sys

def xu_ly_du_lieu_sinh_vien():

    input_lines = sys.stdin.readlines()
    if not input_lines:
        return

    line_index = 0
    
    try:
        N = int(input_lines[line_index].strip())
        line_index += 1
    except (IndexError, ValueError):
        return

    all_student_data = []
    
    for _ in range(N):
        student_data = {}
        
        try:
            name = input_lines[line_index].strip()
            line_index += 1
            
            M = int(input_lines[line_index].strip())
            line_index += 1
            
            scores = []
            
            for __ in range(M):
                line = input_lines[line_index].strip().split()
                line_index += 1
                
                subject = line[0]
                score = int(line[1])
                scores.append((subject, score))
            all_student_data.append((name, scores))
            
        except (IndexError, ValueError):
            break
    print(N)
    
    for name, scores in all_student_data:
        print(name)
        
        print(len(scores))
        for subject, score in scores:
            print(f"{subject} {score}")

if __name__ == "__main__":
    xu_ly_du_lieu_sinh_vien()