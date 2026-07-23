-- câu 1
SELECT
    cn.MaChiNhanh,
    cn.TenChiNhanh,
    kv.TenKhuVuc,
    cn.DiaChi
FROM ChiNhanh AS cn
INNER JOIN KhuVuc AS kv
    ON cn.MaKhuVuc = kv.MaKhuVuc
WHERE kv.TenKhuVuc IN (N'Miền Trung', N'Miền Nam') order by cn.MaKhuVuc, cn.MaChiNhanh;

SELECT
    cn.MaChiNhanh,
    cn.TenChiNhanh,
    kv.TenKhuVuc,
    cn.DiaChi
FROM ChiNhanh AS cn
INNER JOIN KhuVuc AS kv
    ON cn.MaKhuVuc = kv.MaKhuVuc
WHERE kv.MaKhuVuc  IN ('MT', 'MN') order by cn.MaKhuVuc, cn.MaChiNhanh;

-- câu 2
select
	hd.MaHoaDon ,
	hd.NgayLap,
	cn.TenChiNhanh ,
	kh.HoTen
from
	HoaDon hd
inner join ChiNhanh cn 
on
	hd.MaChiNhanh = cn.MaChiNhanh
inner join KhachHang kh 
on
	hd.MaKhachHang = kh.MaKhachHang
inner join KhuVuc kv 
on
	kv.MaKhuVuc = cn.MaKhuVuc
WHERE
	kv.TenKhuVuc IN (N'Miền Bắc');

--WITH TongHoaDon AS (select * from)

SELECT
    hd.MaHoaDon AS [Mã hóa đơn],
    hd.NgayLap AS [Ngày lập],
    cn.TenChiNhanh AS [Tên chi nhánh],
    kh.HoTen AS [Tên khách hàng],
    cthd.SoLuong  * cthd.DonGia  AS [Tổng thanh toán]
FROM HoaDon AS hd
INNER JOIN ChiNhanh AS cn
    ON hd.MaChiNhanh = cn.MaChiNhanh
INNER JOIN KhachHang AS kh
    ON hd.MaKhachHang = kh.MaKhachHang
INNER JOIN KhuVuc AS kv
    ON cn.MaKhuVuc = kv.MaKhuVuc
INNER Join ChiTietHoaDon cthd 
	On hd.MaHoaDon = cthd.MaHoaDon 
WHERE kv.TenKhuVuc = N'Miền Bắc'
  AND cthd.SoLuong  * cthd.DonGia >= 20000000;
-- câu 2 
SELECT
    hd.MaHoaDon AS [Mã hóa đơn],
    hd.NgayLap AS [Ngày lập],
    cn.TenChiNhanh AS [Tên chi nhánh],
    kh.HoTen AS [Tên khách hàng],
	SUM(cthd.SoLuong * cthd.DonGia * (1 + cthd.ThueVAT / 100.0)) - hd.GiamGia AS [Tổng thanh toán]
FROM HoaDon AS hd
INNER JOIN ChiNhanh AS cn
    ON hd.MaChiNhanh = cn.MaChiNhanh
INNER JOIN KhachHang AS kh
    ON hd.MaKhachHang = kh.MaKhachHang
INNER JOIN KhuVuc AS kv
    ON cn.MaKhuVuc = kv.MaKhuVuc
INNER JOIN ChiTietHoaDon AS cthd
    ON hd.MaHoaDon = cthd.MaHoaDon
WHERE kv.TenKhuVuc = N'Miền Bắc'
GROUP BY
    hd.MaHoaDon,
    hd.NgayLap,
    cn.TenChiNhanh,
    kh.HoTen
HAVING SUM(cthd.SoLuong * cthd.DonGia * (1 + cthd.ThueVAT / 100.0)) - hd.GiamGia >= 20000000;

WITH TongHoaDon AS (
SELECT
	hd.MaHoaDon ,
	hd.NgayLap ,
	hd.MaChiNhanh,
	hd.MaKhachHang ,
	SUM(cthd.SoLuong * cthd.DonGia * (1 + cthd.ThueVAT / 100.0)) - hd.GiamGia AS TongThanhToan
from
	HoaDon hd
join ChiTietHoaDon cthd on
	hd.MaHoaDon = cthd.MaHoaDon
GROUP by
	hd.MaHoaDon ,
	hd.NgayLap ,
	hd.MaChiNhanh,
	hd.MaKhachHang ,
	hd.GiamGia )
SELECT
	thd.MaHoaDon ,
	thd.NgayLap ,
	cn.MaChiNhanh ,
	kh.HoTen AS TenKhachHang,
	thd.TongThanhToan
from
	TongHoaDon thd
join ChiNhanh cn on
	thd.MaChiNhanh = cn.MaChiNhanh
LEFT join KhachHang kh on
	thd.MaKhachHang = kh.MaKhachHang
WHERE
	cn.MaKhuVuc = 'MB'
	and thd.TongThanhToan >= 20000000;

-- câu 3
SELECT
	kh.MaKhachHang,
    kh.HoTen,
    kh.DienThoai,
    kh.HangThanhVien 
FROM HoaDon AS hd
INNER JOIN KhachHang AS kh
    ON hd.MaKhachHang = kh.MaKhachHang
INNER JOIN ChiNhanh AS cn
    ON hd.MaChiNhanh = cn.MaChiNhanh
INNER JOIN KhuVuc AS kv
    ON cn.MaKhuVuc = kv.MaKhuVuc
WHERE cn.TenChiNhanh  like 'Chi nhánh TP.HCM%';

SELECT DISTINCT
    kh.MaKhachHang AS [Mã khách hàng],
    kh.HoTen AS [Họ tên],
    kh.DienThoai AS [Điện thoại],
    kh.HangThanhVien AS [Hạng thành viên]
FROM HoaDon AS hd
INNER JOIN KhachHang AS kh
    ON hd.MaKhachHang = kh.MaKhachHang
INNER JOIN ChiNhanh AS cn
    ON hd.MaChiNhanh = cn.MaChiNhanh
WHERE cn.TenChiNhanh LIKE N'Chi nhánh TP.HCM%';

SELECT DISTINCT
    kh.MaKhachHang AS [Mã khách hàng],
    kh.HoTen AS [Họ tên],
    kh.DienThoai AS [Điện thoại],
    kh.HangThanhVien AS [Hạng thành viên]
FROM HoaDon AS hd JOIN KhachHang AS kh
    ON hd.MaKhachHang = kh.MaKhachHang
WHERE hd.MaChiNhanh = 'CN05';

-- caau 4
select 
cn.TenChiNhanh ,
sp.MaSanPham ,
sp.TenSanPham ,
lsp.TenLoai ,
tk.SoLuongTon 
from SanPham sp 
inner join LoaiSanPham lsp 
on sp.MaLoai = lsp.MaLoai 
inner join TonKho tk 
on sp.MaSanPham = tk.MaSanPham 
INNER join ChiNhanh cn 
on cn.MaChiNhanh = tk.MaChiNhanh 
INNER join KhuVuc kv 
on kv.MaKhuVuc = cn.MaKhuVuc 
WHERE tk.SoLuongTon > 5 and kv.TenKhuVuc = N'Miền Nam' and lsp.NhomHang = N'Vàng';

select
	cn.TenChiNhanh ,
	sp.MaSanPham ,
	sp.TenSanPham ,
	lsp.TenLoai ,
	tk.SoLuongTon
from
	TonKho tk
join ChiNhanh cn on
	tk.MaChiNhanh = cn.MaChiNhanh
join SanPham sp on
	sp.MaSanPham = tk.MaSanPham
JOIN LoaiSanPham lsp on
	lsp.MaLoai = sp.MaLoai
WHERE
	cn.MaKhuVuc = 'MN'
	and lsp.NhomHang = N'Vàng'
	and tk.SoLuongTon > 5;

-- ====================================================================
-- CÂU 5: TẠO VIEW PHÂN MẢNH NGANG BẢNG TONKHO THEO 3 KHU VỰC VÀ KHÔI PHỤC
-- ====================================================================

-- 1. Tạo View phân mảnh ngang cho khu vực Miền Bắc (MaKhuVuc = 'MB')
GO
CREATE VIEW vw_TonKho_MienBac AS
SELECT 
    tk.MaChiNhanh, 
    tk.MaSanPham, 
    tk.SoLuongTon, 
    tk.MucTonToiThieu
FROM TonKho tk
INNER JOIN ChiNhanh cn ON tk.MaChiNhanh = cn.MaChiNhanh
WHERE cn.MaKhuVuc = 'MB';
GO

-- 2. Tạo View phân mảnh ngang cho khu vực Miền Trung (MaKhuVuc = 'MT')
CREATE VIEW vw_TonKho_MienTrung AS
SELECT 
    tk.MaChiNhanh, 
    tk.MaSanPham, 
    tk.SoLuongTon, 
    tk.MucTonToiThieu
FROM TonKho tk
INNER JOIN ChiNhanh cn ON tk.MaChiNhanh = cn.MaChiNhanh
WHERE cn.MaKhuVuc = 'MT';
GO

-- 3. Tạo View phân mảnh ngang cho khu vực Miền Nam (MaKhuVuc = 'MN')
CREATE VIEW vw_TonKho_MienNam AS
SELECT 
    tk.MaChiNhanh, 
    tk.MaSanPham, 
    tk.SoLuongTon, 
    tk.MucTonToiThieu
FROM TonKho tk
INNER JOIN ChiNhanh cn ON tk.MaChiNhanh = cn.MaChiNhanh
WHERE cn.MaKhuVuc = 'MN';
GO

-- ====================================================================
-- SỬ DỤNG UNION ALL ĐỂ KHÔI PHỤC DỮ LIỆU TỒN KHO TOÀN HỆ THỐNG
-- ====================================================================

SELECT * FROM vw_TonKho_MienBac 
UNION ALL 
SELECT * FROM vw_TonKho_MienTrung 
UNION ALL 
SELECT * FROM vw_TonKho_MienNam;
GO

-- câu 6: Từ bảng HoaDon, chỉ hiển thị các thuộc tính phục vụ quản lý thanh
-- toán gồm mã hóa đơn, ngày lập, hình thức thanh toán, giảm giá và trạng thái.
-- Điều kiện hình thức thanh toán là ‘Chuyển khoản’.

select
	hd.MaHoaDon ,
	hd.NgayLap ,
	hd.HinhThucTT ,
	hd.GiamGia ,
	hd.TrangThai
from
	HoaDon hd
WHERE
	hd.HinhThucTT = N'Chuyển khoản';

-- câu 7: Tạo hai View mô phỏng phân mảnh dọc bảng KhachHang:
--Mảnh thông tin liên hệ: Mã khách hàng; Họ tên; Điện thoại; Địa chỉ.
--Tên view: vw_KhachHang_LienHe.
--Mảnh thông tin thành viên: Mã khách hàng; Hạng thành viên; Điểm
--tích lũy. Tên view: vw_KhachHang_ThanhVien.

CREATE VIEW vw_KhachHang_LienHe AS
SELECT 
    kh.MaKhachHang , kh.HoTen , kh.DienThoai , kh.DiaChi
FROM KhachHang kh;

CREATE VIEW vw_KhachHang_ThanhVien AS
SELECT 
    kh.MaKhachHang , kh.HangThanhVien  , kh.DiemTichLuy
FROM KhachHang kh;

select * from vw_KhachHang_LienHe vkhlh ;
select * from vw_KhachHang_ThanhVien vkhtv ;

--câu 8: Khôi phục thông tin khách hàng từ hai mảnh dọc (hai View vừa tạo:
--vw_KhachHang_LienHe và vw_KhachHang_ThanhVien) và chỉ hiển thị các
--khách hàng có hạng thành viên ‘Vàng’

select lh.MaKhachHang , lh.HoTen , lh.DienThoai , lh.DiaChi , tv.HangThanhVien , tv.DiemTichLuy from vw_KhachHang_LienHe lh 
join vw_KhachHang_ThanhVien tv on lh.MaKhachHang = tv.MaKhachHang WHERE tv.HangThanhVien = N'Vàng' ORDER by lh.MaKhachHang DESC;

--câu 9 : Tạo hai View phân mảnh dọc bảng ChiNhanh:
--Mảnh thông tin tổ chức: Mã chi nhánh; Tên chi nhánh; Mã khu vực.
--Tên view: vw_ChiNhanh_ToChuc
--Mảnh thông tin liên hệ: Mã chi nhánh; Địa chỉ; Điện thoại; Email. Tên
--view: vw_ChiNhanh_LienHe

--Tên view: vw_ChiNhanh_ToChuc
CREATE VIEW vw_ChiNhanh_ToChuc AS
SELECT
	cn.MaChiNhanh ,
	cn.TenChiNhanh ,
	cn.MaKhuVuc
from
	ChiNhanh cn ;
--view: vw_ChiNhanh_LienHe
CREATE VIEW vw_ChiNhanh_LienHe AS
SELECT
	cn.MaChiNhanh ,
	cn.DiaChi ,
	cn.DienThoai ,
	cn.Email
from
	ChiNhanh cn ;

SELECT cn.MaChiNhanh , cn.TenChiNhanh , cn.MaKhuVuc from ChiNhanh cn ;
SELECT cn.MaChiNhanh , cn.DiaChi , cn.DienThoai , cn.Email  from ChiNhanh cn ;

select * from vw_ChiNhanh_ToChuc;
select * from vw_ChiNhanh_LienHe;

-- cau 10: Sử dụng hai mảnh dọc của bảng ChiNhanh (hai View vừa tạo:
--vw_ChiNhanh_ToChuc và vw_ChiNhanh_LienHe), kết hợp với bảng
--KhuVuc, để hiển thị đầy đủ thông tin các chi nhánh theo từng miền.

SELECT
	vtc.MaChiNhanh ,
	vtc.TenChiNhanh,
	kv.TenKhuVuc  ,
	vlh.DiaChi ,
	vlh.DienThoai ,
	vlh.Email
from
	vw_ChiNhanh_ToChuc vtc
join vw_ChiNhanh_LienHe vlh
on
	vtc.MaChiNhanh = vlh.MaChiNhanh
join KhuVuc kv 
on kv.MaKhuVuc = vtc.MaKhuVuc ORDER BY kv.MaKhuVuc ;

WITH vvChiNhanh AS (
SELECT
	vtc.MaChiNhanh ,
	vtc.TenChiNhanh,
	vtc.MaKhuVuc ,
	vlh.DiaChi ,
	vlh.DienThoai ,
	vlh.Email
from
	vw_ChiNhanh_ToChuc vtc
join vw_ChiNhanh_LienHe vlh
on
	vtc.MaChiNhanh = vlh.MaChiNhanh)
select
	vcn.MaChiNhanh ,
	vcn.TenChiNhanh,
	kv.TenKhuVuc ,
	vcn.DiaChi ,
	vcn.DienThoai ,
	vcn.Email
from
	vvChiNhanh vcn
join KhuVuc kv on
	vcn.MaKhuVuc = kv.MaKhuVuc
ORDER BY
	kv.MaKhuVuc ;