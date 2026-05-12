package com.prathvik.arogyanidhi.ui.screens.chatbot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prathvik.arogyanidhi.data.remote.GeminiService
import com.prathvik.arogyanidhi.domain.model.ChatMessage
import com.prathvik.arogyanidhi.ui.theme.PrimaryBlue
import kotlinx.coroutines.launch

@Composable
fun ChatbotScreen() {

    var userMessage by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    var messages by remember {

        mutableStateOf(
            listOf(
                ChatMessage(
                    "Hello! Ask your healthcare questions.",
                    false
                )
            )
        )
    }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE3F2FD),
                        Color.White
                    )
                )
            )
            .padding(16.dp)
    ) {

        Text(
            text = "AI Healthcare Chatbot",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryBlue
        )

        Spacer(modifier = Modifier.height(18.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(messages) { message ->

                Row(
                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        if(message.isUser)
                            Arrangement.End
                        else
                            Arrangement.Start
                ) {

                    Card(
                        shape = RoundedCornerShape(20.dp),

                        colors = CardDefaults.cardColors(
                            containerColor =
                                if(message.isUser)
                                    PrimaryBlue
                                else
                                    Color.White
                        ),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),

                        modifier = Modifier
                            .padding(8.dp)
                    ) {

                        Text(
                            text = message.message,

                            modifier = Modifier.padding(14.dp),

                            fontSize = 16.sp,

                            color =
                                if(message.isUser)
                                    Color.White
                                else
                                    Color.Black
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = userMessage,

            onValueChange = {
                userMessage = it
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            placeholder = {
                Text("Ask health question...")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {

                if(userMessage.isNotBlank()) {

                    val currentQuestion = userMessage

                    messages =
                        messages + ChatMessage(
                            currentQuestion,
                            true
                        )

                    userMessage = ""

                    isLoading = true

                    coroutineScope.launch {

                        try {

                            val aiReply =
                                GeminiService.generateChatResponse(
                                    currentQuestion
                                )

                            isLoading = false

                            messages =
                                messages + ChatMessage(
                                    aiReply,
                                    false
                                )

                        } catch (_: Exception) {

                            isLoading = false

                            messages =
                                messages + ChatMessage(
                                    "Unable to generate AI response.",
                                    false
                                )
                        }
                    }
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),

            shape = RoundedCornerShape(18.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryBlue
            )
        ) {

            if(isLoading) {

                CircularProgressIndicator(
                    color = Color.White
                )

            } else {

                Text(
                    text = "Send",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}