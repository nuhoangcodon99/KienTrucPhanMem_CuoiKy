package fit.iuh.edu.vn.student_service.configs;

import fit.iuh.edu.vn.student_service.entities.*;
import fit.iuh.edu.vn.student_service.enums.*;
import fit.iuh.edu.vn.student_service.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataSampleConfig {
    private final BangDiemRepository bangDiemRepository;
    private final ChuongTrinhKhungRepository chuongTrinhKhungRepository;
    private final GiangVienLopHocPhanRepository giangVienLopHocPhanRepository;
    private final GiangVienRepository giangVienRepository;
    private final KhoaHocRepository khoaHocRepository;
    private final KhoaRepository khoaRepository;
    private final LoaiSinhVienRepository loaiSinhVienRepository;
    private final LopHocDanhNghiaRepository lopHocDanhNghiaRepository;
    private final LopHocPhanRepository lopHocPhanRepository;
    private final MonHocChuongTrinhKhungRepository monHocChuongTrinhKhungRepository;
    private final MonHocRepository monHocRepository;
    private final MonHocTienQuyetRepository monHocTienQuyetRepository;
    private final NganhHocRepository nganhHocRepository;
    private final SinhVienRepository sinhVienRepository;
    private final LichHocTHRepository lichHocTHRepository;

    //    @Bean
    CommandLineRunner test() {
        return args -> {
            List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungs = monHocChuongTrinhKhungRepository.findMonHocChuongTrinhKhungByMssv(20111601);
            for (MonHocChuongTrinhKhung monHocChuongTrinhKhung : monHocChuongTrinhKhungs) {
                System.out.println("Môn học chương trình khung:" + monHocChuongTrinhKhung);
            }
        };
    }

//                @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            // insert Khoa
            Khoa khoaCNTT = new Khoa("Công nghệ thông tin");
            Khoa khoaCK = new Khoa("Cơ khí");
            Khoa khoaLuat = new Khoa("Luật");
            Khoa khoaHoa = new Khoa("Hóa");
            Khoa khoaDongLuc = new Khoa("Động lực");
            Khoa khoaThucPham = new Khoa("Thực phẩm");
            Khoa khoaThoiTrang = new Khoa("Thời trang");

            khoaRepository.save(khoaCNTT);
            khoaRepository.save(khoaCK);
            khoaRepository.save(khoaLuat);
            khoaRepository.save(khoaHoa);
            khoaRepository.save(khoaDongLuc);
            khoaRepository.save(khoaThucPham);
            khoaRepository.save(khoaThoiTrang);

            // insert Nganh hoc
            NganhHoc nganhKTPM = new NganhHoc("Kỹ thuật phần mềm", khoaCNTT);
            NganhHoc nganhHTTT = new NganhHoc("Hệ thống thông tin", khoaCNTT);
            NganhHoc nganhATTT = new NganhHoc("An toàn thông tin", khoaCNTT);
            NganhHoc nganhKHDL = new NganhHoc("Khoa học dữ liệu", khoaCNTT);
            NganhHoc oto = new NganhHoc("Ô tô", khoaDongLuc);
            NganhHoc nganhHocKT = new NganhHoc("Tài chính ngân hàng", khoaLuat);
            nganhHocRepository.save(nganhKTPM);
            nganhHocRepository.save(nganhHTTT);
            nganhHocRepository.save(nganhATTT);
            nganhHocRepository.save(nganhKHDL);
            nganhHocRepository.save(nganhHocKT);
            nganhHocRepository.save(oto);

            // insert Giang vien
            GiangVien gv1 = new GiangVien(
                    "Võ Văn Hải",
                    "TS",
                    "0339717894",
                    "666 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(1986, 6, 13, 0, 0),
                    khoaCNTT
            );
            GiangVien gv2 = new GiangVien(
                    "Nguyễn Tuấn Hiệp",
                    "Ths",
                    "0339717894",
                    "111 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(2002, 9, 18, 0, 0),
                    khoaLuat
            );
            GiangVien gv3 = new GiangVien(
                    "Tôn Long Phước",
                    "TS",
                    "0339717899",
                    "111 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(1983, 2, 2, 0, 0),
                    khoaCNTT
            );
            GiangVien gv4 = new GiangVien(
                    "Nguyễn Thị Hoàng Khánh",
                    "TS",
                    "0339717891",
                    "222 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(1988, 6, 13, 0, 0),
                    khoaCNTT
            );
            giangVienRepository.save(gv1);
            giangVienRepository.save(gv2);
            giangVienRepository.save(gv3);
            giangVienRepository.save(gv4);
            // insert Khoa hoc
            KhoaHoc khoa14 = new KhoaHoc("K14", 2018);
            KhoaHoc khoa15 = new KhoaHoc("K15", 2019);
            KhoaHoc khoa16 = new KhoaHoc("K16", 2020);
            KhoaHoc khoa17 = new KhoaHoc("K17", 2021);
            KhoaHoc khoa18 = new KhoaHoc("K18", 2022);
            khoaHocRepository.save(khoa16);
            khoaHocRepository.save(khoa17);
            khoaHocRepository.save(khoa18);
            khoaHocRepository.save(khoa14);
            khoaHocRepository.save(khoa15);

            // insert Chuong trinh khung
            ChuongTrinhKhung chuongTrinhKhung1 = new ChuongTrinhKhung("9", nganhKTPM, khoa16);
            ChuongTrinhKhung chuongTrinhKhung2 = new ChuongTrinhKhung("9", nganhKTPM, khoa17);
            ChuongTrinhKhung chuongTrinhKhung3 = new ChuongTrinhKhung("9", nganhHocKT, khoa18);
            chuongTrinhKhungRepository.save(chuongTrinhKhung1);
            chuongTrinhKhungRepository.save(chuongTrinhKhung2);
            chuongTrinhKhungRepository.save(chuongTrinhKhung3);
            // insert Loai sinh vien
            LoaiSinhVien loaiSinhVien1 = new LoaiSinhVien(TenLoai.DANG_HOC);
            LoaiSinhVien loaiSinhVien2 = new LoaiSinhVien(TenLoai.THOI_HOC);
            LoaiSinhVien loaiSinhVien3 = new LoaiSinhVien(TenLoai.DA_TOT_NGHIEP);
            loaiSinhVienRepository.save(loaiSinhVien1);
            loaiSinhVienRepository.save(loaiSinhVien2);
            loaiSinhVienRepository.save(loaiSinhVien3);
            // insert Lop hoc danh nghia
            LopHocDanhNghia lopHocDanhNghia1 = new LopHocDanhNghia("DHKTPM16A",
                    BacDaoTao.DAI_HOC,
                    "Chính quy",
                    gv1,
                    nganhKTPM,
                    khoa16
            );
            LopHocDanhNghia lopHocDanhNghia2 = new LopHocDanhNghia("DKKTTC17B",
                    BacDaoTao.THAC_SI,
                    "Chính quy",
                    gv2,
                    nganhHocKT,
                    khoa17
            );
            LopHocDanhNghia lopHocDanhNghia3 = new LopHocDanhNghia("DKTPM17A",
                    BacDaoTao.DAI_HOC,
                    "Chính quy",
                    gv1,
                    nganhKTPM,
                    khoa17
            );
            lopHocDanhNghiaRepository.save(lopHocDanhNghia1);
            lopHocDanhNghiaRepository.save(lopHocDanhNghia2);
            lopHocDanhNghiaRepository.save(lopHocDanhNghia3);
            // insert Mon hoc
            MonHoc monHocLTHDT = new MonHoc("Lập trình hướng đối tượng", khoaCNTT);
            MonHoc monHocCTDLvaGT = new MonHoc("Cấu trúc dữ liệu và giải thuật", khoaCNTT);
            MonHoc monhocPTvaTKHT = new MonHoc("Phân tích và thiết kế hệ thống", khoaCNTT);
            MonHoc monKienTruc = new MonHoc("Kiến trúc phần mềm", khoaCNTT);
            MonHoc monKTLT = new MonHoc("Kỹ thuật lập trình", khoaCNTT);
            MonHoc monLTDT = new MonHoc("Lý thuyết đồ thị", khoaCNTT);
            MonHoc monMMT = new MonHoc("Mạng máy tính", khoaCNTT);
            MonHoc monhocCNM = new MonHoc("Công nghệ mới", khoaCNTT);
            MonHoc monHocWWW = new MonHoc("Lập trình WWW", khoaCNTT);
            MonHoc monHoc2 = new MonHoc("Luật kinh tế", khoaLuat);
            monHocRepository.save(monHocLTHDT);
            monHocRepository.save(monHocCTDLvaGT);
            monHocRepository.save(monhocPTvaTKHT);
            monHocRepository.save(monhocCNM);
            monHocRepository.save(monHocWWW);
            monHocRepository.save(monHoc2);
            monHocRepository.save(monKienTruc);
            monHocRepository.save(monKTLT);
            monHocRepository.save(monLTDT);
            monHocRepository.save(monMMT);
            // insert Sinh vien
            SinhVien sv1 = new SinhVien(20111311,
                    "123456",
                    "Nguyễn Tuấn Hiệp",
                    LocalDateTime.of(2002, 9, 14, 0, 0),
                    "121 Quang Trung, Gò vấp ",
                    "Hải Phòng",
                    "0339717894",
                    "Nam",
                    "https://th.bing.com/th/id/R.e089a43cd9546701b048d2ab47bd45a9?rik=YUUjgVi2gtRQQw&pid=ImgRaw&r=0",
                    "bohiepdzai@gmail.com",
                    loaiSinhVien1,
                    lopHocDanhNghia1
            );
            SinhVien sv2 = new SinhVien(20111601,
                    "123456",
                    "Phan Nguyễn Hoài Hiệp",
                    LocalDateTime.of(2002, 6, 13, 0, 0),
                    "121 Lê Đức Thọ, Gò Vấp",
                    "Tây Ninh",
                    "0974067552",
                    "Nam",
                    "https://th.bing.com/th/id/OIP.mIf9ZAHku6YCPc4qT14avgHaK0?rs=1&pid=ImgDetMain",
                    "phhiep999@gmail.com",
                    loaiSinhVien1,
                    lopHocDanhNghia2
            );
            SinhVien sv3 = new SinhVien(20111999,
                    "123456",
                    "Phan Xích Long",
                    LocalDateTime.of(2002, 1, 1, 0, 0),
                    "121 Lê Đức Thọ, Gò Vấp",
                    "Tây Nguyên",
                    "0974067555",
                    "Nam",
                    "https://th.bing.com/th/id/R.06dfda1237b260bd72aa998b6679d0eb?rik=N0Phchug7q3nTg&pid=ImgRaw&r=0",
                    "phlong999@gmail.com",
                    loaiSinhVien1,
                    lopHocDanhNghia3
            );
            sinhVienRepository.save(sv1);
            sinhVienRepository.save(sv2);
            sinhVienRepository.save(sv3);
            // insert Lop hoc phan
            LopHocPhan lopHocPhan1 = new LopHocPhan("DHKTPM16C",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK3 (2023-2024)",
                    1200000,
                    900000,
                    1,
                    3,
                    18,
                    monKienTruc
            );
            LopHocPhan lopHocPhan6 = new LopHocPhan("DHKTPM16A",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK3 (2023-2024)",
                    1200000,
                    900000,
                    1,
                    3,
                    18,
                    monKienTruc
            );
            LopHocPhan lopHocPhan7 = new LopHocPhan("DHKTPM16B",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK3 (2023-2024)",
                    1200000,
                    900000,
                    1,
                    3,
                    18,
                    monKienTruc
            );
            LopHocPhan lopHocPhan2 = new LopHocPhan("DHCTDL17A",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK3 (2023-2024)",
                    800000,
                    900000,
                    1,
                    3,
                    18,
                    monHocCTDLvaGT
            );
            LopHocPhan lopHocPhan3 = new LopHocPhan("DHKTPM16D",
                    60,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK3 (2023-2024)",
                    1200000,
                    300000,
                    1,
                    3,
                    50,
                    monHocWWW
            );
            LopHocPhan lopHocPhan4 = new LopHocPhan("DHKTPM16E",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK3 (2023-2024)",
                    1500000,
                    500000,
                    1,
                    3,
                    20,
                    monKTLT
            );
            LopHocPhan lopHocPhan5 = new LopHocPhan("DHKTPM16F",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK3 (2023-2024)",
                    900000,
                    500000,
                    1,
                    3,
                    50,
                    monhocCNM
            );
            LopHocPhan lopHocPhan8 = new LopHocPhan("DHKTPM16F",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK2 (2023-2024)",
                    900000,
                    500000,
                    1,
                    3,
                    50,
                    monhocCNM
            );
            LopHocPhan lopHocPhan9 = new LopHocPhan("DHKTPM16F",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK2 (2023-2024)",
                    900000,
                    500000,
                    1,
                    3,
                    50,
                    monMMT
            );
            LopHocPhan lopHocPhan10 = new LopHocPhan("DHKTPM16F",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "HK2 (2023-2024)",
                    900000,
                    500000,
                    1,
                    3,
                    50,
                    monKienTruc
            );
            lopHocPhanRepository.save(lopHocPhan1);
            lopHocPhanRepository.save(lopHocPhan2);
            lopHocPhanRepository.save(lopHocPhan3);
            lopHocPhanRepository.save(lopHocPhan4);
            lopHocPhanRepository.save(lopHocPhan5);
            lopHocPhanRepository.save(lopHocPhan6);
            lopHocPhanRepository.save(lopHocPhan7);
            lopHocPhanRepository.save(lopHocPhan8);
            lopHocPhanRepository.save(lopHocPhan9);
            lopHocPhanRepository.save(lopHocPhan10);

            // insert Bang diem
            BangDiem bangDiem1 = new BangDiem(7, 5, 4, 6, 7, TrangThai.DAT,
                    LocalDateTime.of(2023, 5, 14, 0, 0),
                    TrangThaiHocPhi.DA_DONG,
                    sv1,
                    lopHocPhan1,
                    "1"
            );
            BangDiem bangDiem2 = new BangDiem(10, 9, 9, 9, 9, TrangThai.DAT,
                    LocalDateTime.of(2022, 7, 14, 0, 0),
                    TrangThaiHocPhi.DA_DONG,
                    sv2,
                    lopHocPhan1,
                    "1"
            );
            bangDiemRepository.save(bangDiem1);
            bangDiemRepository.save(bangDiem2);
            // insert Mon hoc-Chuong trinh khung
            MonHocChuongTrinhKhung monHocChuongTrinhKhung1 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monHocLTHDT,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung2 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monHoc2,
                    chuongTrinhKhung2
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung3 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.TUY_CHON,
                    1,
                    3,
                    monHocCTDLvaGT,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung4 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.TUY_CHON,
                    1,
                    3,
                    monhocPTvaTKHT,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung5 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monHocWWW,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung6 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monhocCNM,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung7 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monMMT,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung8 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monKienTruc,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung9 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monKTLT,
                    chuongTrinhKhung1
            );
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung1);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung2);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung3);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung4);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung5);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung6);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung7);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung8);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung9);

            // insert Mon hoc tien quyet
            MonHocTienQuyet monHocTienQuyet1 = new MonHocTienQuyet(monHocLTHDT, monHocWWW);
            MonHocTienQuyet monHocTienQuyet2 = new MonHocTienQuyet(monHocLTHDT, monHocCTDLvaGT);
            monHocTienQuyetRepository.save(monHocTienQuyet1);
            monHocTienQuyetRepository.save(monHocTienQuyet2);

            // Insert giang vien lop hoc phan và Lop hoc thuc hanh: insert Lich hoc thuc hanh sau do insert giang vien lop hoc phan
            List<String> lichHoc1 = new ArrayList<>();
            lichHoc1.add("Thứ 3 (T7 - T9)_05/18/2024");
            lichHoc1.add("Thứ 5 (T1 - T3)_05/18/2024");
            lichHoc1.add("Thứ 6 (T4 - T6)_05/18/2024");

            LichHocTH lichHocTH1 = new LichHocTH(
                    "1",
                    "Tructiep_X_X8.01",
                    lichHoc1
            );
            List<String> lichHocLTs = new ArrayList<>();
            lichHocLTs.add("Thứ 2(T1-3)");
            lichHocLTs.add("Thứ 3(T1-3)");
            lichHocLTs.add("Thứ 4(T1-3)");
            List<LichHocTH> lichHocTHList1 = new ArrayList<>();
            lichHocTHList1.add(lichHocTH1);
            GiangVienLopHocPhan giangVienLopHocPhan1 = new GiangVienLopHocPhan(
                    LoaiLichHoc.TH,
                    "Tructiep_X_X8.01",
                    lichHocLTs,
                    LocalDateTime.of(2024, 6, 13, 2, 1),
                    gv1,
                    lopHocPhan1,
                    lichHocTHList1
            );
            lichHocTH1.setGiangVienLopHocPhan(giangVienLopHocPhan1);
            giangVienLopHocPhanRepository.save(giangVienLopHocPhan1);
//            ============================================================================
            List<String> lichHoc2 = new ArrayList<>();
            lichHoc2.add("Thứ 3 (T7 - T9)_05/20/2024");
            lichHoc2.add("Thứ 5 (T1 - T3)_05/20/2024");
            lichHoc2.add("Thứ 6 (T4 - T6)_05/20/2024");
            LichHocTH lichHocTH2 = new LichHocTH(
                    "2",
                    "Tructiep_X_V2.01",
                    lichHoc2
            );
            List<LichHocTH> lichHocTHList2 = new ArrayList<>();
            lichHocTHList2.add(lichHocTH2);
//            lichHocTHRepository.save(lichHocTH1);
//            lichHocTHRepository.save(lichHocTH2);

            GiangVienLopHocPhan giangVienLopHocPhan2 = new GiangVienLopHocPhan(
                    LoaiLichHoc.LT,
                    "Tructuyen_Zoom_2888888_8888",
                    lichHocLTs,
                    LocalDateTime.of(2024, 6, 14, 2, 1),
                    gv3,
                    lopHocPhan2,
                    lichHocTHList2
            );
            lichHocTH2.setGiangVienLopHocPhan(giangVienLopHocPhan2);
            giangVienLopHocPhanRepository.save(giangVienLopHocPhan2);
//            "Tructuyen_Zoom_2888888_8888"
        };
    }

}