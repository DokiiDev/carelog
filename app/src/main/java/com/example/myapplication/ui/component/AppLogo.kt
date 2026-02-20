package com.example.myapplication.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable

@Composable
fun AppLogo(modifier: Modifier = Modifier) {
    val teal = Color(0xFF1FA6A3)

    Box(
        modifier = modifier
            .size(64.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(teal),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(40.dp)) {
            val p = Path().apply {
                moveTo(size.width * 0.08f, size.height * 0.55f)
                lineTo(size.width * 0.30f, size.height * 0.55f)
                lineTo(size.width * 0.40f, size.height * 0.30f)
                lineTo(size.width * 0.55f, size.height * 0.75f)
                lineTo(size.width * 0.65f, size.height * 0.50f)
                lineTo(size.width * 0.92f, size.height * 0.50f)
            }
            drawPath(
                path = p,
                color = Color.White,
                style = Stroke(width = 5f, cap = StrokeCap.Round)
            )
        }
    }
}
