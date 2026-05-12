package com.prathvik.arogyanidhi.domain.recommendation

import com.prathvik.arogyanidhi.domain.model.UserAssessment

data class SchemeRecommendation(
    val schemeName: String,
    val description: String,
    val benefits: List<String>
)

object SchemeEngine {

    fun getRecommendation(
        assessment: UserAssessment
    ): SchemeRecommendation {

        return when {

            assessment.symptom == "Heart Problems" -> {

                SchemeRecommendation(
                    schemeName = "Ayushman Bharat Cardiac Care",
                    description = "Cardiac healthcare and specialized treatment support.",
                    benefits = listOf(
                        "Heart treatment coverage",
                        "Emergency cardiac care",
                        "Cashless hospitalization",
                        "Specialized hospitals"
                    )
                )
            }

            assessment.symptom == "Diabetes" -> {

                SchemeRecommendation(
                    schemeName = "National Diabetes Assistance Scheme",
                    description = "Long-term diabetes healthcare and monitoring support.",
                    benefits = listOf(
                        "Regular health monitoring",
                        "Medicine support",
                        "Government hospitals",
                        "Health checkups"
                    )
                )
            }

            assessment.symptom == "Pregnancy Care" &&
                    assessment.gender == "Female" -> {

                SchemeRecommendation(
                    schemeName = "Janani Suraksha Yojana",
                    description = "Maternal healthcare and pregnancy support scheme.",
                    benefits = listOf(
                        "Pregnancy care",
                        "Hospital delivery support",
                        "Women healthcare assistance",
                        "Government maternity benefits"
                    )
                )
            }

            assessment.age == "Above 60" -> {

                SchemeRecommendation(
                    schemeName = "Senior Citizen Health Scheme",
                    description = "Healthcare support for senior citizens.",
                    benefits = listOf(
                        "Senior healthcare",
                        "Emergency support",
                        "Insurance benefits",
                        "Priority treatment"
                    )
                )
            }

            assessment.income == "Low Income" -> {

                SchemeRecommendation(
                    schemeName = "Ayushman Bharat",
                    description = "Healthcare assistance for economically weaker families.",
                    benefits = listOf(
                        "Coverage up to ₹5 Lakhs",
                        "Cashless treatment",
                        "Free hospitalization",
                        "Government-approved hospitals"
                    )
                )
            }

            else -> {

                SchemeRecommendation(
                    schemeName = "National Health Protection Scheme",
                    description = "General healthcare assistance and support.",
                    benefits = listOf(
                        "Free treatment",
                        "Cashless support",
                        "Hospital coverage",
                        "Government healthcare"
                    )
                )
            }
        }
    }
}