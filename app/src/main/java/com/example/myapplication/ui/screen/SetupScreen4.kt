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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
fun SetupScreen4(
    onBack: () -> Unit,
    onFinish: () -> Unit
) {
    val bg = Color(0xFFFDF7F2)
    val teal = Color(0xFF1FA6A3)
    val textDark = Color(0xFF1F2A37)
    val muted = Color(0xFF6B7280)
    val stroke = Color(0xFFF1E7E0)
    val fieldBg = Color(0xFFFFF3ED)

    val personName = remember { mutableStateOf("") }
    val relationship = remember { mutableStateOf("Mother") }
    val bpEnabled = remember { mutableStateOf(true) }
    val sugarEnabled = remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize(), color = bg) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
                .padding(top = 24.dp, bottom = 18.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Set up your account", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = textDark)
                Text("4/4", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = muted)
            }

            Spacer(Modifier.height(12.dp))
            ProgressBar(progress = 1f, color = teal)

            Spacer(Modifier.height(16.dp))

            Text("Add your first person", fontSize = 26.sp, fontWeight = FontWeight.Black, color = textDark)
            Text("This is who you'll do daily check-ins for.", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = muted)

            Spacer(Modifier.height(18.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(26.dp))
                    .border(1.dp, stroke, RoundedCornerShape(26.dp))
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Name", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                TextField(
                    value = personName.value,
                    onValueChange = { personName.value = it },
                    placeholder = { Text("e.g., Mom", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF)) },
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

                Text("Relationship", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                TextField(
                    value = relationship.value,
                    onValueChange = { relationship.value = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = teal
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, stroke, RoundedCornerShape(16.dp))
                )

                Text("Modules", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)

                ModuleRow(
                    title = "Blood pressure (recommended)",
                    active = bpEnabled.value,
                    onToggle = { bpEnabled.value = it },
                    accent = teal
                )

                ModuleRow(
                    title = "Blood sugar (optional)",
                    active = sugarEnabled.value,
                    onToggle = { sugarEnabled.value = it },
                    accent = Color(0xFFC2410C)
                )
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
                    onClick = onFinish,
                    modifier = Modifier.weight(1f).height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = teal),
                    shape = RoundedCornerShape(22.dp)
                ) {
                    Text("Finish", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                }
            }
        }
    }
}

@Composable
private fun ModuleRow(
    title: String,
    active: Boolean,
    onToggle: (Boolean) -> Unit,
    accent: Color
) {
    val stroke = Color(0xFFF1E7E0)
    val bg = if (active) Color(0xFFE8FBFA) else Color(0xFFFFF7F2)
    val textDark = Color(0xFF1F2A37)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(bg, RoundedCornerShape(18.dp))
            .border(1.dp, stroke, RoundedCornerShape(18.dp))
            .padding(horizontal = 14.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, fontSize = 12.sp, fontWeight = FontWeight.Black, color = textDark)
        Switch(
            checked = active,
            onCheckedChange = onToggle,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = accent,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = Color(0xFFE5E7EB)
            )
        )
    }
}