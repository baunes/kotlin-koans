class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator() = DateIterator(this)
}

class DateIterator(private val dateRange: DateRange) : Iterator<MyDate> {
    private var current: MyDate = dateRange.start

    override fun hasNext() = current <= dateRange.end

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
