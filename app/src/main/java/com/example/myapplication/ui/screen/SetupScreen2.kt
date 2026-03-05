package com.example.myapplication.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.component.ProgressBar

@Composable
fun SetupScreen2(
    onBack: () -> Unit,
    onNext: () -> Unit
) {
    val bg = Color(0xFFFDF7F2)
    val teal = Color(0xFF1FA6A3)
    val textDark = Color(0xFF1F2A37)
    val muted = Color(0xFF6B7280)
    val stroke = Color(0xFFF1E7E0)

    val selected = remember { mutableStateOf(UseCase.CAREGIVER) } // default selected like your screenshot

    Surface(modifier = Modifier.fillMaxSize(), color = bg) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
                .padding(top = 24.dp, bottom = 18.dp)
        ) {
            // Header row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Set up your account", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = textDark)
                Text("2/4", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = muted)
            }

            Spacer(Modifier.height(12.dp))
            ProgressBar(progress = 0.50f, color = teal)

            Spacer(Modifier.height(16.dp))

            Text("How will you use CareLog?", fontSize = 24.sp, fontWeight = FontWeight.Black, color = textDark)
            Text(
                "This helps us set the right screens.",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = muted
            )

            Spacer(Modifier.height(18.dp))

            // Option 1 (selected in screenshot)
            UseCaseCard(
                title = "I take care of someone",
                subtitle = "Log check-ins for Mom/Dad\nand track patterns.",
                iconBg = Color(0xFFE8FBFA),
                iconText = "∿",
                cardBg = Color(0xFFEFFFF0),
                borderColor = if (selected.value == UseCase.CAREGIVER) teal else stroke,
                selected = selected.value == UseCase.CAREGIVER,
                onClick = { selected.value = UseCase.CAREGIVER },
                teal = teal
            )

            Spacer(Modifier.height(12.dp))

            // Option 2
            UseCaseCard(
                title = "I track myself",
                subtitle = "A simple daily check-in for your own\nroutine.",
                iconBg = Color(0xFFFFE9E1),
                iconText = "☺",
                cardBg = Color(0xFFFFF2EE),
                borderColor = if (selected.value == UseCase.SELF) teal else stroke,
                selected = selected.value == UseCase.SELF,
                onClick = { selected.value = UseCase.SELF },
                teal = teal
            )

            Spacer(Modifier.height(14.dp))

            // Tip box
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFEFF4FF), RoundedCornerShape(18.dp))
                    .border(1.dp, Color(0xFFD7E2FF), RoundedCornerShape(18.dp))
                    .padding(14.dp)
            ) {
                Text(
                    "You can change this later",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF1D4ED8)
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    "No stress — it just sets a default flow.",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1D4ED8)
                )
            }

            Spacer(Modifier.weight(1f))

            // Bottom buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier.weight(1f).height(56.dp),
                    shape = RoundedCornerShape(22.dp),
                    border = BorderStroke(1.dp, stroke),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
                ) {
                    Text("Back", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                }

                Button(
                    onClick = {
                        // If later you want to save selection, do it here before onNext()
                        onNext()
                    },
                    modifier = Modifier.weight(1f).height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = teal),
                    shape = RoundedCornerShape(22.dp)
                ) {
                    Text("Next", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                }
            }
        }
    }
}

private enum class UseCase { CAREGIVER, SELF }

@Composable
private fun UseCaseCard(
    title: String,
    subtitle: String,
    iconBg: Color,
    iconText: String,
    cardBg: Color,
    borderColor: Color,
    selected: Boolean,
    onClick: () -> Unit,
    teal: Color
) {
    val shape = RoundedCornerShape(22.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(cardBg, shape)
            .border(2.dp, borderColor, shape)
            .clickable { onClick() }
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .background(iconBg, RoundedCornerShape(14.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(iconText, fontSize = 18.sp, fontWeight = FontWeight.Black, color = teal)
        }

        Spacer(Modifier.size(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontSize = 13.sp, fontWeight = FontWeight.Black, color = Color(0xFF0F172A))
            Spacer(Modifier.height(4.dp))
            Text(subtitle, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF475569))
        }

        // Radio indicator
        Box(
            modifier = Modifier
                .size(22.dp)
                .background(Color.White, RoundedCornerShape(999.dp))
                .border(2.dp, if (selected) teal else Color(0xFFCBD5E1), RoundedCornerShape(999.dp)),
            contentAlignment = Alignment.Center
        ) {
            if (selected) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(teal, RoundedCornerShape(999.dp))
                )
            }
        }
    }
}