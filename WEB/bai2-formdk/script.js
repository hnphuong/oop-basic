document.getElementById('registerForm').addEventListener('submit', function(event) {
    // Ngăn chặn hành vi mặc định (tải lại trang) của form
    event.preventDefault();

    // 1. Lấy giá trị từ các ô nhập liệu và xóa khoảng trắng thừa (trim)
    const name = document.getElementById('fullname').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    // 2. Lấy các thẻ chứa thông báo lỗi
    const nameError = document.getElementById('nameError');
    const emailError = document.getElementById('emailError');
    const passwordError = document.getElementById('passwordError');
    const confirmPasswordError = document.getElementById('confirmPasswordError');

    // 3. Xóa thông báo lỗi cũ mỗi khi nhấn submit
    nameError.textContent = '';
    emailError.textContent = '';
    passwordError.textContent = '';
    confirmPasswordError.textContent = '';

    let isValid = true; // Biến cờ kiểm tra tổng thể

    // 4. Kiểm tra Họ tên (Không được để trống)
    if (name === '') {
        nameError.textContent = 'Vui lòng nhập họ và tên.';
        isValid = false;
    }

    // 5. Kiểm tra Email (Không trống và phải chứa '@' cùng '.')
    if (email === '') {
        emailError.textContent = 'Vui lòng nhập email.';
        isValid = false;
    } else if (!email.includes('@') || !email.includes('.')) {
        emailError.textContent = 'Email không hợp lệ (phải chứa ký tự @ và .).';
        isValid = false;
    }

    // 6. Kiểm tra Mật khẩu (Không trống và tối thiểu 6 ký tự)
    if (password === '') {
        passwordError.textContent = 'Vui lòng nhập mật khẩu.';
        isValid = false;
    } else if (password.length < 6) {
        passwordError.textContent = 'Mật khẩu phải có ít nhất 6 ký tự.';
        isValid = false;
    }

    // 7. Kiểm tra Xác nhận mật khẩu (Không trống và phải khớp với Mật khẩu)
    if (confirmPassword === '') {
        confirmPasswordError.textContent = 'Vui lòng xác nhận mật khẩu.';
        isValid = false;
    } else if (confirmPassword !== password) {
        confirmPasswordError.textContent = 'Xác nhận mật khẩu không khớp.';
        isValid = false;
    }

    // 8. Nếu tất cả đều hợp lệ (isValid vẫn là true)
    if (isValid) {
        alert('Chúc mừng! Bạn đã đăng ký thành công.');
        // Tùy chọn: Xóa trắng form sau khi đăng ký thành công
        this.reset();
    }
});