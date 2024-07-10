import java.util.Scanner

class Controller {
    private val scanner = Scanner(System.`in`)
    private val tokoOnlineController = TokoOnlineController(scanner)

    fun showMenu() {
        tokoOnlineController.tampilkanDaftarBarang()
        tokoOnlineController.prosesPembelian()
    }
}
