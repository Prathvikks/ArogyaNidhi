package com.prathvik.arogyanidhi.ui.screens.result

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prathvik.arogyanidhi.data.local.SchemeRepository
import com.prathvik.arogyanidhi.domain.model.UserAssessment
import com.prathvik.arogyanidhi.ui.theme.PrimaryBlue

@Composable
fun ResultScreen(
    assessment: UserAssessment,
    onHospitalClick: () -> Unit,
    onChatbotClick: () -> Unit
) {

    val schemes = remember {

        SchemeRepository.getSchemes(
            assessment
        )
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
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Healthcare Recommendations",

            fontSize = 30.sp,

            fontWeight = FontWeight.Bold,

            color = PrimaryBlue
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text =
                "Smart recommendations generated using your healthcare profile.",

            fontSize = 16.sp,

            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(28.dp))

        schemes.forEach { scheme ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),

                shape = RoundedCornerShape(24.dp),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {

                    Text(
                        text = scheme.name,

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold,

                        color = PrimaryBlue
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = scheme.description,

                        fontSize = 16.sp,

                        color = Color.DarkGray
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor =
                                Color(0xFFE8F5E9)
                        )
                    ) {

                        Text(
                            text =
                                "Eligibility: ${scheme.eligibility}",

                            modifier = Modifier
                                .padding(12.dp),

                            color = Color(0xFF2E7D32),

                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onChatbotClick()
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7B1FA2)
            )
        ) {

            Text(
                text = "Open AI Chatbot",

                color = Color.White,

                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Button(
            onClick = {
                onHospitalClick()
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryBlue
            )
        ) {

            Text(
                text = "View Nearby Hospitals",

                color = Color.White,

                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),

            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE8F5E9)
            )
        ) {

            Text(
                text =
                    "Smart Rule-Based Recommendation Engine Active",

                modifier = Modifier.padding(18.dp),

                fontWeight = FontWeight.Bold,

                color = Color(0xFF2E7D32),

                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}