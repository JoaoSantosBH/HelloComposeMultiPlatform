import androidx.compose.ui.window.ComposeUIViewController
import com.brq.kmm.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
