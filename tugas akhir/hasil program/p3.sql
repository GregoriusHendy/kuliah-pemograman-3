-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 20 Des 2012 pada 14.15
-- Versi Server: 5.5.27
-- Versi PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `p3`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama_admin` varchar(50) DEFAULT NULL,
  `alamat` text,
  `telpon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`, `nama_admin`, `alamat`, `telpon`) VALUES
(1, 'sidratul', 'sidratul', 'muhammad sidratul muntaha', 'jln univ pancasila no 4', '08999904741');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis`
--

CREATE TABLE IF NOT EXISTS `jenis` (
  `id_jenis` int(10) NOT NULL AUTO_INCREMENT,
  `nama_jenis` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_jenis`),
  UNIQUE KEY `nama_jenis` (`nama_jenis`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data untuk tabel `jenis`
--

INSERT INTO `jenis` (`id_jenis`, `nama_jenis`) VALUES
(1, 'makanan'),
(2, 'minuman'),
(3, 'sabun cuci');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemasukan`
--

CREATE TABLE IF NOT EXISTS `pemasukan` (
  `id_pemasukan` int(11) NOT NULL AUTO_INCREMENT,
  `id_produk` int(11) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `jam` time DEFAULT NULL,
  PRIMARY KEY (`id_pemasukan`),
  KEY `id_produk` (`id_produk`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE IF NOT EXISTS `pengeluaran` (
  `id_pengeluaran` int(11) NOT NULL AUTO_INCREMENT,
  `id_produk` int(11) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `jam` time DEFAULT NULL,
  PRIMARY KEY (`id_pengeluaran`),
  KEY `id_produk` (`id_produk`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data untuk tabel `pengeluaran`
--

INSERT INTO `pengeluaran` (`id_pengeluaran`, `id_produk`, `jumlah`, `tanggal`, `jam`) VALUES
(1, 57, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE IF NOT EXISTS `produk` (
  `id_produk` int(11) NOT NULL AUTO_INCREMENT,
  `nama_produk` varchar(50) DEFAULT NULL,
  `id_jenis` int(10) DEFAULT NULL,
  `harga` int(10) DEFAULT NULL,
  `id_suplier` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_produk`),
  KEY `id_jenis` (`id_jenis`),
  KEY `id_suplier` (`id_suplier`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=64 ;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`id_produk`, `nama_produk`, `id_jenis`, `harga`, `id_suplier`) VALUES
(56, 'coki-coki', 1, 5000, 1),
(57, 'indomie soto koya', 1, 10000, 1),
(58, 'coki-coki', 1, 5000, 2),
(59, 'wings sabun colek', 3, 20000, 3),
(60, 'fanta 1 lt ', 2, 50000, 4),
(61, 'super pell kecil', 3, 10000, 5),
(62, 'cola cola', 2, 50000, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `stok_produk`
--

CREATE TABLE IF NOT EXISTS `stok_produk` (
  `id_produk` int(11) NOT NULL,
  `stok` int(10) NOT NULL,
  PRIMARY KEY (`id_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `stok_produk`
--

INSERT INTO `stok_produk` (`id_produk`, `stok`) VALUES
(57, 9),
(58, 5),
(59, 10),
(60, 20),
(61, 10),
(62, 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `suplier`
--

CREATE TABLE IF NOT EXISTS `suplier` (
  `id_suplier` int(10) NOT NULL AUTO_INCREMENT,
  `nama_suplier` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telpon` varchar(20) DEFAULT NULL,
  `kota` varchar(30) DEFAULT NULL,
  `alamat` text,
  PRIMARY KEY (`id_suplier`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `suplier`
--

INSERT INTO `suplier` (`id_suplier`, `nama_suplier`, `email`, `telpon`, `kota`, `alamat`) VALUES
(1, 'indofood', 'pemasaran@indomie.co.id', '903341', 'jakarta', 'jalamn ra kartini'),
(2, 'mayora', 'pemasaran@mayora.co.id', '021-123', 'bekasi', 'jalan ibu kota'),
(3, 'wings', 'pemasaran@wings.co.id', '021-43434', 'jakarta', 'jalan sejahtera'),
(4, 'cola-cola compay', 'pemasaran@coca.co.id', 'bekasi', '', ''),
(5, 'uniliver', 'pemasaran@uniliver.co.id', '021-52995299', 'jakarta', ''),
(6, 'sid corp', 'sid.corp@sidc.co.id', 'jakarta', '021-1111', 'jalan merdeka');

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pemasukan`
--
ALTER TABLE `pemasukan`
  ADD CONSTRAINT `pemasukan_ibfk_1` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id_produk`);

--
-- Ketidakleluasaan untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id_produk`);

--
-- Ketidakleluasaan untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `produk_ibfk_1` FOREIGN KEY (`id_jenis`) REFERENCES `jenis` (`id_jenis`),
  ADD CONSTRAINT `produk_ibfk_2` FOREIGN KEY (`id_suplier`) REFERENCES `suplier` (`id_suplier`);

--
-- Ketidakleluasaan untuk tabel `stok_produk`
--
ALTER TABLE `stok_produk`
  ADD CONSTRAINT `stok_produk_ibfk_1` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id_produk`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
