import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class TestInstruction() {

    @Test
    fun InstructionDataLengthValidation() {
        Assertions.assertEquals(2, Instruction(":020000000528D1").getDataLength())
        Assertions.assertEquals(8, Instruction(":080008001E2826202D200F30D8").getDataLength())
        Assertions.assertEquals(16, Instruction(":1000300086141C2886100614092808009000030E58").getDataLength())
        Assertions.assertEquals(0, Instruction(":00000001FF").getDataLength())
    }

    @Test
    fun InstructionTypeValidation() {
        Assertions.assertEquals(4, Instruction(":020000040000FA").getType())
        Assertions.assertEquals(0, Instruction(":1000300086141C2886100614092808009000030E58").getType())
        Assertions.assertEquals(1, Instruction(":00000001FF").getType())
    }

    @Test
    fun InstructionAddressValidation() {
        Assertions.assertEquals(0, Instruction(":020000040000FA").getAddress())
        Assertions.assertEquals(16398, Instruction(":02400E00F23F7F").getAddress())
        Assertions.assertEquals(32, Instruction(":10002000920A851811281208031D17281A2806108D").getAddress())
    }

    @Test
    fun InstructionDataIsExpectedData() {

        Assertions.assertEquals(listOf<UByte>(0.toUByte(), 0.toUByte()), Instruction(":020000040000FA").getData())
        Assertions.assertEquals(listOf<UByte>(242.toUByte(), 63.toUByte()), Instruction(":02400E00F23F7F").getData())
        Assertions.assertEquals(
            listOf<UByte>(
                146.toUByte(),
                10.toUByte(),
                133.toUByte(),
                24.toUByte(),
                17.toUByte(),
                40.toUByte(),
                18.toUByte(),
                8.toUByte(),
                3.toUByte(),
                29.toUByte(),
                23.toUByte(),
                40.toUByte(),
                26.toUByte(),
                40.toUByte(),
                6.toUByte(),
                16.toUByte()
            ),
            Instruction(":10002000920A851811281208031D17281A2806108D").getData()
        )
    }

    @Test
    fun NoExceptionOnCorrectChecksum() {
        assertDoesNotThrow()
        {
            Instruction(":020000040000FA")
            Instruction(":1000300086141C2886100614092808009000030E58")
        }
    }

    @Test
    fun ExceptionOnCreationOnInvalidChecksum() {
        assertThrows(Instruction.InvalidChecksumException::class.java) {
            Instruction(":02000004000057")
        }
        assertThrows(Instruction.InvalidChecksumException::class.java) {
            Instruction(":1000300086141C2886100614092808009000030EAB")
        }
    }
}

/*
:020000040000FA
:020000000528D1
:080008001E2826202D200F30D8
:100010009200051C0E28920305180C28851C132835
:10002000920A851811281208031D17281A2806108D
:1000300086141C2886100614092808009000030E58
:100040009100110E8300900E100E090083160330EC
:0C005000850000308600831208000800C4
:02400E00F23F7F
:00000001FF
*/