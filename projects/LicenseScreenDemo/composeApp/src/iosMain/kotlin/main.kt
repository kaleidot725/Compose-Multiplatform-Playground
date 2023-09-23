import androidx.compose.ui.window.ComposeUIViewController
import jp.kaleidot725.sample.license.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
