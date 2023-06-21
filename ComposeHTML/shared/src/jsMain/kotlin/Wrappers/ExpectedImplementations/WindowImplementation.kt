package Wrappers.ExpectedImplementations

import kotlinx.browser.window

class WindowImplementation: WindowInterface {
    override fun open(url: String, target: String) {
        window.open(url = url, target = target)
    }
}