import java.util.Scanner

class TokoOnlineController(private val scanner: Scanner) {
    private val daftarBarang = DaftarBarang.daftarBarang

    fun tampilkanDaftarBarang() {
        println("\t\tDaftar Barang Toko Online")
        println("\t\t_________________________")
        println("==============================================================")
        println(String.format("%-20s %30s", "Nama Barang", "Harga"))
        println("==============================================================")

        for (i in daftarBarang.indices) {
            println("[${i + 1}] ${daftarBarang[i].nama} ${" ".repeat(40 - daftarBarang[i].nama.length)} Rp. ${daftarBarang[i].harga}")
        }

        println("==============================================================")
    }

    fun prosesPembelian() {
        val pilihBarang = mutableListOf<Int>()
        var jumlahBarang = 0
        var totalPembayaran = 0

        do {
            print("\nBerapa Barang Yang Ingin Dibeli : ")
            val barangDibeli = scanner.nextInt()

            for (i in 0 until barangDibeli) {
                do {
                    print("\nPilihan Barang ke-${i + 1} : ")
                    val pilihan = scanner.nextInt()

                    if (pilihan in 1..daftarBarang.size) {
                        pilihBarang.add(pilihan)
                        totalPembayaran += daftarBarang[pilihan - 1].harga
                        println("Barang yang dipilih : ${daftarBarang[pilihan - 1].nama} Rp. ${daftarBarang[pilihan - 1].harga}")
                        jumlahBarang++
                        break
                    } else {
                        println("Pilihan barang tidak valid.")
                    }
                } while (true)
            }

            print("\nApakah Anda Masih Ingin Membeli barang [y/n] = ")
            val yesOrNO = scanner.next()
            println("==============================================================")
        } while (yesOrNO.equals("y", ignoreCase = true))

        // biaya pengiriman
        val jasaPengiriman = Pengiriman()
        jasaPengiriman.tampilkanOpsiPengiriman()
        var jp: Int? = null
        var pilihanPengiriman: Int
        do {
            print("\nPilih Jasa Pengiriman (1-${Pengiriman.JenisPengiriman.values().size}) : ")
            pilihanPengiriman = scanner.nextInt()
            jp = jasaPengiriman.pilihPengiriman(pilihanPengiriman)
            if (jp == null) {
                println("Jasa pengirim yang Anda pilih tidak tersedia.")
            }
        } while (jp == null)

        // Input data pembeli
        val noPesanan = "19082214010AKGB"
        println("===============================================")
        println("         Data Penerima Barang Pemesanan        ")
        println("===============================================")

        // Clear the buffer
        scanner.nextLine()

        print("Nama Pelanggan     = ")
        val namaPelanggan = scanner.nextLine()
        print("Alamat Pelanggan   = ")
        val alamatPelanggan = scanner.nextLine()
        print("Telphone Pelanggan = ")
        val notlpPelanggan = scanner.nextLine()
        println("_______________________________________________")
        println("Nomer Pesanan      = $noPesanan")

        println("\n\n")
        println("==============================================================")
        println("                        Rincian Pesanan                       ")
        println("==============================================================")
        for (i in 0 until jumlahBarang) {
            val indexBarang = pilihBarang[i] - 1
            println("${daftarBarang[indexBarang].nama} ${" ".repeat(40 - daftarBarang[indexBarang].nama.length)} Rp. ${daftarBarang[indexBarang].harga}")
        }
        println("\n==============================================================")
        println("\nJumlah Barang                    = $jumlahBarang")
        println("\nTotal Harga [$jumlahBarang] barang           = Rp.$totalPembayaran")
        println("\nBiaya Jasa Pengiriman-${Pengiriman.JenisPengiriman.values()[pilihanPengiriman - 1].name} = Rp. $jp")

        // hitung diskon
        val diskonPembelian = Diskon()
        val dp = diskonPembelian.hitungDiskon(totalPembayaran)
        println("\nDiskon Pembelian                 =  $dp%")
        println("_______________________________________________________________")

        // Proses pembayaran dan menghitung subtotal
        val pembayaran = Pembayaran(scanner)
        val uangDibayar = pembayaran.prosesPembayaran(totalPembayaran, jp!!, dp)
        val subtotal = pembayaran.hitung(totalPembayaran, jp, dp)
        val kembalian = uangDibayar - subtotal

        // Cetak struk
        val strukPembelian = StrukPembelian()
        strukPembelian.cetakStruk(
            namaPelanggan,
            alamatPelanggan,
            notlpPelanggan,
            pilihBarang,
            daftarBarang,
            jumlahBarang,
            totalPembayaran,
            jp,
            dp,
            subtotal,
            uangDibayar,
            kembalian
        )
    }
}
