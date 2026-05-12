package com.prathvik.arogyanidhi.ui.screens.hospital

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

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.prathvik.arogyanidhi.domain.model.UserAssessment
import com.prathvik.arogyanidhi.ui.theme.PrimaryBlue

data class Hospital(
    val name: String,
    val specialty: String,
    val location: String,
    val emergencyAvailable: Boolean
)

@Composable
fun HospitalScreen(
    assessment: UserAssessment
) {

    val hospitals = when (
        assessment.symptom.lowercase()
    ) {

        "fever" -> listOf(

            Hospital(
                "Victoria Hospital",
                "Fever & General Medicine",
                "Bangalore, Karnataka",
                true
            ),

            Hospital(
                "Wenlock Hospital",
                "Infectious Diseases",
                "Mangalore, Karnataka",
                true
            ),

            Hospital(
                "District Hospital",
                "Fever Treatment",
                "Belagavi, Karnataka",
                false
            )
        )

        "diabetes" -> listOf(

            Hospital(
                "KIMS Hospital",
                "Diabetes Care",
                "Hubli, Karnataka",
                true
            ),

            Hospital(
                "NIMHANS",
                "Diabetes Monitoring",
                "Bangalore, Karnataka",
                true
            ),

            Hospital(
                "Mysore Medical College Hospital",
                "Sugar Management",
                "Mysore, Karnataka",
                false
            )
        )

        "heart problems" -> listOf(

            Hospital(
                "Jayadeva Hospital",
                "Cardiology",
                "Bangalore, Karnataka",
                true
            ),

            Hospital(
                "KLE Hospital",
                "Heart Surgery",
                "Belagavi, Karnataka",
                true
            ),

            Hospital(
                "Manipal Hospital",
                "Cardiac Care",
                "Bangalore, Karnataka",
                true
            )
        )

        "pregnancy care" -> listOf(

            Hospital(
                "Vani Vilas Hospital",
                "Maternity Care",
                "Bangalore, Karnataka",
                true
            ),

            Hospital(
                "Cheluvamba Hospital",
                "Women Healthcare",
                "Mysore, Karnataka",
                true
            ),

            Hospital(
                "District Women Hospital",
                "Pregnancy Support",
                "Hubli, Karnataka",
                false
            )
        )

        "general checkup" -> listOf(

            Hospital(
                "Bowring Hospital",
                "General Checkup",
                "Bangalore, Karnataka",
                true
            ),

            Hospital(
                "KIMS Hospital",
                "Health Screening",
                "Hubli, Karnataka",
                true
            ),

            Hospital(
                "Wenlock Hospital",
                "Routine Checkup",
                "Mangalore, Karnataka",
                false
            )
        )

        else -> listOf(

            Hospital(
                "Victoria Hospital",
                "General Healthcare",
                "Bangalore, Karnataka",
                true
            ),

            Hospital(
                "KIMS Hospital",
                "Government Hospital",
                "Hubli, Karnataka",
                true
            ),

            Hospital(
                "Mysore Medical College Hospital",
                "Healthcare Services",
                "Mysore, Karnataka",
                false
            )
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
            .padding(24.dp),

        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Karnataka Hospitals",

            fontSize = 30.sp,

            fontWeight = FontWeight.Bold,

            color = PrimaryBlue
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        hospitals.forEach { hospital ->

            Card(
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(20.dp),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFF7FC)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = hospital.name,

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold,

                        color = PrimaryBlue
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text =
                            "Specialty: ${hospital.specialty}",

                        fontSize = 16.sp
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text =
                            "Location: ${hospital.location}",

                        fontSize = 16.sp
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text =
                            if (hospital.emergencyAvailable)
                                "Emergency Available"
                            else
                                "Emergency Not Available",

                        color =
                            if (hospital.emergencyAvailable)
                                Color(0xFF2E7D32)
                            else
                                Color.Red,

                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}