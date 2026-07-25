document.addEventListener('DOMContentLoaded', function() {
    
    // Lấy các phần tử DOM cần thiết
    const profileImg = document.getElementById('profileImg');
    const imageModal = document.getElementById('imageModal');
    const expandedImg = document.getElementById('expandedImg');
    const closeBtn = document.getElementById('closeBtn');

    // 1. Sự kiện khi click vào ảnh đại diện
    profileImg.addEventListener('click', function() {
        imageModal.classList.add('show');       // Hiển thị modal
        expandedImg.src = this.src;             // Gán nguồn ảnh lớn bằng nguồn ảnh nhỏ
    });

    // 2. Sự kiện khi click vào nút Đóng (X)
    closeBtn.addEventListener('click', function() {
        imageModal.classList.remove('show');    // Ẩn modal
    });

    // 3. Tính năng nâng cao: Click ra ngoài khoảng trống (nền đen) để đóng ảnh
    imageModal.addEventListener('click', function(event) {
        // Nếu người dùng click vào phần nền đen (không phải click vào bức ảnh lớn)
        if (event.target === imageModal) {
            imageModal.classList.remove('show');
        }
    });

});