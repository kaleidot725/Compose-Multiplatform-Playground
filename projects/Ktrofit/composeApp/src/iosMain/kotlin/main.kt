import androidx.compose.ui.window.ComposeUIViewController
import jp.kaleidot725.ktrofit.sample.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
