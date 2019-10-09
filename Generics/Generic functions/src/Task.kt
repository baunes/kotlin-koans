import java.util.*

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(truePartiton: C, falsePartition: C, predicate: (T) -> Boolean): Pair<C, C> {
    forEach { (if (predicate(it)) truePartiton else falsePartition).add(it) }
    return Pair(truePartiton, falsePartition)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
