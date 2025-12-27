import sys

def xu_ly_truy_van_gia_tri_cap_nhat():
    input_lines = sys.stdin.readlines()
    if not input_lines:
        return

    line_index = 0
    
    try:
        T = int(input_lines[line_index].strip())
        line_index += 1
    except (IndexError, ValueError):
        return

    for _ in range(T):
        try:
            N = int(input_lines[line_index].strip())
            line_index += 1
        except (IndexError, ValueError):
            break
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
        
        query_results = []
        
        while line_index < len(input_lines):
            query_line = input_lines[line_index].strip()
            line_index += 1
            
            if not query_line:
                continue
            
            if query_line.isdigit() and int(query_line) > 0 and line_index > N + 1:
                line_index -= 1 
                break

            query_items_pairs = query_line.split() 
            
            if len(query_items_pairs) % 2 != 0:
                 continue
                 
            total_value = 0
            
            for i in range(0, len(query_items_pairs), 2):
                item = query_items_pairs[i]
                total_value += item_prices.get(item, 0)
                
            query_results.append(total_value)
    
        for result in query_results:
            print(result)

if __name__ == "__main__":
    xu_ly_truy_van_gia_tri_cap_nhat()