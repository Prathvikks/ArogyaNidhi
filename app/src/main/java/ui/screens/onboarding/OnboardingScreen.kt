package com.prathvik.arogyanidhi.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star

@Composable
fun OnboardingScreen(
    onStartClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFEAF4FF),
                        Color.White
                    )
                )
            )
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        AppLogo()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "ArogyaNidhi",

            fontSize = 40.sp,

            fontWeight = FontWeight.Bold,

            color = Color(0xFF0077D9)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(28.dp),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFF7FC)
            )
        ) {

            Column(
                modifier = Modifier.padding(24.dp),

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Text(
                    text =
                        "Find the best government healthcare schemes.",

                    fontSize = 22.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF3D2B5C)
                )

                Spacer(
                    modifier = Modifier.height(28.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.SpaceEvenly
                ) {

                    FeatureItem(
                        icon = Icons.Default.Star,
                        title = "AI Powered"
                    )

                    FeatureItem(
                        icon = Icons.Default.Favorite,
                        title = "Health Schemes"
                    )

                    FeatureItem(
                        icon = Icons.Default.Home,
                        title = "Hospitals"
                    )
                }

                Spacer(
                    modifier = Modifier.height(32.dp)
                )

                Button(
                    onClick = {
                        onStartClick()
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),

                    shape = RoundedCornerShape(
                        18.dp
                    ),

                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor =
                                Color(0xFF0077D9)
                        )
                ) {

                    Text(
                        text = "Start Diagnosis",

                        color = Color.White,

                        fontSize = 18.sp,

                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun FeatureItem(
    icon: ImageVector,
    title: String
) {

    Column(
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = icon,

            contentDescription = null,

            tint = Color(0xFF8E24AA),

            modifier = Modifier.size(34.dp)
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = title,

            fontSize = 13.sp,

            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun AppLogo() {

    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(Color(0xFFE8F0FF)),

        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector =
                Icons.Default.Favorite,

            contentDescription = null,

            tint = Color(0xFF0077D9),

            modifier = Modifier.size(56.dp)
        )
    }
}