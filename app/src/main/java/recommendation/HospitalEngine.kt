package com.prathvik.arogyanidhi.domain.recommendation

import com.prathvik.arogyanidhi.domain.model.Hospital
import com.prathvik.arogyanidhi.domain.model.UserAssessment

object HospitalEngine {

    fun getHospitals(
        assessment: UserAssessment
    ): List<Hospital> {

        return when(assessment.symptom) {

            "Heart Problems" -> {

                listOf(

                    Hospital(
                        name = "Narayana Cardiac Hospital",
                        specialty = "Cardiology",
                        location = "Bangalore",
                        emergencyAvailable = true
                    ),

                    Hospital(
                        name = "Apollo Heart Institute",
                        specialty = "Heart Care",
                        location = "Chennai",
                        emergencyAvailable = true
                    )
                )
            }

            "Pregnancy Care" -> {

                listOf(

                    Hospital(
                        name = "Motherhood Hospital",
                        specialty = "Women & Child Care",
                        location = "Bangalore",
                        emergencyAvailable = true
                    ),

                    Hospital(
                        name = "Cloudnine Hospital",
                        specialty = "Maternity Care",
                        location = "Mysore",
                        emergencyAvailable = false
                    )
                )
            }

            "Diabetes" -> {

                listOf(

                    Hospital(
                        name = "Diabetes Care Center",
                        specialty = "Diabetology",
                        location = "Hyderabad",
                        emergencyAvailable = false
                    ),

                    Hospital(
                        name = "Aster Health",
                        specialty = "General Medicine",
                        location = "Bangalore",
                        emergencyAvailable = true
                    )
                )
            }

            else -> {

                listOf(

                    Hospital(
                        name = "Government General Hospital",
                        specialty = "General Healthcare",
                        location = "Bangalore",
                        emergencyAvailable = true
                    ),

                    Hospital(
                        name = "City Care Hospital",
                        specialty = "Multi Specialty",
                        location = "Mysore",
                        emergencyAvailable = false
                    )
                )
            }
        }
    }
}