fun String.getInputWords(): List<String>{
    return this.split(" ", ignoreCase = true).map { it.toLowerCase().trim() }
}