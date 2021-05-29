import java.io.File

class HexReader(filePath: String) {
    private var filePath: String = filePath

    fun getLineArray(): List<String> {
        return File(filePath).readLines()
    }
}