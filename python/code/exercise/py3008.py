import sys

def xu_ly_truy_van_gia_tri():
    input_lines = sys.stdin.readlines()
    if not input_lines:
        return

    line_index = 0
    
    try:
        nq_line = input_lines[line_index].strip().split()
        N = int(nq_line[0])
        Q = int(nq_line[1])
        line_index += 1
    except (IndexError, ValueError):
        return
    item_prices = {} 
    
    for i in range(N):
        try:
            line = input_lines[line_index].strip().split()
            item_name = line[0]
            price = int(line[1])
            line_index += 1
            
            item_prices[item_name] = price
            
        except (IndexError, ValueError):
            break

    query_lines = input_lines[line_index: line_index + Q]
    
    for query_line in query_lines:
        try:
            parts = query_line.strip().split()
            
            if not parts:
                continue
                
            query_items = parts[1:] 
            
            total_value = 0
            
            for item in query_items:
                total_value += item_prices.get(item, 0)
                
            print(total_value)
            
        except (IndexError, ValueError):
            continue

if __name__ == "__main__":
    xu_ly_truy_van_gia_tri()