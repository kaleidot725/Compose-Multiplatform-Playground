package jp.kaleidot725.safeareaicon

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.ComposeUIViewController
import platform.Foundation.NSCoder
import platform.UIKit.UIStatusBarStyle
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.UIView
import platform.UIKit.UIViewAutoresizingFlexibleHeight
import platform.UIKit.UIViewAutoresizingFlexibleWidth
import platform.UIKit.UIViewController
import platform.UIKit.addChildViewController
import platform.UIKit.didMoveToParentViewController

class MainUIViewController : UIViewController {
    @OverrideInit
    constructor() : super(nibName = null, bundle = null)

    @OverrideInit
    constructor(coder: NSCoder) : super(coder)

    /**
     * isDarkの状態を変更したら、StatusBarのアップデートを要求する
     */
    private var enableDarkStatusBar: Boolean = false
        set(value) {
            field = value
            setNeedsStatusBarAppearanceUpdate()
        }

    private val childComposeViewController = ComposeUIViewController {
        var isDark by remember { mutableStateOf(enableDarkStatusBar) }
        App(
            isDark = isDark,
            onChangeDarkMode = {
                isDark = it
                enableDarkStatusBar = it
            },
        )
    }

    /**
     * isDarkの状態によって、StatusBarStyleが変化するようにする
     */
    override fun preferredStatusBarStyle(): UIStatusBarStyle {
        return if (enableDarkStatusBar) UIStatusBarStyleLightContent else UIStatusBarStyleDarkContent
    }

    override fun loadView() {
        super.loadView()

        // RootのUIViewControllerのViewをセットする
        view = UIView().apply {
            // SubViewとしてComposeのUIViewControlerのViewをセットする
            addSubview(
                childComposeViewController.view.apply {
                    // AutoresizingMaskを利用し、RootのViewに合わせてリサイズするようにする
                    setAutoresizingMask(
                        UIViewAutoresizingFlexibleWidth or UIViewAutoresizingFlexibleHeight
                    )
                }
            )
        }

        // RootのUIViewControllerの子にComposeのUIViewControllerを追加する
        addChildViewController(childComposeViewController)
        childComposeViewController.didMoveToParentViewController(this)
    }
}
