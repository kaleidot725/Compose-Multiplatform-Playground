import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController
import jp.kaleidot725.safeareaicon.App
import platform.Foundation.NSCoder
import platform.UIKit.UIView
import platform.UIKit.UIViewAutoresizingFlexibleHeight
import platform.UIKit.UIViewAutoresizingFlexibleWidth
import platform.UIKit.UIViewController
import platform.UIKit.addChildViewController
import platform.UIKit.didMoveToParentViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }