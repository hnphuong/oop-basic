document.addEventListener('DOMContentLoaded', function() {
    
    // Lấy danh sách các phần tử cần thiết
    const imageWrappers = document.querySelectorAll('.img-wrapper');
    const nameDisplay = document.getElementById('image-name');
    const clearBtn = document.getElementById('clear-btn');

    // Lặp qua từng khung ảnh để gắn sự kiện click
    imageWrappers.forEach(function(wrapper) {
        wrapper.addEventListener('click', function() {
            
            // 1. Xóa trạng thái 'được chọn' (viền xanh) khỏi toàn bộ ảnh cũ
            imageWrappers.forEach(function(w) {
                w.classList.remove('selected');
            });

            // 2. Thêm trạng thái 'được chọn' vào ảnh vừa nhấp chuột
            this.classList.add('selected');

            // 3. Đọc dữ liệu mô tả từ thẻ <img> bên trong
            const imgElement = this.querySelector('img');
            const imageName = imgElement.getAttribute('data-name');

            // 4. Hiển thị thông tin và đổi màu text cho nổi bật
            nameDisplay.textContent = "Bạn đang xem: " + imageName;
            nameDisplay.style.color = "#1a82c3";

            // 5. Hiển thị nút "Xóa chọn"
            clearBtn.classList.add('visible');
        });
    });

    // Sự kiện click cho nút "Xóa chọn"
    clearBtn.addEventListener('click', function() {
        
        // Gỡ bỏ viền xanh khỏi tất cả các ảnh
        imageWrappers.forEach(function(w) {
            w.classList.remove('selected');
        });

        // Đặt lại dòng văn bản thông báo về mặc định
        nameDisplay.textContent = "Vui lòng nhấp vào một bức ảnh để xem mô tả.";
        nameDisplay.style.color = "#666";

        // Ẩn nút "Xóa chọn" đi
        this.classList.remove('visible');
    });

});