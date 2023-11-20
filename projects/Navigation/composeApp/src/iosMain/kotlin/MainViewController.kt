import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.defaultRouterContext

fun HomeUIViewController(): UIViewController = ComposeUIViewController {
    val routerContext = defaultRouterContext()
    CompositionLocalProvider(LocalRouterContext provides routerContext) {
        App()
    }
}
