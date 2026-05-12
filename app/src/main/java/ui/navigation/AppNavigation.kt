package com.prathvik.arogyanidhi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prathvik.arogyanidhi.domain.model.UserAssessment
import com.prathvik.arogyanidhi.ui.screens.auth.LoginScreen
import com.prathvik.arogyanidhi.ui.screens.auth.SignupScreen
import com.prathvik.arogyanidhi.ui.screens.chatbot.ChatbotScreen
import com.prathvik.arogyanidhi.ui.screens.hospital.HospitalScreen
import com.prathvik.arogyanidhi.ui.screens.onboarding.OnboardingScreen
import com.prathvik.arogyanidhi.ui.screens.quiz.QuizScreen
import com.prathvik.arogyanidhi.ui.screens.result.ResultScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    var assessmentData = UserAssessment(
        age = "",
        gender = "",
        income = "",
        symptom = ""
    )

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {

            LoginScreen(

                onLoginSuccess = {
                    navController.navigate("onboarding")
                },

                onSignupClick = {
                    navController.navigate("signup")
                }
            )
        }

        composable("signup") {

            SignupScreen(

                onSignupSuccess = {
                    navController.navigate("onboarding")
                }
            )
        }

        composable("onboarding") {

            OnboardingScreen(
                onStartClick = {
                    navController.navigate("quiz")
                }
            )
        }

        composable("quiz") {

            QuizScreen(
                onContinueClick = {

                    assessmentData = it

                    navController.navigate("result")
                }
            )
        }

        composable("result") {

            ResultScreen(
                assessment = assessmentData,

                onHospitalClick = {
                    navController.navigate("hospital")
                },

                onChatbotClick = {
                    navController.navigate("chatbot")
                }
            )
        }

        composable("hospital") {

            HospitalScreen(
                assessment = assessmentData
            )
        }

        composable("chatbot") {

            ChatbotScreen()
        }
    }
}