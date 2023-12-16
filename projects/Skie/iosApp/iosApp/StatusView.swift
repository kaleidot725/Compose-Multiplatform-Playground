import Foundation
import Shared
import SwiftUI

struct StatusView: View {
    var status: Status
    var body: some View {
        VStack {
            switch onEnum(of: status) {
            case .loading:
                Text("LOADING")
            case .error(let error):
                Text("ERROR \(error.value)")
            case .success(let success):
                Text("SUCCES \(success.value)")
            }

//            switch status {
//            case let loading as Status.Loading:
//                Text("LOADING")
//            case let error as Status.Error:
//                Text("ERROR \(error.value)")
//            case let success as Status.Success:
//                Text("SUCCESS \(success.value)")
//            default:
//                Text("DEFAULT")
//            }
        }
    }
}

struct StatusView_Previews: PreviewProvider {
    static var previews: some View {
        StatusView(status: Status.Error(value: "UNKNOWN"))
    }
}
