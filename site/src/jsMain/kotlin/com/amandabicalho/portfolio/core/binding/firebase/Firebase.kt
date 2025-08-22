@file:Suppress("NOTHING_TO_INLINE")

package com.amandabicalho.portfolio.core.binding.firebase

import com.amandabicalho.portfolio.config.BuildConfig

fun FirebaseOptions(builder: FirebaseOptions.() -> Unit): FirebaseOptions {
    return js("{}").unsafeCast<FirebaseOptions>().apply(builder)
}

fun AnalyticsCallOptions(builder: AnalyticsCallOptions.() -> Unit): AnalyticsCallOptions {
    return js("{}").unsafeCast<AnalyticsCallOptions>().apply(builder)
}

inline operator fun <reified T> EventParams.get(key: String): T = asDynamic()[key].unsafeCast<T>()
inline operator fun EventParams.set(key: String, value: Any) {
    asDynamic()[key] = value
}

fun eventsOf(vararg events: Pair<String, Any>): EventParams =
    js("{}").unsafeCast<EventParams>().apply {
        events.forEach { (key, value) ->
            this[key] = value
        }

        if (BuildConfig.FIREBASE_DEBUG_MODE) {
            this["debug_mode"] = true
        }
    }

fun AnalyticsSettings(builder: AnalyticsSettings.() -> Unit): AnalyticsSettings {
    return js("{}").unsafeCast<AnalyticsSettings>().apply(builder)
}

fun GtagConfigParams(builder: GtagConfigParams.() -> Unit): GtagConfigParams {
    return js("{}").unsafeCast<GtagConfigParams>().apply(builder)
}
