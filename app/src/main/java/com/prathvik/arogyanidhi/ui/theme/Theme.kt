package com.prathvik.arogyanidhi.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AppColors = lightColorScheme(
    primary = PrimaryBlue
)

@Composable
fun ArogyaNidhiTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = AppColors,
        content = content
    )
}