package com.example.myapplication.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.component.ProgressBar

@Composable
fun SetupScreen3(
    onBack: () -> Unit,
    onNext: () -> Unit
) {
    val bg = Color(0xFFFDF7F2)
    val teal = Color(0xFF1FA6A3)
    val textDark = Color(0xFF1F2A37)
    val muted = Color(0xFF6B7280)
    val stroke = Color(0xFFF1E7E0)
    val fieldBg = Color(0xFFFFF3ED)

    val homeName = remember { mutableStateOf("") }
    val onlyMe = remember { mutableStateOf(true) }

    Surface(modifier = Modifier.fillMaxSize(), color = bg) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
                .padding(top = 24.dp, bottom = 18.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Set up your account", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = textDark)
                Text("3/4", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = muted)
            }

            Spacer(Modifier.height(12.dp))
            ProgressBar(progress = 0.75f, color = teal)

            Spacer(Modifier.height(16.dp))

            Text("Create your Home", fontSize = 26.sp, fontWeight = FontWeight.Black, color = textDark)
            Text("A shared space for your family (you can invite others later).", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = muted)

            Spacer(Modifier.height(18.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(26.dp))
                    .border(1.dp, stroke, RoundedCornerShape(26.dp))
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Home name", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                TextField(
                    value = homeName.value,
                    onValueChange = { homeName.value = it },
                    placeholder = { Text("e.g., Family", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = fieldBg,
                        unfocusedContainerColor = fieldBg,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = teal
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Text("Who can see it?", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)

                SelectRow(
                    selected = onlyMe.value,
                    title = "Only me for now",
                    trailing = "Recommended",
                    selectedColor = teal,
                    onClick = { onlyMe.value = true }
                )

                SelectRow(
                    selected = !onlyMe.value,
                    title = "I'll invite family (Pro)",
                    trailing = "PRO",
                    selectedColor = Color(0xFFC2410C),
                    onClick = { onlyMe.value = false }
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFF1E8), RoundedCornerShape(18.dp))
                        .border(1.dp, Color(0xFFF4D9C8), RoundedCornerShape(18.dp))
                        .padding(14.dp)
                ) {
                    Text("Later you can invite your family", fontSize = 13.sp, fontWeight = FontWeight.Black, color = Color(0xFF9A3412))
                    Spacer(Modifier.height(6.dp))
                    Text("So you both see the same check-ins & trends.", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9A3412))
                }
            }

            Spacer(Modifier.weight(1f))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
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
                    onClick = onNext,
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

@Composable
private fun SelectRow(
    selected: Boolean,
    title: String,
    trailing: String,
    selectedColor: Color,
    onClick: () -> Unit
) {
    val stroke = if (selected) Color(0xFFBFEFEA) else Color(0xFFF1E7E0)
    val bg = if (selected) Color(0xFFE8FBFA) else Color.White
    val textDark = Color(0xFF1F2A37)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(bg, RoundedCornerShape(18.dp))
            .border(1.dp, stroke, RoundedCornerShape(18.dp))
            .padding(horizontal = 14.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, fontSize = 13.sp, fontWeight = FontWeight.Black, color = textDark)
        Text(trailing, fontSize = 11.sp, fontWeight = FontWeight.Black, color = selectedColor)
    }
}