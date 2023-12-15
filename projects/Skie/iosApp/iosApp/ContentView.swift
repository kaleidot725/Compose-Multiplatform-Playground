import SwiftUI
import Shared

struct ContentView: View {
    var turn: Turn
    var body: some View {
        VStack {
            switch turn {
            case .left:
                Text("LEFT")
            case .right:
                Text("RIGHT")
            case .neither:
                Text("NEITHER")
            default:
                Text("DEFAULT")
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(turn: Turn.left)
    }
}
