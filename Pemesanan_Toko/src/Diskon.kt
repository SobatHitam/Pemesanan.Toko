class Diskon {
    private val diskonTiers = listOf(
        200000 to 20,  // Diskon 20% untuk total pembelian >= 200000
        150000 to 15,  // Diskon 15% untuk total pembelian >= 150000
        100000 to 10,  // Diskon 10% untuk total pembelian >= 100000
        50000 to 5,   // Diskon 5% untuk total pembelian >= 50000
        20000 to 3    // Diskon 3% untuk total pembelian >= 20000
    )

    fun hitungDiskon(totalPembayaran: Int): Int {
        for ((batasDiskon, diskon) in diskonTiers) {
            if (totalPembayaran >= batasDiskon) {
                return diskon
            }
        }
        return 0
    }
}
