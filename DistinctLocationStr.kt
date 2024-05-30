fun distinctLocationStr(locationStr : String): String {
    println("original : "+locationStr)
    if(locationStr == "")
        return locationStr

    var splitList = locationStr.split(" ")

    splitList = splitList.distinct()

    val result = buildString {
        splitList.forEach { list ->
            this.append(list)
            if(list != splitList.last())
                this.append(" ")
        }
    }

    println("distinct result : "+result)

    return result

}
