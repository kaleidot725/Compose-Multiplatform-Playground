import Shared
import SwiftUI

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            VStack {
                TurnView(turn: Turn.left)
                StatusView(status: Status.Error(value: "UNKNOWN"))
            }
        }
    }
}
