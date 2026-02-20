package com.example.myapplication.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.offset

@Composable
fun IllustrationCard(modifier: Modifier = Modifier) {
    val cardStroke = Color(0xFFF1E7E0)
    val cardBg = Color(0xFFFFFBF8)
    val innerStroke = Color(0xFFF4D9C8)
    val teal = Color(0xFF1FA6A3)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(26.dp))
            .background(cardBg)
            .border(1.dp, cardStroke, RoundedCornerShape(26.dp))
            .padding(18.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .width(120.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFFFFF7F2))
                .border(1.dp, innerStroke, RoundedCornerShape(24.dp))
                .padding(14.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                MiniPill(
                    text = "Mom • Today",
                    bg = Color(0xFFE8FBFA),
                    stroke = Color(0xFFBFEFEA),
                    fg = Color(0xFF0F766E)
                )
                MiniRow(label = "BP", value = "128/78", valueColor = teal)
                MiniRow(label = "Mood", value = "Good", valueColor = Color(0xFFF973A1))
            }
        }

        HeartIcon(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 25.dp)
                .offset(x = 80.dp)
                .size(60.dp),
            color = Color(0xFFF973A1)
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(150.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFFE8FBFA))
                .border(1.dp, Color(0xFFBFEFEA), RoundedCornerShape(24.dp))
        ) {
            LineChart(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                color = teal
            )
        }
    }
}

@Composable
private fun MiniPill(text: String, bg: Color, stroke: Color, fg: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(bg)
            .border(1.dp, stroke, RoundedCornerShape(16.dp))
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.ExtraBold,
            color = fg
        )
    }
}

@Composable
private fun MiniRow(label: String, value: String, valueColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFF1E7E0), RoundedCornerShape(16.dp))
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF1F2A37))
        Text(value, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = valueColor)
    }
}

@Composable
private fun HeartIcon(modifier: Modifier, color: Color) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val path = Path().apply {
            moveTo(w * 0.50f, h * 0.78f)
            cubicTo(w * 0.15f, h * 0.55f, w * 0.12f, h * 0.25f, w * 0.33f, h * 0.22f)
            cubicTo(w * 0.45f, h * 0.20f, w * 0.50f, h * 0.32f, w * 0.50f, h * 0.34f)
            cubicTo(w * 0.50f, h * 0.32f, w * 0.55f, h * 0.20f, w * 0.67f, h * 0.22f)
            cubicTo(w * 0.88f, h * 0.25f, w * 0.85f, h * 0.55f, w * 0.50f, h * 0.78f)
            close()
        }
        drawPath(path, color = color, style = Stroke(width = 5f, cap = StrokeCap.Round))
    }
}

@Composable
private fun LineChart(modifier: Modifier, color: Color) {
    Canvas(modifier = modifier) {
        val pts = listOf(
            0.10f to 0.70f,
            0.32f to 0.52f,
            0.52f to 0.62f,
            0.72f to 0.42f,
            0.92f to 0.50f
        )

        val p = Path().apply {
            moveTo(size.width * pts[0].first, size.height * pts[0].second)
            for (i in 1 until pts.size) {
                lineTo(size.width * pts[i].first, size.height * pts[i].second)
            }
        }

        drawPath(p, color = color, style = Stroke(width = 6f, cap = StrokeCap.Round))

        for (pt in pts) {
            drawCircle(
                color = color,
                radius = 7f,
                center = Offset(size.width * pt.first, size.height * pt.second)
            )
        }
    }
}
