class Pengiriman {
    enum class JenisPengiriman(val biaya: Int) {
        JNE(18000),
        SiCepat(15000),
        Anteraja(10000)
    }

    fun tampilkanOpsiPengiriman() {
        println("\nPilih Jasa Pengiriman:")
        for (jenis in JenisPengiriman.values()) {
            println("${jenis.ordinal + 1}. ${jenis.name} - Rp. ${jenis.biaya}")
        }
    }

    fun pilihPengiriman(pilihan: Int): Int {
        return JenisPengiriman.values()[pilihan - 1].biaya
    }
}
