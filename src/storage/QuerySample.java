package storage;

public class QuerySample {
    public static String queryThem_MoiRaDoi = "INSERT INTO nhankhau(MaSoHK, HoTen, BiDanh, NgaySinh, GioiTinh, NoiSinh, NguyenQuan, DanToc, NgayDangKyThuongTru, DiaChiTruocKhiChuyenDen, QuanHeVoiChuHo, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, \'Mới sinh\', ?, \'Mới sinh\')";
    public static String queryThem_ChuyenToi = "INSERT INTO nhankhau(MaSoHK, HoTen, BiDanh, NgaySinh, GioiTinh, NoiSinh, NguyenQuan, DanToc, NgheNghiep, NoiLamViec, SoCMND_CCCD, NgayCap, NoiCap, NgayDangKyThuongTru, DiaChiTruocKhiChuyenDen, QuanHeVoiChuHo, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, \'Chuyển tới\')";
    public static String queryThem_TamTru = "INSERT INTO nhankhau(MaSoHK, HoTen, BiDanh, NgaySinh, GioiTinh, NoiSinh, NguyenQuan, DanToc, NgheNghiep, NoiLamViec, SoCMND_CCCD, NgayCap, NoiCap, NgayDangKyThuongTru, DiaChiTruocKhiChuyenDen, QuanHeVoiChuHo, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, \'Tạm trú\')";
    public static String queryTim_SoHK = "SELECT * FROM sohokhau WHERE maSoHK = ?";
}