import Shared
import SwiftUI

struct TurnView: View {
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
            }

//            switch turn {
//            case Turn.left:
//                Text("LEFT")
//            case Turn.right:
//                Text("RIGHT")
//            case Turn.neither:
//                Text("NEWITHER")
//            default:
//                Text("DEFAULT")
//            }
        }
    }
}

struct TurnView_Previews: PreviewProvider {
    static var previews: some View {
        TurnView(turn: Turn.left)
    }
}
