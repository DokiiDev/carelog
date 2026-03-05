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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.component.ProgressBar


@Composable
fun SetupScreen1(
    onBack: () -> Unit,
    onNext: () -> Unit
) {
    val bg = Color(0xFFFDF7F2)
    val teal = Color(0xFF1FA6A3)
    val textDark = Color(0xFF1F2A37)
    val muted = Color(0xFF6B7280)
    val stroke = Color(0xFFF1E7E0)
    val fieldBg = Color(0xFFFFF3ED)

    val nameState = remember { mutableStateOf("") }
    val ageState = remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize(), color = bg) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
                .padding(top = 24.dp, bottom = 18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Set up your account", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = textDark)
                Text("1/4", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = muted)
            }

            Spacer(Modifier.height(12.dp))

            ProgressBar(progress = 0.25f, color = teal)

            Spacer(Modifier.height(16.dp))

            Text("About you", fontSize = 26.sp, fontWeight = FontWeight.Black, color = textDark)
            Text("So your family knows who logged the check-in.", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = muted)

            Spacer(Modifier.height(18.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(26.dp))
                    .border(1.dp, stroke, RoundedCornerShape(26.dp))
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Your name", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                TextField(
                    value = nameState.value,
                    onValueChange = { nameState.value = it },
                    placeholder = { Text("e.g., Ana", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF)) },
                    singleLine = true,
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

                Text("Age", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                TextField(
                    value = ageState.value,
                    onValueChange = { ageState.value = it.filter { c -> c.isDigit() }.take(3) },
                    placeholder = { Text("e.g., 24", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = fieldBg,
                        unfocusedContainerColor = fieldBg,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = teal
                    ),
                    modifier = Modifier.width(170.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFE8FBFA), RoundedCornerShape(18.dp))
                        .border(1.dp, Color(0xFFBFEFEA), RoundedCornerShape(18.dp))
                        .padding(14.dp)
                ) {
                    Text("Tip", fontSize = 13.sp, fontWeight = FontWeight.Black, color = Color(0xFF0F766E))
                    Spacer(Modifier.height(6.dp))
                    Text(
                        "This is shown inside your “Home” so everyone knows who added entries.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF0F766E)
                    )
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