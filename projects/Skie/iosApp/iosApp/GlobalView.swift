import Foundation
import Shared
import SwiftUI

struct GlobalView: View {
    var data: Int32 = globalFunction(i: 1)
    var body: some View {
        VStack {
            Text("\(data)")
        }
    }
}

struct GlobalView_Previews: PreviewProvider {
    static var previews: some View {
        GlobalView()
    }
}
