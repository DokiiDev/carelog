package com.example.myapplication.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.component.AppLogo
import com.example.myapplication.ui.component.Chip
import com.example.myapplication.ui.component.IllustrationCard

@Composable
fun WelcomeScreen(
    onLogin: () -> Unit,
    onCreateAccount: () -> Unit
) {
    val teal = Color(0xFF1FA6A3)
    val textDark = Color(0xFF1F2A37)
    val muted = Color(0xFF6B7280)
    val cardStroke = Color(0xFFF1E7E0)

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFDF7F2)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp)
                .padding(top = 64.dp, bottom = 28.dp),
            horizontalAlignment = Alignment.Start
        ) {
            AppLogo()

            Spacer(Modifier.height(18.dp))

            Text(
                text = "CareLog",
                fontSize = 34.sp,
                fontWeight = FontWeight.Black,
                color = textDark
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "A simple daily check-in for your loved ones.",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = muted
            )

            Spacer(Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Chip(
                    text = "BP & sugar",
                    bg = Color(0xFFE8FBFA),
                    stroke = Color(0xFFBFEFEA),
                    fg = Color(0xFF0F766E)
                )
                Chip(
                    text = "Mood",
                    bg = Color(0xFFFFF1E8),
                    stroke = Color(0xFFF4D9C8),
                    fg = Color(0xFF9A3412)
                )
                Chip(
                    text = "Sleep",
                    bg = Color(0xFFF4FBFF),
                    stroke = Color(0xFFD6F0FF),
                    fg = Color(0xFF0369A1)
                )
            }

            Spacer(Modifier.height(16.dp))

            IllustrationCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Spacer(Modifier.weight(1f))

            Button(
                onClick = onLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                colors = ButtonDefaults.buttonColors(containerColor = teal),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(22.dp)
            ) {
                Text(
                    text = "Log in",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
            }

            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                onClick = onCreateAccount,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(22.dp),
                border = BorderStroke(1.dp, cardStroke),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Create account",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = textDark
                )
            }

            Spacer(Modifier.height(18.dp))

            Text(
                text = "Private by design • made for families",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF9CA3AF)
            )
        }
    }
}
