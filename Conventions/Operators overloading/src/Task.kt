import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)
class RepeatedTimeInterval(val timeInterval: TimeInterval, val times: Int)
operator fun TimeInterval.times(times: Int) = RepeatedTimeInterval(this, times)
operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate =
        addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.times)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
