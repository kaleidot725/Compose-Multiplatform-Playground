import Foundation
import Shared
import SwiftUI

struct UserView: View {
    var user: User
    var body: some View {
        VStack {
            let test1 = user.doCopy(name: "TEST", age: 32)
            Text(test1.name)
            Text("\(test1.age)")
        }
    }
}

struct UserView_Previews: PreviewProvider {
    static var previews: some View {
        UserView(user: User(name: "NAME", age: 14))
    }
}
