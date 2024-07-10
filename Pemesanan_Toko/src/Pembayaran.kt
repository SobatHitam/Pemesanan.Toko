import java.util.Scanner

class Pembayaran(private val scanner: Scanner) {
    fun prosesPembayaran(totalPembayaran: Int, jp: Int, dp: Int): Int {
        val subtotal = hitung(totalPembayaran, jp, dp)
        println("\nSubtotal Pembayaran = Rp. $subtotal")
        var uangBayar: Int

        do {
            print("\nMasukkan jumlah uang yang dibayarkan: Rp.")
            uangBayar = scanner.nextInt()

            if (uangBayar < subtotal) {
                println("Jumlah uang yang dibayarkan tidak cukup. Silakan masukkan jumlah yang sesuai.")
            } else {
                val kembalian = uangBayar - subtotal
                println("Uang yang dibayar: Rp. $uangBayar")
                println("Kembali: Rp. $kembalian")
            }
        } while (uangBayar < subtotal)

        return uangBayar
    }

    fun hitung(totalPembayaran: Int, jp: Int, dp: Int): Int {
        return ((totalPembayaran + jp) * (1 - dp / 100.0)).toInt()
    }
}
