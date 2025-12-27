import sys

def sap_xep_du_lieu_tu_test_case():
    input_lines = sys.stdin.readlines()
    if not input_lines:
        return

    line_index = 0
    
    try:
        T = int(input_lines[line_index].strip())
        line_index += 1
    except (IndexError, ValueError):
        return

    all_results = []

    for _ in range(T):
        try:
            N = int(input_lines[line_index].strip())
            line_index += 1
            
            current_data = []
            for i in range(N):
                line = input_lines[line_index].strip().split()
                line_index += 1
                
                if len(line) == 2:
                    key = line[0]
                    value = int(line[1]) 
                    current_data.append((key, value))
        
            current_data.sort(key=lambda x: x[0])
            
            for key, value in current_data:
                all_results.append(f"{key} {value}")
            
        except (IndexError, ValueError):
            break

    for result in all_results:
        print(result)

if __name__ == "__main__":
    sap_xep_du_lieu_tu_test_case()