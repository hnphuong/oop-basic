document.addEventListener("DOMContentLoaded", function() {
    
    // 1. Dữ liệu danh sách sản phẩm tự đề xuất
    const products = [
        { name: "Laptop Dell XPS 15", category: "Máy tính", price: "35.000.000 đ", status: "Còn hàng" },
        { name: "Điện thoại iPhone 14 Pro", category: "Điện thoại", price: "28.000.000 đ", status: "Còn hàng" },
        { name: "Bàn phím cơ Keychron K8", category: "Phụ kiện", price: "2.500.000 đ", status: "Hết hàng" },
        { name: "Chuột Logitech MX Master 3", category: "Phụ kiện", price: "1.800.000 đ", status: "Còn hàng" },
        { name: "Màn hình LG UltraSharp 27 inch", category: "Màn hình", price: "12.000.000 đ", status: "Còn hàng" },
        { name: "Tai nghe Sony WH-1000XM5", category: "Âm thanh", price: "8.500.000 đ", status: "Còn hàng" }
    ];

    // Lấy các phần tử DOM
    const productBody = document.getElementById("productBody");
    const searchInput = document.getElementById("searchInput");
    const searchBtn = document.getElementById("searchBtn");
    const resetBtn = document.getElementById("resetBtn");
    const noResultMessage = document.getElementById("noResultMessage");
    const productTable = document.getElementById("productTable");

    // 2. Hàm in dữ liệu ra bảng
    function renderTable(data) {
        productBody.innerHTML = ""; // Xóa dữ liệu cũ trong bảng
        
        // Kiểm tra nếu mảng dữ liệu trống
        if (data.length === 0) {
            noResultMessage.classList.remove("hidden"); // Hiện thông báo lỗi
            productTable.classList.add("hidden");       // Ẩn bảng
        } else {
            noResultMessage.classList.add("hidden");    // Ẩn thông báo lỗi
            productTable.classList.remove("hidden");    // Hiện bảng
            
            // Duyệt qua dữ liệu và tạo các thẻ <tr>
            data.forEach((product, index) => {
                const tr = document.createElement("tr");
                tr.innerHTML = `
                    <td>${index + 1}</td>
                    <td style="text-align: left; font-weight: 500;">${product.name}</td>
                    <td>${product.category}</td>
                    <td style="color: #e74c3c; font-weight: bold;">${product.price}</td>
                    <td><span style="color: ${product.status === 'Còn hàng' ? '#27ae60' : '#e74c3c'};">${product.status}</span></td>
                `;
                productBody.appendChild(tr);
            });
        }
    }

    // Hiển thị toàn bộ dữ liệu lần đầu tải trang
    renderTable(products);

    // 3. Sự kiện khi nhấn nút "Tìm kiếm"
    searchBtn.addEventListener("click", function() {
        const keyword = searchInput.value.toLowerCase().trim(); // Đưa về chữ thường, bỏ khoảng trắng
        
        // Lọc sản phẩm có tên chứa từ khóa
        const filteredProducts = products.filter(product => 
            product.name.toLowerCase().includes(keyword)
        );
        
        renderTable(filteredProducts);
    });

    // Tính năng bổ sung: Tìm kiếm khi nhấn phím Enter trong ô input
    searchInput.addEventListener("keypress", function(event) {
        if (event.key === "Enter") {
            searchBtn.click();
        }
    });

    // 4. Sự kiện khi nhấn nút "Hiển thị tất cả"
    resetBtn.addEventListener("click", function() {
        searchInput.value = ""; // Xóa chữ trong ô input
        renderTable(products);  // Hiển thị lại mảng gốc
    });

});