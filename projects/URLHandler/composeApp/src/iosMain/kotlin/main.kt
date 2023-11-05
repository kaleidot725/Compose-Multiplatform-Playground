import androidx.compose.ui.window.ComposeUIViewController
import jp.kaleidot725.urlhandler.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
