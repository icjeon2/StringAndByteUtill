/**
     * originalStr을 byteSize 이하로 (sliceLeft True:왼쪽 false:오른쪽) 부터 한글자씩 자른다.
     */
    fun sliceWithByteSize(originalStr : String, byteSize : Int, sliceLeft : Boolean): String {
        if(originalStr == "")
            return ""

        val charset = Charsets.UTF_8
        val originalByteArray = originalStr.toByteArray(charset)
        val diff = originalByteArray.size - byteSize

        var result = originalStr
        var sliceSize = 0
        if(diff>0) {
            var sliceIndex = 0
            if(sliceLeft) {
                for (c in originalStr) {
                    sliceSize += c.toString().toByteArray(charset).size

                    sliceIndex++

                    if (sliceSize >= diff)
                        break
                }
                result = originalStr.substring(sliceIndex, originalStr.length)
            } else {
                var currentSize = 0
                for (c in originalStr) {
                    currentSize += c.toString().toByteArray(charset).size

                    if(currentSize <= byteSize) {
                        sliceIndex++
                        sliceSize = originalByteArray.size-currentSize
                    }

                    if (currentSize >= byteSize)
                        break
                }
                result = originalStr.substring(0, sliceIndex)
            }
        }

        Timber.d("slice byteSize %s - %s = %s", originalByteArray.size, sliceSize, result.toByteArray(charset).size)
        Timber.d("original string : %s", originalStr)
        Timber.d("sliced string : %s", result)

        return result
    }
