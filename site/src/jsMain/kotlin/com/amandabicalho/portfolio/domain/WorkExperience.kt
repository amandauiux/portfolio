package com.amandabicalho.portfolio.domain

import kotlinx.datetime.LocalDate

data class WorkExperience(
    val title: String,
    val company: String,
    val url: String,
    val startDate: LocalDate,
    val endDate: LocalDate? = null,
)
