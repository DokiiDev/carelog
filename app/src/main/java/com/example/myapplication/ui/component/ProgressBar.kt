package com.example.myapplication.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressBar(progress: Float, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(Color(0xFFF3F4F6), RoundedCornerShape(999.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress.coerceIn(0f, 1f))
                .height(10.dp)
                .background(color, RoundedCornerShape(999.dp))
        )
    }
}