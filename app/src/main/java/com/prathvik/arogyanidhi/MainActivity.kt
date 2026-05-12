package com.prathvik.arogyanidhi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.prathvik.arogyanidhi.ui.navigation.AppNavigation
import com.prathvik.arogyanidhi.ui.theme.ArogyaNidhiTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArogyaNidhiTheme {
                AppNavigation()
            }
        }
    }
}