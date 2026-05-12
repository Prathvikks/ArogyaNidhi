package com.prathvik.arogyanidhi.ui.screens.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.prathvik.arogyanidhi.domain.model.UserAssessment
import com.prathvik.arogyanidhi.ui.theme.PrimaryBlue

@Composable
fun QuizScreen(
    onContinueClick: (UserAssessment) -> Unit
) {

    var selectedAge by remember {
        mutableStateOf("")
    }

    var selectedGender by remember {
        mutableStateOf("")
    }

    var selectedIncome by remember {
        mutableStateOf("")
    }

    var selectedSymptom by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE3F2FD),
                        Color.White
                    )
                )
            )
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Health Assessment",

            fontSize = 30.sp,

            fontWeight = FontWeight.Bold,

            color = PrimaryBlue
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Card(
            shape = RoundedCornerShape(20.dp),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                // AGE

                Text(
                    text = "What is your age group?",

                    fontSize = 20.sp,

                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                val ageOptions = listOf(
                    "Below 18",
                    "18 - 40",
                    "40 - 60",
                    "Above 60"
                )

                ageOptions.forEach { option ->

                    RowOption(
                        text = option,

                        selected =
                            selectedAge == option,

                        onSelect = {
                            selectedAge = option
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                // GENDER

                Text(
                    text = "Select Gender",

                    fontSize = 20.sp,

                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                val genderOptions = listOf(
                    "Male",
                    "Female",
                    "Other"
                )

                genderOptions.forEach { gender ->

                    RowOption(
                        text = gender,

                        selected =
                            selectedGender == gender,

                        onSelect = {
                            selectedGender = gender
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                // INCOME

                Text(
                    text = "Select Income Category",

                    fontSize = 20.sp,

                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                val incomeOptions = listOf(

                    "Low Income (Below ₹2.5 Lakhs/year)",

                    "Middle Income (₹2.5L - ₹10L/year)",

                    "High Income (Above ₹10 Lakhs/year)"
                )

                incomeOptions.forEach { income ->

                    RowOption(
                        text = income,

                        selected =
                            selectedIncome == income,

                        onSelect = {
                            selectedIncome = income
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                // SYMPTOMS

                Text(
                    text = "Select Primary Symptom",

                    fontSize = 20.sp,

                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                val symptomOptions = listOf(
                    "Fever",
                    "Diabetes",
                    "Heart Problems",
                    "General Checkup",
                    "Pregnancy Care"
                )

                symptomOptions.forEach { symptom ->

                    RowOption(
                        text = symptom,

                        selected =
                            selectedSymptom == symptom,

                        onSelect = {
                            selectedSymptom = symptom
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.height(28.dp)
                )

                Button(
                    onClick = {

                        onContinueClick(
                            UserAssessment(
                                age = selectedAge,
                                gender = selectedGender,
                                income = selectedIncome,
                                symptom = selectedSymptom
                            )
                        )
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp),

                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor =
                                PrimaryBlue
                        )
                ) {

                    Text(
                        text = "Continue",

                        color = Color.White,

                        fontSize = 17.sp,

                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun RowOption(
    text: String,
    selected: Boolean,
    onSelect: () -> Unit
) {

    androidx.compose.foundation.layout.Row(
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        RadioButton(
            selected = selected,
            onClick = onSelect
        )

        Text(
            text = text,

            fontSize = 16.sp
        )
    }
}