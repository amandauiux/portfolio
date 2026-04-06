package com.amandabicalho.portfolio.core.ui.animation

import org.w3c.dom.Element

/**
 * Kotlin external declaration for the browser IntersectionObserver API.
 * Note: This is declared at package level (not file-level @JsQualifier)
 * to allow non-external helper functions in the same file.
 */
@JsName("IntersectionObserver")
external class JsIntersectionObserver(
    callback: (entries: Array<JsIntersectionObserverEntry>, observer: JsIntersectionObserver) -> Unit,
    options: dynamic = definedExternally,
) {
    fun observe(element: Element)
    fun disconnect()
}

external interface JsIntersectionObserverEntry {
    val isIntersecting: Boolean
}

/**
 * Creates an IntersectionObserver that fires [onIntersect] once
 * when the observed element enters the viewport, then automatically disconnects.
 */
fun createRevealObserver(
    element: Element,
    threshold: Double,
    onIntersect: () -> Unit,
): JsIntersectionObserver {
    val options: dynamic = object {}
    options.threshold = threshold

    val observer = JsIntersectionObserver(
        callback = { entries, obs ->
            for (entry in entries) {
                if (entry.isIntersecting) {
                    obs.disconnect()
                    onIntersect()
                    return@JsIntersectionObserver
                }
            }
        },
        options = options,
    )
    observer.observe(element)
    return observer
}
