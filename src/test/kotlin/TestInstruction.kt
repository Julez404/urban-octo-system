import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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

        Assertions.assertEquals(listOf<Short>(0, 0), Instruction(":020000040000FA").getData())
        Assertions.assertEquals(listOf<Short>(242, 63), Instruction(":02400E00F23F7F").getData())
        Assertions.assertEquals(
            listOf<Short>(146, 10, 133, 24, 17, 40, 18, 8, 3, 29, 23, 40, 26, 40, 6, 16),
            Instruction(":10002000920A851811281208031D17281A2806108D").getData()
        )
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