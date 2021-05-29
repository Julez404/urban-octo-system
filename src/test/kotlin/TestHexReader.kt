import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class TestHexReader {
    var dummyHexReader: HexReader
    var emptyHexReader: HexReader

    init {
        val path = "src/test/resources"
        val file = File(path)
        val absolutePath = file.absolutePath
        val testFile = "/testHexReader_hexDummy.hex"
        dummyHexReader = HexReader(absolutePath + testFile)
        emptyHexReader = HexReader(absolutePath + testFile)
        println(absolutePath)
    }

    @Test
    fun readHexFileToAsciiArray() {
        var list = dummyHexReader.getLineArray()
        assertEquals(":020000040000FA", list[0])
        assertEquals(":020000000528D1", list[1])
        assertEquals(":080008001E2826202D200F30D8", list[2])
        assertEquals(":100010009200051C0E28920305180C28851C132835", list[3])
        assertEquals(":10002000920A851811281208031D17281A2806108D", list[4])
        assertEquals(":1000300086141C2886100614092808009000030E58", list[5])
        assertEquals(":100040009100110E8300900E100E090083160330EC", list[6])
        assertEquals(":0C005000850000308600831208000800C4", list[7])
        assertEquals(":02400E00F23F7F", list[8])
        assertEquals(":00000001FF", list[9])
    }
}