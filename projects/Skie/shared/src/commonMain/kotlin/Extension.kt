interface I

class C : I

fun I.foo(i: Int): Int = i

var I.bar: Int
    get() = 1
    set(value) {}
