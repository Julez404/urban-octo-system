class Instruction(initString: String) {
    val instructionString: String

    init {
        println("Create Instruction with string: " + initString)
        instructionString = initString
        if (!checksumIsValid())
            throw InvalidChecksumException()
    }

    private fun checksumIsValid(): Boolean {
        if (getChecksum() == calculateChecksum())
            return true
        return false
    }

    private fun calculateChecksum(): UByte {
        var sum: UByte =
            (getSumOfAddress() + getSumOfData() + getDataLength().toUByte() + getType().toUByte()).toUByte()
        return get2ndComplement(sum)
    }

    private fun get2ndComplement(input: UByte): UByte {
        var retVal: UByte = input.inv()
        return (retVal + 1.toUByte()).toUByte()
    }

    private fun getSumOfData(): UByte {
        var dataArray = getData()
        var sum: UByte = 0.toUByte()
        for (data in dataArray) {
            sum = (sum + data).toUByte()
        }
        return sum
    }

    private fun getSumOfAddress(): UByte {
        var addressBlock = getAddressBytes()
        var sum: UByte = 0.toUByte()
        for (block in addressBlock)
            sum = (sum + block).toUByte()
        return sum
    }

    private fun getAddressBytes(): List<UByte> {
        var addressBytes: MutableList<UByte> = mutableListOf()
        addressBytes.add(instructionString.substring(3, 5).toUByte(16))
        addressBytes.add(instructionString.substring(5, 7).toUByte(16))
        return addressBytes.toList()
    }

    private fun getChecksum(): UByte {
        val length = instructionString.length
        return instructionString.substring(startIndex = length - 2, length).toUByte(16)
    }

    fun getData(): List<UByte> {
        var blockArray: MutableList<String> = mutableListOf()
        for (i in 9..8 + 2 * getDataLength() step 2) {
            blockArray.add(instructionString.substring(startIndex = i, i + 2))
        }

        var retVal: MutableList<UByte> = mutableListOf()
        for (str in blockArray) {
            retVal.add(str.toUByte(16))
        }
        return retVal.toList()
    }

    fun getDataLength(): Int {
        return instructionString.substring(1, 3).toInt(16)
    }

    fun getAddress(): Int {
        return instructionString.substring(3, 7).toInt(16)
    }

    fun getType(): Int {
        return instructionString.substring(7, 9).toInt()
    }

    inner class InvalidChecksumException : Exception {
        constructor() : super()
    }
}
