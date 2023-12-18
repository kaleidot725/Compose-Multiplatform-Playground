import Foundation
import Shared

func overload() {
    // NOT SKIE
    // OverloadKt.foo(i: 1)
    // OverloadKt.foo(i_: "A")

    // SKIE
    foo(i: 1)
    foo(i: "A")
}
