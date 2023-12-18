import Foundation
import Shared

func sample() {
    // Exntesion Function
    C().foo(i: 1) // SKIE
    ExtensionKt.foo(C(), i: 0)

    // Extension Property
    C().bar(i: 1) // SKIE
    ExtensionKt.setBar(C(), value: 1)
}