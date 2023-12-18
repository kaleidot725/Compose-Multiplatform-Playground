import Foundation
import Shared

func suspend() {
    let chatRoom = ChatRoom()
    let task = Task.detached {
        try? await chatRoom.send(message: "some message")
    }
    task.cancel()
}