class LazyProperty(val initializer: () -> Int) {
    var lazyValue: Int? = null
    val lazy: Int
        get() {
            if (lazyValue == null) {
                lazyValue = initializer()
            }
            return lazyValue!!
        }
}
