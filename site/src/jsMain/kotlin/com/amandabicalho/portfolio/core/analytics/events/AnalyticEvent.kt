package com.amandabicalho.portfolio.core.analytics.events

import com.amandabicalho.portfolio.core.binding.firebase.EventParams
import com.amandabicalho.portfolio.core.binding.firebase.eventsOf
import kotlinx.browser.document
import kotlinx.browser.window

sealed interface AnalyticEvent {
    val name: String
    fun toParams(): EventParams

    data object PageView : AnalyticEvent {
        override val name = "page_view"

        override fun toParams(): EventParams = eventsOf(
            "page_title" to document.title,
            "page_location" to window.location.href,
            "page_referrer" to document.referrer,
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

    data object ViewAllProjects : AnalyticEvent {
        override val name = "view_all_projects"

        override fun toParams(): EventParams = eventsOf()
    }

    data class ViewProject(
        val projectTitle: String,
        val projectUrl: String,
    ) : AnalyticEvent {
        override val name = "view_project"

        override fun toParams(): EventParams = eventsOf(
            "project_title" to projectTitle,
            "project_url" to projectUrl,
        )
    }
}
