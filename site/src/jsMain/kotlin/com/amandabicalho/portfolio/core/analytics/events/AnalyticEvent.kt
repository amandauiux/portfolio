package com.amandabicalho.portfolio.core.analytics.events

import com.amandabicalho.portfolio.core.binding.firebase.EventParams
import com.amandabicalho.portfolio.core.binding.firebase.eventsOf
import kotlinx.browser.document
import kotlinx.browser.window

sealed interface AnalyticEvent {
    val name: String
    fun toParams(): EventParams

    data class PageView(
        val language: String
    ) : AnalyticEvent {
        override val name = "page_view"

        override fun toParams(): EventParams = eventsOf(
            "page_title" to document.title,
            "page_location" to window.location.href,
            "lang" to language,
        )
    }

    data class ScreenView(
        val screenName: String,
        val screenClass: String = window.location.href,
    ) : AnalyticEvent {
        override val name = "screen_view"

        override fun toParams(): EventParams = eventsOf(
            "screen_name" to screenName,
            "screen_class" to screenClass,
        )
    }

    data class SocialMediaView(
        val socialMedia: String,
    ) : AnalyticEvent {
        override val name = "social_media_view"

        override fun toParams(): EventParams = eventsOf(
            "social_media" to socialMedia,
        )
    }

    data class ViewResumePdf(
        val language: String,
    ) : AnalyticEvent {
        override val name = "view_resume_pdf"

        override fun toParams(): EventParams = eventsOf(
            "lang" to language,
        )
    }

    data class ViewProject(
        val projectName: String,
        val projectUrl: String,
    ) : AnalyticEvent {
        override val name = "view_project"

        override fun toParams(): EventParams = eventsOf(
            "project_name" to projectName,
            "project_url" to projectUrl,
        )
    }
}
