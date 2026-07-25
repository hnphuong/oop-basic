// Đảm bảo DOM được tải xong trước khi gắn sự kiện
document.addEventListener('DOMContentLoaded', function() {
    
    // Lấy tất cả các nút "Mua ngay"
    const buyButtons = document.querySelectorAll('.buy-btn');

    // Lặp qua từng nút và gắn sự kiện click
    buyButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            
            // Lấy tên sản phẩm từ thuộc tính data-name của nút được click
            const productName = this.getAttribute('data-name');
            
            // Hiển thị thông báo (alert)
            alert("Bạn đã chọn mua: " + productName);
            
        });
    });

});