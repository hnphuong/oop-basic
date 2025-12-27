import sys

def xu_ly_truy_van_thanh_pho():
    city_to_country_map = {}
    
    try:
        n_line = sys.stdin.readline()
        if not n_line:
            return
        n = int(n_line.strip())
        for _ in range(n):
            line = sys.stdin.readline().strip().split()
            
            if not line:
                continue
            country_name = line[0]
            cities = line[1:]
            for city in cities:
                city_to_country_map[city] = country_name
                
        m_line = sys.stdin.readline()
        if not m_line:
            return
        m = int(m_line.strip())
    
        for _ in range(m):
            query_city = sys.stdin.readline().strip()
            country_name = city_to_country_map.get(query_city)
            if country_name:
                print(f"{query_city} {country_name}")
            
    except Exception:
        return

if __name__ == "__main__":
    xu_ly_truy_van_thanh_pho()