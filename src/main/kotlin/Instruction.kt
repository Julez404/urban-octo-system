class Instruction(initString: String) {
    val instructionString: String

    init {
        println("Create Instruction with string: " + initString)
        instructionString = initString
        if (!checksumIsValid())
            throw InvalidInstructionException()
    }

    private fun checksumIsValid(): Boolean {
        //var checksumRaw = getDataLength() + getAddress() + getData()
        return true
    }

    fun getData(): List<Short> {
        var blockArray: MutableList<String> = mutableListOf()
        for (i in 9..8 + 2 * getDataLength() step 2) {
            blockArray.add(instructionString.substring(startIndex = i, i + 2))
        }

        var retVal: MutableList<Short> = mutableListOf()
        for (str in blockArray) {
            retVal.add(str.toShort(16))
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

    inner class InvalidInstructionException : Exception {
        constructor() : super()
        constructor(message: String) : super(message)
        constructor(message: String, cause: Throwable) : super(message, cause)
        constructor(cause: Throwable) : super(cause)
    }
}
