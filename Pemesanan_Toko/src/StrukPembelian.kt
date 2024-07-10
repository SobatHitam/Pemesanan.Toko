class StrukPembelian {
    fun cetakStruk(
        namaPelanggan: String,
        alamatPelanggan: String,
        notlpPelanggan: String,
        pilihBarang: List<Int>,
        daftarBarang: Array<Barang>,
        jumlahBarang: Int,
        totalPembayaran: Int,
        jp: Int,
        dp: Int,
        subtotal: Int,
        uangDibayar: Int,
        kembalian: Int
    ) {
        println("\n\n")
        println("==============================================================")
        println("                        STRUK PEMBELIAN                       ")
        println("==============================================================")
        println("Nama Pelanggan     : $namaPelanggan")
        println("Alamat Pelanggan   : $alamatPelanggan")
        println("Telepon Pelanggan  : $notlpPelanggan")
        println("--------------------------------------------------------------")

        for (i in 0 until jumlahBarang) {
            val indexBarang = pilihBarang[i] - 1
            println("${daftarBarang[indexBarang].nama} ${" ".repeat(40 - daftarBarang[indexBarang].nama.length)} Rp. ${daftarBarang[indexBarang].harga}")
        }
        println("--------------------------------------------------------------")
        println("Jumlah Barang      : $jumlahBarang")
        println("Total Harga        : Rp. $totalPembayaran")
        println("Biaya Pengiriman   : Rp. $jp")
        println("Diskon             : $dp%")
        println("Subtotal           : Rp. $subtotal")
        println("Bayar              : Rp. $uangDibayar")
        println("Kembali            : Rp. $kembalian")
        println("==============================================================")
        println("\n\t\tTerima Kasih Telah Berbelanja (≧▽≦)")
    }
}
