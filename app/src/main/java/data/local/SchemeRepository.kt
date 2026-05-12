package com.prathvik.arogyanidhi.data.local

import com.prathvik.arogyanidhi.domain.model.HealthcareScheme
import com.prathvik.arogyanidhi.domain.model.UserAssessment

object SchemeRepository {

    fun getSchemes(
        assessment: UserAssessment
    ): List<HealthcareScheme> {

        val schemes =
            mutableListOf<HealthcareScheme>()

        val age = assessment.age
        val gender = assessment.gender
        val income = assessment.income
        val symptom = assessment.symptom

        if (age == "Below 18") {

            schemes.add(
                HealthcareScheme(
                    "RBSK",
                    "Free health screening for children.",
                    "Eligible because age is below 18."
                )
            )

            schemes.add(
                HealthcareScheme(
                    "Balasanjeevini",
                    "Nutrition and healthcare support for children.",
                    "Applicable for children in Karnataka."
                )
            )
        }

        if (income == "Low") {

            schemes.add(
                HealthcareScheme(
                    "Ayushman Bharat PM-JAY",
                    "₹5 lakh free hospitalization coverage.",
                    "Eligible for low-income families."
                )
            )
        }

        if (
            gender == "Female" &&
            symptom == "Pregnancy Care"
        ) {

            schemes.add(
                HealthcareScheme(
                    "PMMVY",
                    "Financial support for pregnant women.",
                    "Applicable for pregnancy care."
                )
            )

            schemes.add(
                HealthcareScheme(
                    "Janani Suraksha Yojana",
                    "Cash incentive for institutional delivery.",
                    "Recommended for maternity support."
                )
            )
        }

        if (symptom == "Heart Problems") {

            schemes.add(
                HealthcareScheme(
                    "SAST Karnataka",
                    "Cashless cardiac treatment support.",
                    "Suitable for heart-related treatment."
                )
            )
        }

        if (symptom == "Diabetes") {

            schemes.add(
                HealthcareScheme(
                    "NP-NCD",
                    "Free diabetes screening and medicines.",
                    "Recommended for diabetes care."
                )
            )
        }

        if (symptom == "Fever") {

            schemes.add(
                HealthcareScheme(
                    "NVBDCP",
                    "Free diagnosis for malaria and dengue.",
                    "Suitable for fever-related illness."
                )
            )
        }

        return schemes.distinctBy {
            it.name
        }
    }
}