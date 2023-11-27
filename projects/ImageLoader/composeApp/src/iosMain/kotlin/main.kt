import androidx.compose.ui.window.ComposeUIViewController
import jp.kaleidot725.imageloader.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
