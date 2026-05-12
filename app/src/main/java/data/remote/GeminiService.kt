package com.prathvik.arogyanidhi.data.remote

import com.prathvik.arogyanidhi.domain.model.UserAssessment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object GeminiService {

    suspend fun generateRecommendation(
        assessment: UserAssessment
    ): String {

        return withContext(Dispatchers.IO) {

            delay(1500)

            """
            Recommended Government Scheme:
            Ayushman Bharat Yojana

            Based on your details:
            • Age Group: ${assessment.age}
            • Gender: ${assessment.gender}
            • Income: ${assessment.income}
            • Symptoms: ${assessment.symptom}

            Health Precautions:
            • Drink plenty of water
            • Take proper rest
            • Avoid oily food
            • Consult a nearby doctor if symptoms increase

            Recommended Support:
            • Visit nearest government hospital
            • Use free health checkup facilities
            • Apply for Ayushman Bharat benefits

            Stay safe and take care.
            """.trimIndent()
        }
    }

    suspend fun generateChatResponse(
        userMessage: String
    ): String {

        return withContext(Dispatchers.IO) {

            delay(1000)

            when {

                userMessage.contains(
                    "fever",
                    ignoreCase = true
                ) -> {

                    "For fever: drink water, take rest, and consult a doctor if temperature remains high."
                }

                userMessage.contains(
                    "cold",
                    ignoreCase = true
                ) -> {

                    "For cold and cough: stay hydrated and avoid cold foods."
                }

                userMessage.contains(
                    "headache",
                    ignoreCase = true
                ) -> {

                    "Headaches can happen due to stress or dehydration. Take rest and drink water."
                }

                else -> {

                    "I am your AI healthcare assistant. Please describe your symptoms clearly."
                }
            }
        }
    }
}