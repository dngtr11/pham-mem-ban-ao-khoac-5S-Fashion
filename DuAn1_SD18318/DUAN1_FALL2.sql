create database DUAN1
USE [DUAN1]
GO
/****** Object:  Table [dbo].[CachThucDongCua]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CachThucDongCua](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaCTDC] [nvarchar](10) NULL,
	[TenCTDC] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_CachThucDongCua] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaCL] [nvarchar](10) NULL,
	[TenCL] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_ChatLieu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [nvarchar](10) NULL,
	[ID_KH] [int] NULL,
	[ID_NV] [int] NULL,
	[ID_GG] [int] NULL,
	[TenNguoiNhan] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[TongTien] [float] NULL,
	[NgayDat] [date] NULL,
	[NgayGiao] [date] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[PhiVanChuyen] [float] NULL,
	[HinhThuc] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_SPCT] [int] NULL,
	[ID_HD] [int] NULL,
	[SoLuong] [int] NULL,
	[gia] [float] NULL,
	[ThanhTien] [float] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [nvarchar](10) NULL,
	[HoTen] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KieuDang]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KieuDang](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaKD] [nvarchar](10) NULL,
	[TenKD] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_KieuDang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuHoaDon]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichSuHoaDon](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_HD] [int] NULL,
	[NgayDat] [date] NULL,
	[TongTien] [float] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_LichSuaHoaDon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lop]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lop](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaL] [nvarchar](10) NULL,
	[SoLop] [int] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_Lop] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaMS] [nvarchar](10) NULL,
	[TenMS] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_MauSac] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Mu]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaMu] [nvarchar](10) NULL,
	[KieuMu] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_Mu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaNV] [nvarchar](10) NULL,
	[TenNV] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [bit] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[VaiTro] [bit] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NSX]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaNSX] [nvarchar](50) NULL,
	[TenNSX] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_NSX] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuGiamGia]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuGiamGia](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaGG] [nvarchar](10) NULL,
	[HinhThucGG] [nvarchar](50) NULL,
	[GiaTri] [float] NULL,
	[NgayBD] [date] NULL,
	[NgayKT] [date] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_PhieuGiamGia] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PTTT]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PTTT](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaPTTT] [nvarchar](10) NULL,
	[HinhThuc] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
 CONSTRAINT [PK_PTTT] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PTTTChiTiet]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PTTTChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_HD] [int] NULL,
	[ID_PTTT] [int] NULL,
	[SoTienMat] [float] NULL,
	[SoTienCK] [float] NULL,
	[TongTien] [float] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_PTTTChiTiet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaSP] [nvarchar](10) NULL,
	[TenSP] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPhamChiTiet]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPhamChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_SP] [int] NULL,
	[ID_NSX] [int] NULL,
	[ID_MS] [int] NULL,
	[ID_CL] [int] NULL,
	[ID_Size] [int] NULL,
	[ID_Mu] [int] NULL,
	[ID_KD] [int] NULL,
	[ID_Lop] [int] NULL,
	[ID_CTDC] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
	[SoLuong] [int] NULL,
	[Gia] [float] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[NguoiSua] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_SanPhamChiTiet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 11/16/2023 1:13:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaS] [nvarchar](10) NULL,
	[TenS] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_Size] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([ID_KH])
REFERENCES [dbo].[KhachHang] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([ID_NV])
REFERENCES [dbo].[NhanVien] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_PhieuGiamGia] FOREIGN KEY([ID_GG])
REFERENCES [dbo].[PhieuGiamGia] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_PhieuGiamGia]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([ID_HD])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SanPhamChiTiet] FOREIGN KEY([ID_SPCT])
REFERENCES [dbo].[SanPhamChiTiet] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SanPhamChiTiet]
GO
ALTER TABLE [dbo].[LichSuHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_LichSuHoaDon_HoaDon] FOREIGN KEY([ID_HD])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[LichSuHoaDon] CHECK CONSTRAINT [FK_LichSuHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[PTTTChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PTTTChiTiet_HoaDon] FOREIGN KEY([ID_HD])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[PTTTChiTiet] CHECK CONSTRAINT [FK_PTTTChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[PTTTChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PTTTChiTiet_PTTT] FOREIGN KEY([ID_PTTT])
REFERENCES [dbo].[PTTT] ([ID])
GO
ALTER TABLE [dbo].[PTTTChiTiet] CHECK CONSTRAINT [FK_PTTTChiTiet_PTTT]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_CachThucDongCua] FOREIGN KEY([ID_CTDC])
REFERENCES [dbo].[CachThucDongCua] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_CachThucDongCua]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_ChatLieu] FOREIGN KEY([ID_CL])
REFERENCES [dbo].[ChatLieu] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_ChatLieu]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_KieuDang] FOREIGN KEY([ID_KD])
REFERENCES [dbo].[KieuDang] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_KieuDang]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_Lop] FOREIGN KEY([ID_Lop])
REFERENCES [dbo].[Lop] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_Lop]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_MauSac] FOREIGN KEY([ID_MS])
REFERENCES [dbo].[MauSac] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_MauSac]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_Mu] FOREIGN KEY([ID_Mu])
REFERENCES [dbo].[Mu] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_Mu]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_NSX] FOREIGN KEY([ID_NSX])
REFERENCES [dbo].[NSX] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_NSX]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_SanPham] FOREIGN KEY([ID_SP])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_SanPham]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_Size] FOREIGN KEY([ID_Size])
REFERENCES [dbo].[Size] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_Size]
GO
select * from CachThucDongCua

insert into CachThucDongCua
values 
	(N'CT01', N'Kéo Khóa',1),
	( N'CT02', N'cúc bấm',1)

insert into ChatLieu
VALUES 
	( N'CL001', N'Len', 0) ,
	( N'CL002', N'Bông', 1),
	( N'CL003', N'Da', 1),
	( N'CL001', N'Len', 0)

insert into KieuDang
VALUES 
	( N'KD01', N'Thể Thao',1),
	( N'KD02', N' Lịch Sự',1),
	( N'KD03', N'Thời Trang',1),
	( N'KD04', N'Giới Trẻ',1)
select * from Lop
insert into Lop
VALUES 
	( N'L01', 1,1),
	( N'L02', 2,1),
	( N'L03', 3,1)

insert into MauSac
VALUES 
	(N'MS001', N'Đen', 1),
	( N'MS002', N'Trắng', 1),
	( N'MS003', N'Xanh Dương', 1),
	( N'MS004', N'Xanh Lá', 1),
	(N'MS005', N'Cam', 1),
	(N'MS006', N'Xám', 1),
	( N'MS007', N'Nâu', 1)

insert into Mu
VALUES 
	( N'M001', N'Mũ Cổ Dài', 1),
	( N'M002', N'Mũ Đứng', 1),
	(N'M003', N'Mũ Kết Hợp', 1),
	( N'M004', N'Mũ Baseball', 1),
	(N'M005', N'Mũ Sherpa', 1)

insert into NSX
VALUES 
	( N'NX01', N'NSX Hải Đăng', N'Hà Nội', N'0123456789', 1),
	(N'NX02', N'NSX Hoa Cỏ', N'Hà Nội', N'0987654321', 1),
	( N'NX03', N'NSX Thanh Hoa', N'Hải Phòng', N'0369852147', 1),
	( N'NX04', N'NSX Đài Bắc', N'Bắc Ninh', N'0214789653', 1)

insert into SanPham
VALUES
	( N'SP01', N'Áo Khoác Bomber',1),
	( N'SP02', N'Áo Khoác Trench',1),
	( N'SP03', N'Áo Khoác Puffer',1),
	( N'SP04', N'Áo Khoác Denim',1)

insert into Size
VALUES 
	( N'S001', N'S', 1),
	( N'S002', N'M', 1),
	( N'S003', N'L', 1),
	( N'S004', N'XL', 1)

	select * from SanPhamChiTiet
insert into SanPhamChiTiet
VALUES 
	( 1, 1, 1, 1, 1, 1, 1, 1, 1, N'tốt', 100, 500000, N'Quản Lý', N'Quản Lý', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1),
	( 2, 2, 2, 2, 2, 2, 2, 2, 2, N'tốt', 150, 600000, N'Quản Lý', N'Quản Lý', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1),
	( 3, 3, 3, 3, 3, 3, 3, 3, 1, N'tốt', 120, 550000, N'Quản Lý', N'Quản Lý', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1),
	( 4, 4, 4, 4, 4, 4, 4, 1, 2, N'tốt', 90, 480000, N'Quản Lý', N'Quản Lý', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1)


insert into PhieuGiamGia
VALUES 
	( N'GG01', N'Phieu Giam Gia 25k', 25, CAST(N'2023-11-15' AS Date), CAST(N'2023-12-15' AS Date), N'Quản Lý', N'Quản Lý', 1),
	(N'GG02', N'Phieu Giam Gia 15k', 15, CAST(N'2023-11-20' AS Date), CAST(N'2023-12-20' AS Date), N'Quản Lý', N'Quản Lý', 1),
	(N'GG03', N'Phieu Giam Gia 30k', 30, CAST(N'2023-11-25' AS Date), CAST(N'2023-12-25' AS Date), N'Quản Lý', N'Quản Lý', 1),
	(N'GG04', N'Phieu Giam Gia 55k', 55, CAST(N'2023-11-18' AS Date), CAST(N'2023-12-18' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( N'GG05', N'Phieu Giam Gia 35k', 35, CAST(N'2023-11-22' AS Date), CAST(N'2023-12-22' AS Date), N'Quản Lý', N'Quản Lý', 1)

 insert into PTTT
 values
	( N'PT01', N'Thanh toán khi nhận hàng', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý'),
	( N'PT02', N'Chuyển khoản ngân hàng', CAST(N'2023-11-12' AS Date), CAST(N'2023-11-12' AS Date), N'Quản Lý', N'Quản Lý'),
	( N'PT03', N'Thanh toán qua thẻ tín dụng', CAST(N'2023-11-13' AS Date), CAST(N'2023-11-13' AS Date), N'Quản Lý', N'Quản Lý'),
	( N'PT04', N'Ví điện tử', CAST(N'2023-11-14' AS Date), CAST(N'2023-11-14' AS Date), N'Quản Lý', N'Quản Lý'),
	( N'PT05', N'Thanh toán trực tuyến', CAST(N'2023-11-15' AS Date), CAST(N'2023-11-15' AS Date), N'Quản Lý', N'Quản Lý'),
	( N'PT06', N'Quẹt thẻ', CAST(N'2023-11-16' AS Date), CAST(N'2023-11-16' AS Date), N'Quản Lý', N'Quản Lý')

insert into PTTTChiTiet
VALUES 
	( 1, 1, 300000, 0, 300000, CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( 2, 2, 0, 500000, 500000, CAST(N'2023-11-12' AS Date), CAST(N'2023-11-12' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( 3, 3, 0, 400000, 400000, CAST(N'2023-11-13' AS Date), CAST(N'2023-11-13' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( 4, 4, 200000, 0, 200000, CAST(N'2023-11-14' AS Date), CAST(N'2023-11-14' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( 1, 5, 0, 600000, 600000, CAST(N'2023-11-15' AS Date), CAST(N'2023-11-15' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( 1, 6, 150000, 0, 150000, CAST(N'2023-11-16' AS Date), CAST(N'2023-11-16' AS Date), N'Quản Lý', N'Quản Lý', 1)

insert into KhachHang
VALUES
	( N'KH001', N'Nguyễn Văn An', 1, CAST(N'1990-01-01' AS Date), N'0123456789', N'nguyenvana@gmail.com', N'Số 10 Hàng Bài, Hoàn Kiếm, Hà Nội', CAST(N'2023-11-10' AS Date), CAST(N'2023-11-10' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( N'KH002', N'Trần Thị Bình', 0, CAST(N'1995-05-15' AS Date), N'0987654321', N'tranthib@gmail.com', N'Số 20 Lê Thái Tổ, Lý Thái Tổ, Hoàn Kiếm, Hà Nội', CAST(N'2023-11-10' AS Date), CAST(N'2023-11-10' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( N'KH003', N'Lê Văn Chi', 1, CAST(N'1988-10-20' AS Date), N'0369852147', N'levanc@gmail.com', N'Số 30 Hàng Điếu, Cửa Đông, Hoàn Kiếm, Hà Nội', CAST(N'2023-11-10' AS Date), CAST(N'2023-11-10' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( N'KH004', N'Phạm Thị Dung', 0, CAST(N'1992-08-08' AS Date), N'0214789653', N'phamthid@gmail.com', N'Số 40 Hàng Bồ, Hàng Bồ, Hoàn Kiếm, Hà Nội', CAST(N'2023-11-10' AS Date), CAST(N'2023-11-10' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( N'KH005', N'Hoàng Văn anh', 1, CAST(N'1985-03-25' AS Date), N'0901234567', N'hoangve@gmail.com', N'Số 50 Hàng Điếu, Cửa Đông, Hoàn Kiếm, Hà Nội', CAST(N'2023-11-10' AS Date), CAST(N'2023-11-10' AS Date), N'Quản Lý', N'Quản Lý', 1)

insert into NhanVien
VALUES 
	(N'NV001', N'Nguyễn Thị Thu Trang', CAST(N'1990-01-01' AS Date), 1, N'Hoàn Kiếm, Hà Nội', N'0123456789', N'nv_a@email.com', N'123456', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 1, 1),
	( N'NV002', N'Đoàn Thị Thu Hương', CAST(N'1995-05-05' AS Date), 1, N'Thanh Xuân, Hà Nội', N'0987654321', N'nv_b@email.com', N'123456', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 1, 1),
	( N'NV003', N'Lê Ngọc Anh', CAST(N'1985-10-10' AS Date), 0, N'Hoàn Kiếm, Hà Nội', N'0369852147', N'quanly_c@email.com', N'123456', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 1, 1)

insert into HoaDon
VALUES 
	( N'HD001', 1, 1, 1, N'Nguyễn Văn An', N'0123456789', 1100000, CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 30000,N'Tại quầy', N'Ghi chú 1', 1),
	( N'HD002', 2, 2, 2, N'Trần Thị Bình', N'0987654321', 1350000, CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 50000,N'Tại quầy', N'Ghi chú 2', 1),
	( N'HD003', 3, 3, 3, N'Lê Văn Chi', N'0369852147', 1160000, CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 40000,N'Tại quầy', N'Ghi chú 3', 1),
	( N'HD004', 3, 1, 4, N'Phạm Thị Dung', N'0214789653', 1350000, CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 50000,N'Chuyển Khoản', N'Ghi chú 4', 1),
	( N'HD005', 4, 2, 5, N'Hoàng Văn Anh', N'0901234567', 1400000, CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 60000,N'Chuyển Khoản', N'Ghi chú 5', 1)

insert into HoaDonChiTiet
VALUES 
	( 6, 1, 2, 500000, 1000000, N'Quản Lý', N'Quản Lý', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1),
	( 7, 2, 1, 600000, 600000, N'Quản Lý', N'Quản Lý', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1),
	( 8, 3, 3, 550000, 1650000, N'Quản Lý', N'Quản Lý', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1),
	( 9, 4, 2, 480000, 960000, N'Quản Lý', N'Quản Lý', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1)
select * from HoaDonChiTiet
insert into LichSuHoaDon
VALUES
	( 1, CAST(N'2023-11-11' AS Date), 500000, CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( 2, CAST(N'2023-11-10' AS Date), 750000, CAST(N'2023-11-10' AS Date), CAST(N'2023-11-10' AS Date), N'Quản Lý', N'Quản Lý', 1),
	(3, CAST(N'2023-11-09' AS Date), 600000, CAST(N'2023-11-09' AS Date), CAST(N'2023-11-09' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( 4, CAST(N'2023-11-08' AS Date), 900000, CAST(N'2023-11-08' AS Date), CAST(N'2023-11-08' AS Date), N'Quản Lý', N'Quản Lý', 1),
	( 5, CAST(N'2023-11-07' AS Date), 800000, CAST(N'2023-11-07' AS Date), CAST(N'2023-11-07' AS Date), N'Quản Lý', N'Quản Lý', 1)

	select * from Mu
	select * from MauSac

	update HoaDon 
	set TrangThai = 0
	where MaHD = 'HD001'
	select * from HoaDonChiTiet
	select * from LichSuHoaDon
	update LichSuHoaDon
	set TrangThai = 0
	where id = 4

SELECT *
FROM NhanVien nv
JOIN HoaDon hd ON nv.ID = hd.ID_NV
LEFT JOIN LichSuHoaDon lshd ON hd.ID = lshd.ID_HD;

select * 
from HoaDon hd
join NhanVien nv on nv.ID = hd.ID_NV
where MaHD like '%HD001%' or MaNV like '%HD001%';
select * from NhanVien	
select * 
from HoaDon hd
join HoaDonChiTiet hdct on hdct.ID_HD = hd.ID
left join SanPhamChiTiet spct on spct.ID = hdct.ID_SPCT
select * from HoaDonChiTiet
select * 
from HoaDonChiTiet hdct
join HoaDon hd on hd.ID = hdct.ID_HD
left join SanPhamChiTiet spct on spct.ID = hdct.ID_SPCT
join SanPham sp on sp.ID = spct.ID_SP
join CachThucDongCua ctdc on 

SELECT *
FROM HoaDon hd
JOIN NhanVien nv  ON nv.ID  = hd.ID_NV
LEFT JOIN LichSuHoaDon lshd ON lshd.ID_HD = hd.ID;	
SELECT * FROM HoaDon
WHERE NgayDat BETWEEN '2023-11-01' AND '2023-11-11';

select 
* from LichSuHoaDon lshd
join HoaDon hd on hd.ID = lshd.ID_HD
where MaHD like '%HD001%' or TenNguoiNhan like '%HD001%'
SELECT *
FROM LichSuHoaDon lshd
JOIN HoaDon hd ON hd.ID = lshd.ID_HD
LEFT JOIN NhanVien nv ON nv.ID = hd.ID_NV;
select * from HoaDon
select * from SanPhamChiTiet
select * 
from HoaDonChiTiet hdct 
join SanPhamChiTiet spct on hdct.ID_SPCT = spct.ID
left join HoaDon hd on hdct.ID_HD = hd.ID
where hd.MaHD like '%HD006%'

select SanPhamChiTiet.id ,
	SanPham.MaSP ,
	SanPham.TenSP ,
	NSX.TenNSX ,
	MauSac.TenMS ,
	CachThucDongCua.TenCTDC,
	ChatLieu.TenCL,
	KieuDang.TenKD,
	Lop.SoLop,
	Mu.KieuMu,
	Size.TenS,
	HoaDonChiTiet.gia,
	HoaDonChiTiet.SoLuong,
	HoaDonChiTiet.gia*HoaDonChiTiet.SoLuong as thanhTien
from SanPhamChiTiet
join SanPham on SanPham.ID = SanPhamChiTiet.ID_SP
join NSX on NSX.ID = SanPhamChiTiet.ID_NSX
join MauSac on MauSac.ID = SanPhamChiTiet.ID_MS
join CachThucDongCua on CachThucDongCua.ID = SanPhamChiTiet.ID_CTDC
join ChatLieu on ChatLieu.ID = SanPhamChiTiet.ID_CL
join KieuDang on KieuDang.ID = SanPhamChiTiet.ID_KD
join Lop on Lop.ID = SanPhamChiTiet.ID_Lop
join Mu on Mu.ID = SanPhamChiTiet.ID_Mu
join Size on Size.ID = SanPhamChiTiet.ID_Size
join HoaDonChiTiet on SanPhamChiTiet.ID = HoaDonChiTiet.ID_SPCT
join HoaDon on HoaDonChiTiet.ID_HD = HoaDon.ID
where HoaDon.MaHD = 'HD001'
select * from HoaDonChiTiet
select HoaDonChiTiet.ID,HoaDon.ID from  SanPhamChiTiet
join SanPham on SanPham.ID = SanPhamChiTiet.ID_SP
join NSX on NSX.ID = SanPhamChiTiet.ID_NSX
join MauSac on MauSac.ID = SanPhamChiTiet.ID_MS
join CachThucDongCua on CachThucDongCua.ID = SanPhamChiTiet.ID_CTDC
join ChatLieu on ChatLieu.ID = SanPhamChiTiet.ID_CL
join KieuDang on KieuDang.ID = SanPhamChiTiet.ID_KD
join Lop on Lop.ID = SanPhamChiTiet.ID_Lop
join Mu on Mu.ID = SanPhamChiTiet.ID_Mu
join Size on Size.ID = SanPhamChiTiet.ID_Size
join HoaDonChiTiet on SanPhamChiTiet.ID = HoaDonChiTiet.ID_SPCT
join HoaDon on HoaDonChiTiet.ID_HD = HoaDon.ID
where HoaDon.MaHD = 'HD001'