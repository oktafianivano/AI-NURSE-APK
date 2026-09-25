-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 25, 2026 at 05:40 PM
-- Server version: 8.4.3
-- PHP Version: 8.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_nurse`
--

-- --------------------------------------------------------

--
-- Table structure for table `audit_log_perawat`
--

CREATE TABLE `audit_log_perawat` (
  `id` int NOT NULL,
  `waktu` datetime DEFAULT CURRENT_TIMESTAMP,
  `nama_perawat` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `no_rm` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `aksi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `audit_log_perawat`
--

INSERT INTO `audit_log_perawat` (`id`, `waktu`, `nama_perawat`, `no_rm`, `aksi`) VALUES
(26, '2026-07-15 18:14:43', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(27, '2026-07-15 18:16:41', 'Dwita Lestari Lamaligi', 'RM-8914', 'Mengubah status pasien haland menjadi Sedang Ditangani'),
(28, '2026-07-15 18:17:01', 'Dwita Lestari Lamaligi', 'RM-8914', 'Mengubah status pasien haland menjadi Perlu Askep'),
(29, '2026-07-15 18:19:57', 'Dwita Lestari Lamaligi', 'RM-1881', 'Menyimpan Asuhan Keperawatan (Askep) untuk pasien: jewish'),
(30, '2026-07-15 18:22:32', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(31, '2026-07-15 18:26:33', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(32, '2026-07-15 18:29:34', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(33, '2026-07-15 18:29:49', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(34, '2026-07-15 18:30:32', 'Dwita Lestari Lamaligi', 'RM-9231', 'Mengubah status pasien coba coba menjadi Sedang Ditangani'),
(35, '2026-07-15 18:30:36', 'Dwita Lestari Lamaligi', 'RM-9231', 'Mengubah status pasien coba coba menjadi Perlu Askep'),
(36, '2026-07-15 18:33:49', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(39, '2026-07-15 19:54:42', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(40, '2026-07-15 19:55:56', 'Dwita Lestari Lamaligi', 'RM-9936', 'Mendaftarkan pasien baru: dea (Triase: [STATUS: HIJAU] \nPas...)'),
(41, '2026-07-15 19:56:20', 'Dwita Lestari Lamaligi', 'RM-8415', 'Mengubah status pasien dea menjadi Sedang Ditangani'),
(42, '2026-07-15 19:56:54', 'Dwita Lestari Lamaligi', 'RM-8415', 'Mengubah status pasien dea menjadi Perlu Askep'),
(43, '2026-07-15 20:02:14', 'Dwita Lestari Lamaligi', 'RM-8415', 'Menyimpan Asuhan Keperawatan (Askep) untuk pasien: dea'),
(44, '2026-07-15 22:49:18', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(45, '2026-07-15 22:55:18', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(46, '2026-07-15 23:06:47', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(47, '2026-07-16 11:19:45', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(48, '2026-07-16 11:20:48', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(49, '2026-07-16 17:49:17', 'Oktafian Ivano', '-', 'Berhasil Login (Memulai Shift)'),
(50, '2026-07-17 10:20:14', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(51, '2026-07-17 13:24:58', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(52, '2026-07-17 13:25:30', 'Dwita Lestari Lamaligi', 'RM-5314', 'Mengubah status pasien bunga  menjadi Sedang Ditangani'),
(53, '2026-07-17 13:25:55', 'Dwita Lestari Lamaligi', 'RM-5314', 'Mengubah status pasien bunga  menjadi Perlu Askep'),
(54, '2026-07-17 13:27:01', 'Dwita Lestari Lamaligi', 'RM-5314', 'Menyimpan Asuhan Keperawatan (Askep) untuk pasien: bunga '),
(55, '2026-07-17 13:27:28', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(56, '2026-07-17 13:29:15', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(57, '2026-07-17 13:30:00', 'Dwita Lestari Lamaligi', 'RM-2415', 'Mendaftarkan pasien baru: ayu (Triase: STATUS: HIJAU. Anali...)'),
(58, '2026-07-17 13:30:12', 'Dwita Lestari Lamaligi', 'RM-2415', 'Mengubah status pasien ayu menjadi Sedang Ditangani'),
(59, '2026-07-17 13:30:24', 'Dwita Lestari Lamaligi', 'RM-2415', 'Mengubah status pasien ayu menjadi Perlu Askep'),
(60, '2026-07-17 13:31:38', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(61, '2026-07-17 13:33:48', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(62, '2026-07-17 13:34:41', 'Dwita Lestari Lamaligi', 'RM-9936', 'Mengubah status pasien dea menjadi Sedang Ditangani'),
(63, '2026-07-17 13:35:07', 'Dwita Lestari Lamaligi', 'RM-1409', 'Mengubah status pasien ina menjadi Sedang Ditangani'),
(64, '2026-07-17 13:38:55', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(65, '2026-07-17 13:41:12', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(66, '2026-07-17 13:58:01', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(67, '2026-07-17 13:59:05', 'Dwita Lestari Lamaligi', 'RM-4778', 'Mengubah status pasien lany menjadi Perlu Askep'),
(68, '2026-07-17 14:00:27', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(69, '2026-07-17 14:08:27', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(70, '2026-07-17 14:09:34', 'Dwita Lestari Lamaligi', 'RM-4540', 'Mendaftarkan pasien baru: nana (Triase: KODE KUNING - Anak 1...)'),
(71, '2026-07-17 14:40:54', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(72, '2026-07-17 14:53:05', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(73, '2026-07-17 15:11:00', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(74, '2026-07-17 15:11:10', 'Dwita Lestari Lamaligi', 'RM-9936', 'Mengubah status pasien dea menjadi Perlu Askep'),
(75, '2026-07-17 15:21:20', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(76, '2026-07-17 22:42:21', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(77, '2026-07-17 22:42:34', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(78, '2026-07-17 22:44:15', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(79, '2026-07-17 22:44:25', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(80, '2026-07-18 17:48:44', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(81, '2026-07-18 17:48:52', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(82, '2026-07-18 19:56:36', 'Dwita Lestari Lamaligi', '-', 'Berhasil Login (Memulai Shift)'),
(83, '2026-07-18 19:56:47', 'Dwita Lestari Lamaligi', 'RM-1409', 'Mengubah status pasien ina menjadi Perlu Askep'),
(84, '2026-07-18 19:57:49', 'Dwita Lestari Lamaligi', 'RM-4778', 'Menyimpan Asuhan Keperawatan (Askep) untuk pasien: lany'),
(85, '2026-07-18 19:58:06', 'Dwita Lestari Lamaligi', 'RM-9231', 'Menyimpan Asuhan Keperawatan (Askep) untuk pasien: coba coba'),
(86, '2026-07-18 19:58:21', 'Dwita Lestari Lamaligi', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(87, '2026-09-26 00:00:14', 'Oktafian Ivano', '-', 'Berhasil Login (Memulai Shift)'),
(88, '2026-09-26 00:05:02', 'Oktafian Ivano', '-', 'Melakukan Logout (Mengakhiri Shift)'),
(89, '2026-09-26 00:09:59', 'Oktafian Ivano', '-', 'Berhasil Login (Memulai Shift)'),
(90, '2026-09-26 00:10:36', 'Oktafian Ivano', '-', 'Melakukan Logout (Mengakhiri Shift)');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id` int NOT NULL,
  `no_rm` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nama` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `usia` int NOT NULL,
  `suhu` decimal(4,1) NOT NULL,
  `keluhan` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `gejala_terdeteksi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hasil_triase` text COLLATE utf8mb4_unicode_ci,
  `tanggal_periksa` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `diinput_oleh` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT 'Perawat',
  `status_pasien` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT 'Menunggu Antrean'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id`, `no_rm`, `nama`, `usia`, `suhu`, `keluhan`, `gejala_terdeteksi`, `hasil_triase`, `tanggal_periksa`, `diinput_oleh`, `status_pasien`) VALUES
(4, 'RM-1858', 'ivano', 19, 0.0, 'saya demam tinggi dan pusing', NULL, 'KODE KUNING', '2026-06-22 18:52:32', 'Perawat', 'Selesai Ditangani'),
(5, 'RM-5482', 'ivano', 19, 0.0, 'saya demam tinggi dan pusing', NULL, 'KODE KUNING (Mendesak)', '2026-06-22 18:52:37', 'Perawat', 'Selesai Ditangani'),
(6, 'RM-3263', 'lagi', 30, 0.0, 'saya ada cacar gitu ditangan saya', NULL, 'KODE KUNING (Mendesak)', '2026-06-22 18:55:55', 'Perawat', 'Selesai Ditangani'),
(7, 'RM-9496', 'lagi 2', 30, 0.0, 'saya cacar biasa', NULL, 'KODE HIJAU', '2026-06-22 18:56:58', 'Perawat', 'Selesai Ditangani'),
(8, 'RM-9578', 'lagi 2', 30, 0.0, 'saya cacar biasa', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-06-22 18:57:07', 'Perawat', 'Selesai Ditangani'),
(9, 'RM-1589', 'testing more', 20, 0.0, 'kepala saya pusing sekali, dan saya mual serta hampir tidak kuat berjalan lagi. TOLONG SAYA', NULL, 'KODE MERAH (Gawat Darurat)', '2026-06-22 19:15:34', 'Perawat', 'Selesai Ditangani'),
(10, 'RM-8223', 'dita lagi', 60, 29.0, 'dia pusing', NULL, 'KODE HIJAU', '2026-06-22 19:18:51', 'Perawat', 'Selesai Ditangani'),
(11, 'RM-6819', 'lagi lagi', 20, 25.0, 'pusing dan cacar ditangan', NULL, 'KODE HIJAU', '2026-06-22 19:27:43', 'Perawat', 'Selesai Ditangani'),
(12, 'RM-4025', 'fian', 10, 28.0, 'pusing, lemes, mata merah', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-06-22 20:28:38', 'Perawat', 'Selesai Ditangani'),
(13, 'RM-6103', 'fian lagi', 11, 0.0, 'pusing ringan', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-06-22 20:29:25', 'Perawat', 'Selesai Ditangani'),
(14, 'RM-4440', 'fian lagi 2', 11, 0.0, 'pusing banget, badan saya lemes ga kuat jalan lagi, dan semua badan saya sakit', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-06-22 20:30:16', 'Perawat', 'Selesai Ditangani'),
(15, 'RM-5662', 'fian lagi 3', 11, 0.0, 'pusing banget, badan saya lemes ga kuat jalan lagi, dan semua badan saya sakit hampir kayak mau pingsan', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-06-22 20:31:19', 'Perawat', 'Selesai Ditangani'),
(16, 'RM-5688', 'terakhir', 20, 0.0, 'saya sangat pusing kepala saya sakit sekali dan rasanya mau pingsan', NULL, 'KODE MERAH', '2026-06-22 20:48:34', 'Perawat', 'Selesai Ditangani'),
(17, 'RM-4163', 'lagi deh', 22, 40.0, 'badan panas dan ada ruam ditangan', NULL, 'KODE KUNING', '2026-06-22 20:52:45', 'Perawat', 'Selesai Ditangani'),
(18, 'RM-6312', 'baru', 23, 0.0, 'saya pusing dikit sih, trus kayak ada cacar gitu ditangan saya', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-06-24 12:16:21', 'Perawat', 'Selesai Ditangani'),
(19, 'RM-1975', 'baru 1', 24, 42.0, 'dia hampir ga sadarkan diri, susah untuk berjalan dan tangan kakinya udah ada cacar parah', NULL, 'KODE HIJAU', '2026-06-24 12:17:44', 'Perawat', 'Selesai Ditangani'),
(20, 'RM-8137', 'oktafian ivano', 19, 0.0, 'saya demam tinggi, badan panas, tubuh gatal gatal, pusing sekali kayak mau pingsan', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-06-24 12:36:47', 'Perawat', 'Selesai Ditangani'),
(21, 'RM-5172', 'test', 19, 0.0, 'saya sangat pusing badan saya sakit dan sudah tidak kuat bangun lagi', NULL, 'KODE MERAH (Gawat Darurat)', '2026-06-25 04:42:53', 'Perawat', 'Selesai Ditangani'),
(23, 'RM-9348', 'samson', 95, 32.0, 'demam, sakit kepala, mual, di tangan ada bintik bintik merah', NULL, 'KODE KUNING', '2026-06-25 05:01:19', 'Perawat', 'Selesai Ditangani'),
(24, 'RM-6479', 'ivann', 19, 0.0, 'saya pusing, mata saya merah dan mual muntah muntah terus', NULL, 'KODE MERAH (Gawat Darurat)', '2026-06-25 05:17:19', 'Perawat', 'Selesai Ditangani'),
(25, 'RM-1078', 'mulyadi', 30, 30.0, 'dia pusing, demam tinggi, muntah muntah', NULL, 'KODE KUNING (Mendesak)', '2026-06-25 05:54:18', 'Perawat', 'Selesai Ditangani'),
(26, 'RM-5238', 'dita', 18, 0.0, 'saya pusing, badan saya panas saya batuk pilek juga tolong yaa', NULL, 'KODE KUNING (Mendesak)', '2026-06-25 06:28:48', 'Perawat', 'Selesai Ditangani'),
(27, 'RM-1823', 'agus', 30, 30.0, 'pusing', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-06-25 06:33:48', 'Perawat', 'Selesai Ditangani'),
(28, 'RM-9635', 'neymar', 27, 40.0, 'mengeluh demam tinggi dan lemas, dan ruam parah diseluruh badan', NULL, 'KODE MERAH (Gawat Darurat)', '2026-07-10 00:51:52', 'Perawat', 'Selesai Ditangani'),
(29, 'RM-5096', 'messi', 35, 35.0, 'mengeluh pusing dan ada ruam dibagian tangan kiri', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-10 00:53:13', 'Perawat', 'Selesai Ditangani'),
(30, 'RM-6506', 'ronaldo', 27, 37.0, 'pusing sekali, ruam diseluruh tangan', NULL, 'KODE MERAH (Gawat Darurat)', '2026-07-10 00:54:19', 'Perawat', 'Selesai Ditangani'),
(31, 'RM-3550', 'mbappe', 27, 35.0, 'ruam diseluruh kaki dan sedikit susah untuk nafas', NULL, 'KODE KUNING (Mendesak)', '2026-07-10 01:33:06', 'Perawat', 'Riwayat Selesai'),
(32, 'RM-4595', 'garnacho', 28, 0.0, 'saya ada ruam ditangan sama leher, saya juga agak demam', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-10 01:47:18', 'Perawat', 'Selesai Ditangani'),
(33, 'RM-8744', 'dita', 20, 0.0, 'saya sakit kepala mual mual dan pusing', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-10 05:50:29', 'Perawat', 'Selesai Ditangani'),
(34, 'RM-3260', 'hiles', 20, 0.0, 'kaki ada ruam, dan mata saya merah\n', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-11 10:40:23', 'Perawat', 'Selesai Ditangani'),
(35, 'RM-6077', 'ujang', 24, 0.0, 'saya ada bintik bintik di tangan sampe leher', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-11 14:51:36', 'Perawat', 'Selesai Ditangani'),
(36, 'RM-3932', 'pildin', 45, 0.0, 'saya pusing, demam, dan ada cacar dileher sampai tangan saya\n', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-11 15:07:00', 'Perawat', 'Selesai Ditangani'),
(37, 'RM-1049', 'sukirman', 50, 0.0, 'saya demam tinggi, mata merah, cacar diseluruh tubuh', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-11 15:07:52', 'Perawat', 'Selesai Ditangani'),
(38, 'RM-1661', 'resma', 55, 0.0, 'pusing, demam, cacar diseluruh tubuh\n', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-11 15:15:31', 'Perawat', 'Selesai Ditangani'),
(39, 'RM-3966', 'ita', 29, 0.0, 'tangan cacar, demam, agak pusing', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-11 15:18:21', 'Perawat', 'Selesai Ditangani'),
(40, 'RM-4525', 'anas', 17, 0.0, 'pusing, demam, cacar ditangan', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-11 15:28:30', 'Perawat', 'Selesai Ditangani'),
(41, 'RM-2202', 'aim', 17, 0.0, 'demam tinggi, cacar diseluruh badan dan matanya merah', NULL, 'KODE HIJAU (Tidak Mendesak)', '2026-07-11 15:29:23', 'Perawat', 'Selesai Ditangani'),
(42, 'RM-2093', 'pandu', 20, 0.0, 'demam, mata merah, cacar dileher', NULL, 'KODE HIJAU (Tidak Mendesak)\nAnalisis: Gejala pasien ini meliputi demam dan mata merah, yang menunjukkan adanya infeksi atau radang pada tubuh. Namun, hanya satu titik merah pada cacar di leher, yang tidak menunjukkan gejala yang lebih parah. Tetapi karena pasien juga mengalami demam, perlu dipertimbangkan kemungkinan gejala ini terus berlanjut.', '2026-07-11 15:39:21', 'Perawat', 'Selesai Ditangani'),
(43, 'RM-7701', 'dafa', 20, 0.0, 'cacar diseluruh tubuh, demam tinggi, pusing', NULL, 'KODE KUNING (Darurat & Butuh Pantauan)\nAnalisis: Gejala demam tinggi dan pusing dapat menunjukkan adanya infeksi yang signifikan, tetapi tidak secara langsung berarti kondisi tersebut bahaya, namun perlu penanganan. Namun, perlu diperhatikan bahwa cacar pada seluruh tubuh dapat menimbulkan risiko infeksi kulit yang lebih serius dan berpotensi menyebabkan komplikasi jika tidak dirawat dengan baik. Oleh karena itu, pasien perlu penanganan yang tepat dan perawatan yang lebih lanjut.', '2026-07-11 15:39:59', 'Perawat', 'Selesai Ditangani'),
(44, 'RM-1881', 'jewish', 25, 0.0, 'cacar diseluruh tubuh, mata merah, demam tinggi', NULL, 'KODE HIJAU (Tidak Mendesak)\nAnalisis: Kondisi tersebut dapat menimbulkan gejala infeksi ringan hingga sedang yang tidak menimbulkan kekhawatiran besar, tetapi demam tinggi dapat menjadi peringatan bahwa kondisi ini memerlukan perawatan untuk mencegah komplikasi.', '2026-07-11 15:40:53', 'Perawat', 'Riwayat Selesai'),
(45, 'RM-6034', 'yosia', 20, 0.0, 'pusing sekali, demam tinggi, cacar diseluruh tubuh', NULL, 'KODE KUNING (Darurat & Butuh Pantauan)\nAnalisis: Walaupun pasien menyebutkan gejala ringan seperti pusing, namun kombinasi dengan demam tinggi dan cacar diseluruh tubuh menunjukkan adanya kondisi yang lebih serius. Cacar dapat menyebabkan gangguan sistem kekebalan tubuh dan meningkatkan risiko komplikasi lain seperti infeksi atau demam berdarah.', '2026-07-11 15:41:57', 'Perawat', 'Riwayat Selesai'),
(46, 'RM-8914', 'haland', 27, 40.0, 'demam tinggi, sesak nafas, mata merah', NULL, 'KODE KUNING (Menunggu AI)', '2026-07-12 11:00:21', 'Perawat', 'Perlu Askep'),
(47, 'RM-4617', 'erling', 27, 45.0, 'demam tinggi, mata merah, sesak nafas, ruam diseluruh tubuh', NULL, 'KODE MERAH - Pasien ini mengalami demam tinggi yang sangat ekstrem (45.0 C), sesak napas, dan ruam yang mungkin menandakan infeksi sistemik yang mengancam nyawa, sehingga memerlukan tindakan instan. [STATUS: MERAH]', '2026-07-12 11:05:17', 'Perawat', 'Riwayat Selesai'),
(48, 'RM-2815', 'dita', 19, 0.0, 'demam ada bercak bercak di tangan', NULL, 'KODE KUNING (Darurat & Butuh Pantauan)\nAnalisis: Pasien dengan demam disertai bercak-bercak di tangan dapat menandakan adanya infeksi sistemik, seperti penyakit anjlok atau kolangitis. Bercak-bercak yang muncul dapat berarti adanya peradangan yang lebih serius di dalam tubuh.', '2026-07-12 14:30:11', 'Perawat', 'Riwayat Selesai'),
(49, 'RM-4778', 'lany', 25, 34.0, 'demam, sakit kepala, sesak napas, muntah muntah', NULL, 'STATUS: MERAH\nSuhu pasien terlalu rendah (normal adalah 36,5-37,5 C) sehingga menimbulkan kegawatan dan potensi komplikasi. Keluhannya yang beragam, seperti demam, sakit kepala, sesak napas, dan muntah muntah, membuat kami harus menilai kondisinya kritis.', '2026-07-12 14:36:14', 'Perawat', 'Riwayat Selesai'),
(50, 'RM-2304', ' vano', 10, 33.0, 'demam, sakit kepala, susah makan, muntah muntah', NULL, 'KODE HIJAU - Suhu badan pasien masih normal (di atas 36.5 C), gejala demam mungkin merupakan gejala yang masih ringan. Namun perlu diwaspadai karena gejala lain seperti sakit kepala, susah makan, dan muntah muntah, sehingga perlu dipantau dan diawasi.\n\nNamun perlu diingatkan bahwa untuk anak kecil dengan gejala demam, suhu badan yang normal dapat bervariasi, namun pada umumnya di bawah 38,5 C disebut masih dalam kisaran normal, meskipun demikian perlu diawasi dan dilakukan pengecekan lebih lanjut karena perluasan gejala yang mungkin berpotensi menjadi berlebihan dan berbahaya.', '2026-07-12 14:50:56', 'Perawat', 'Riwayat Selesai'),
(51, 'RM-9231', 'coba coba', 20, 0.0, 'saya demam tinggi dan mata saya merah', NULL, 'KODE KUNING (Darurat & Butuh Pantauan)\nAnalisis: Keluhan yang sering terjadi, tetapi perlu diperhatikan beberapa hal lagi. Saya melihat Anda memiliki demam yang tinggi, namun Anda tidak menyebutkan gejala lain terkait infeksi seperti batuk atau pilek. Jika demam Anda disertai gejala lain seperti sakit tenggorokan, hidung berair, atau nyeri pada area mata seperti konjungtivitis, saya mungkin akan mengasosiasikan gejala ini dengan infeksi virus. Namun, karena Anda hanya menyebutkan demam tinggi dan mata merah, saya harus mempertimbangkan kemungkinan infeksi bakteri, seperti sinusitis atau blefaritis.', '2026-07-15 11:09:16', 'Perawat', 'Riwayat Selesai'),
(52, 'RM-8415', 'dea', 18, 0.0, 'pusing,batuk,flu,sakit perut ', NULL, 'KODE HIJAU (Tidak Mendesak)\nAnalisis: Pasien mengalami gejala umum yang umumnya tidak berbahaya, namun perlu diperhatikan karena gejala \"pusing\" intensitasnya tidak diberikan penjelasan. Selain itu, batuk, flu, dan sakit perut dapat menjadi gejala yang lebih parah jika tidak diatasi dengan baik.', '2026-07-15 12:51:02', 'Perawat', 'Riwayat Selesai'),
(53, 'RM-9936', 'dea', 18, 36.0, 'pusing', NULL, '[STATUS: HIJAU] \nPasien usia 18 tahun dengan suhu badan normal dan gejala pusing, namun tidak menunjukkan tanda-tanda ke seriousness gejala pusing, sehingga statusnya dikelasifikasikan sebagai ringan atau tidak gawat.', '2026-07-15 12:55:56', 'Perawat', 'Perlu Askep'),
(54, 'RM-5314', 'bunga ', 23, 0.0, 'lemas,pusing,mual,batuk,flu,demam ', NULL, 'KODE KUNING (Darurat & Butuh Pantauan)\nAnalisis: Gejala yang disebutkan oleh pasien, seperti demam, batuk, dan flu, menunjukkan tanda-tanda infeksi pernapasan akut. Namun, adanya gejala seperti lemas, pusing, dan mual menunjukkan bahwa kondisi pasien lebih serius dari biasanya.', '2026-07-17 06:23:39', 'Perawat', 'Riwayat Selesai'),
(55, 'RM-1409', 'ina', 17, 0.0, 'batuk batuk', NULL, 'KODE HIJAU (Tidak Mendesak)\nAnalisis: Gejala batuk biasa tidak selalu menunjukkan kondisi yang berat, namun jika pasien melaporkan intensitas batuk yang parah, disertai dengan muntahnya darah atau tekanan darah yang turun tidak terkendali, maka diperlukan penanganan lebih serius. \n\nNamun, jika hanya gejala batuk batuk saja dan intensitasnya tidak terlalu parah, maka kondisi pasien masih di bawah kategori ringan.', '2026-07-17 06:28:00', 'Perawat', 'Perlu Askep'),
(56, 'RM-2415', 'ayu', 19, 37.0, 'pusing', NULL, 'STATUS: HIJAU. Analisis singkat: Suhu badan pasien normal menunjukkan tidak adanya infeksi akut dan keluhan pusing tidak dikategorikan sebagai gejala darurat.', '2026-07-17 06:30:00', 'Perawat', 'Perlu Askep'),
(57, 'RM-3362', 'dita', 20, 0.0, 'sakit kepala', NULL, 'KODE KUNING (Darurat & Butuh Pantauan)\nAnalisis: Pasien mengklaim mengalami sakit kepala, tetapi intensitasnya sangat parah dan telah berlangsung selama 3 hari dengan disertai mual dan muntah berulang.', '2026-07-17 06:37:13', 'Perawat', 'Menunggu Antrean'),
(58, 'RM-5892', 'data', 20, 0.0, 'saya sakit kepala', NULL, 'KODE HIJAU (Tidak Mendesak)\nAnalisis: Gejala sakit kepala dapat memiliki variasi intensitas. Namun, jika pasien menggambarkan sakit kepala sebagai ekstrem, tiba-tiba, atau berkelanjutan selama beberapa hari, serta tidak ada gejala lain, maka tidak terlalu berbahaya. Meskipun demikian, saya perlu mempertimbangkan kemungkinan-kemungkinan lain.\n\nAnalisis: Sakit kepala yang intens dan berkelanjutan dapat menunjukkan gangguan migrain, sakit kepala tension, atau bahkan kondisi medis yang lebih serius seperti stroke atau infark.', '2026-07-17 06:56:25', 'Perawat', 'Menunggu Antrean'),
(59, 'RM-4540', 'nana', 12, 40.0, 'mual mual', NULL, 'KODE KUNING - Anak 12 tahun dengan demam 40.0 C membutuhkan pertolongan segera untuk menjaga kesadaran dan mencegah komplikasi, meskipun demam sangat tinggi, masih perlu diawasi dengan lebih dekat untuk menilai kemungkinan perjalanan penyakit.', '2026-07-17 07:09:34', 'Perawat', 'Menunggu Antrean');

-- --------------------------------------------------------

--
-- Table structure for table `perawat`
--

CREATE TABLE `perawat` (
  `id` int NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nama_lengkap` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `perawat`
--

INSERT INTO `perawat` (`id`, `username`, `password`, `nama_lengkap`) VALUES
(1, 'dita', 'dita123', 'Dwita Lestari Lamaligi'),
(2, 'vano', 'vano123', 'Oktafian Ivano');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_rekam_medis`
--

CREATE TABLE `riwayat_rekam_medis` (
  `id_riwayat` int NOT NULL,
  `id_pasien` int NOT NULL,
  `nama_perawat` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `isi_rekam_medis` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `waktu_diubah` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `riwayat_rekam_medis`
--

INSERT INTO `riwayat_rekam_medis` (`id_riwayat`, `id_pasien`, `nama_perawat`, `isi_rekam_medis`, `waktu_diubah`) VALUES
(1, 9, 'Dwita Lestari Lamaligi', 'DIAGNOSIS (SDKI): Diare b.d Kekurangan Cairan\nINTERVENSI (SIKI): Manajemen Diare / Pemantauan Cairan\nTINDAKAN OTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI MANUAl: taikkk', '2026-07-06 16:11:12'),
(2, 26, 'Oktafian Ivano', 'Status pelayanan diperbarui menjadi \'Selesai Ditangani\'. Catatan Triase Akhir: KODE KUNING (Mendesak)', '2026-07-10 00:40:34'),
(3, 24, 'Oktafian Ivano', 'Status pelayanan diperbarui menjadi \'Selesai Ditangani\'. Catatan Triase Akhir: KODE MERAH (Gawat Darurat)', '2026-07-10 00:40:42'),
(4, 23, 'Oktafian Ivano', 'Status pelayanan diperbarui menjadi \'Selesai Ditangani\'. Catatan Triase Akhir: KODE KUNING', '2026-07-10 00:40:48'),
(5, 28, 'Oktafian Ivano', 'Status pelayanan diperbarui menjadi \'Sedang Ditangani\'. Catatan Triase Akhir: KODE MERAH (Gawat Darurat)', '2026-07-10 00:52:27'),
(6, 30, 'Oktafian Ivano', 'Status pelayanan diperbarui menjadi \'Selesai Ditangani\'. Catatan Triase Akhir: KODE MERAH (Gawat Darurat)', '2026-07-10 00:54:29'),
(7, 30, 'Oktafian Ivano', 'SDKI: Bersihan Jalan Napas Tidak Efektif b.d penumpukan sekret\nSIKI: Manajemen Jalan Napas\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: dslkajfnalsdjfnbl;', '2026-07-10 01:27:33'),
(8, 45, 'Oktafian Ivano', 'Status pelayanan diperbarui menjadi \'Sedang Ditangani\'. Catatan Triase Akhir: KODE KUNING (Darurat & Butuh Pantauan)\nAnalisis: Walaupun pasien menyebutkan gejala ringan seperti pusing, namun kombinasi dengan demam tinggi dan cacar diseluruh tubuh menunjukkan adanya kondisi yang lebih serius. Cacar dapat menyebabkan gangguan sistem kekebalan tubuh dan meningkatkan risiko komplikasi lain seperti infeksi atau demam berdarah.', '2026-07-12 10:27:30'),
(9, 42, 'Oktafian Ivano', 'SDKI: Hipertermia b.d proses infeksi virus campak\nSIKI: Manajemen Hipertermia / Infeksi\nOTEK: \nEVALUASI: alsdkjfalskjdfbnlaksjdf', '2026-07-12 14:00:01'),
(10, 4, 'Oktafian Ivano', 'SDKI: Hipertermia b.d proses infeksi virus campak\nSIKI: Manajemen Hipertermia / Infeksi\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: sdfsdfsd', '2026-07-12 14:12:38'),
(11, 47, 'Oktafian Ivano', 'SDKI: Hipertermia b.d proses infeksi virus campak\nSIKI: Manajemen Hipertermia / Infeksi\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: testting dbdbdbdbb', '2026-07-15 08:37:46'),
(12, 48, 'Oktafian Ivano', 'SDKI: Gangguan Integritas Kulit/Jaringan b.d ruam kemerahan\nSIKI: Perawatan Integritas Kulit\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: kokokkiki', '2026-07-15 08:47:26'),
(13, 50, 'Oktafian Ivano', 'SDKI: Hipertermia b.d proses infeksi virus campak\nSIKI: Manajemen Hipertermia / Infeksi\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: no eval\n', '2026-07-15 09:12:51'),
(14, 31, 'Oktafian Ivano', 'SDKI: Gangguan Integritas Kulit/Jaringan b.d ruam kemerahan\nSIKI: Perawatan Integritas Kulit\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: sdfsdgsdafasokok', '2026-07-15 09:19:33'),
(15, 45, 'Oktafian Ivano', 'SDKI: Hipertermia b.d proses infeksi virus campak\nSIKI: Manajemen Hipertermia / Infeksi\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: dsfsdfsdfs', '2026-07-15 09:24:06'),
(16, 44, 'Dwita Lestari Lamaligi', 'SDKI: Gangguan Integritas Kulit/Jaringan b.d ruam kemerahan\nSIKI: Perawatan Integritas Kulit\nOTEK: Observasi, Terapeutik, Kolaborasi\nEVALUASI: demam pasien sudah menurun', '2026-07-15 11:19:57'),
(17, 52, 'Dwita Lestari Lamaligi', 'SDKI: Hipertermia b.d proses infeksi virus campak\nSIKI: Manajemen Hipertermia / Infeksi\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: udah sesuai asuhan keperawatan', '2026-07-15 13:02:14'),
(18, 54, 'Dwita Lestari Lamaligi', 'SDKI: Hipertermia b.d proses infeksi virus campak\nSIKI: Manajemen Hipertermia / Infeksi\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: sudah sesuai asuhan', '2026-07-17 06:27:01'),
(19, 49, 'Dwita Lestari Lamaligi', 'SDKI: Bersihan Jalan Napas Tidak Efektif b.d penumpukan sekret\nSIKI: Manajemen Jalan Napas\nOTEK: Observasi, Terapeutik, Edukasi\nEVALUASI: fswadf', '2026-07-18 12:57:49'),
(20, 51, 'Dwita Lestari Lamaligi', 'SDKI: Bersihan Jalan Napas Tidak Efektif b.d penumpukan sekret\nSIKI: Manajemen Jalan Napas\nOTEK: Observasi, Terapeutik, Edukasi, Kolaborasi\nEVALUASI: dfasdf', '2026-07-18 12:58:06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `audit_log_perawat`
--
ALTER TABLE `audit_log_perawat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `no_rm` (`no_rm`);

--
-- Indexes for table `perawat`
--
ALTER TABLE `perawat`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `riwayat_rekam_medis`
--
ALTER TABLE `riwayat_rekam_medis`
  ADD PRIMARY KEY (`id_riwayat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `audit_log_perawat`
--
ALTER TABLE `audit_log_perawat`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT for table `pasien`
--
ALTER TABLE `pasien`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `perawat`
--
ALTER TABLE `perawat`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `riwayat_rekam_medis`
--
ALTER TABLE `riwayat_rekam_medis`
  MODIFY `id_riwayat` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
