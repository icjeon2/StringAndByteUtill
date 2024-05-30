/*
  바이트 변환시 바이트 크기에 맞추어 padding
*/
fun paddingRight(value: String, totalLength: Int): String {
    val byteResult = ByteArray(totalLength)
    for (i in byteResult.indices) {
        byteResult[i] = 0x20
    }
    val charset = Charsets.UTF_8
    val valueBytes = value.toByteArray(charset)
    try {
        System.arraycopy(
            valueBytes, 0, byteResult, 0,
            min(valueBytes.size, totalLength)
        )
    } catch (e: UnsupportedEncodingException) {
        e.printStackTrace()
    }
    return String(byteResult, charset)
}
