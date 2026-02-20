package com.example.myapplication.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextButton

@Composable
fun CreateAccountScreen(
    onBack: () -> Unit,
    onCreateAccount: (name: String, email: String, password: String) -> Unit,
    onGoToLogin: () -> Unit
) {
    val bg = Color(0xFFFDF7F2)
    val teal = Color(0xFF1FA6A3)
    val textDark = Color(0xFF1F2A37)
    val muted = Color(0xFF6B7280)
    val stroke = Color(0xFFF1E7E0)
    val fieldBg = Color(0xFFFFF3ED)

    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passState = remember { mutableStateOf("") }
    val confirmState = remember { mutableStateOf("") }
    val agreeState = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
                .background(Color.White)
                .border(1.dp, stroke)
                .padding(horizontal = 18.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            OutlinedButton(
                onClick = onBack,
                shape = RoundedCornerShape(14.dp),
                border = BorderStroke(1.dp, Color(0xFFF4D9C8)),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFFFF7F2)),
                modifier = Modifier.height(40.dp)
            ) {
                Text("←", fontSize = 16.sp, fontWeight = FontWeight.Black, color = textDark)
            }

            Text(
                text = "Create account",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 64.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                color = textDark
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 110.dp)
                .padding(horizontal = 18.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Let's set you up",
                fontSize = 26.sp,
                fontWeight = FontWeight.Black,
                color = textDark
            )
            Text(
                text = "Start your family check-ins in minutes.",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = muted
            )

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

                Text("Email", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                TextField(
                    value = emailState.value,
                    onValueChange = { emailState.value = it },
                    placeholder = { Text("name@email.com", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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

                Text("Password", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                TextField(
                    value = passState.value,
                    onValueChange = { passState.value = it },
                    placeholder = { Text("At least 8 characters", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF)) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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

                Text("Confirm password", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                TextField(
                    value = confirmState.value,
                    onValueChange = { confirmState.value = it },
                    placeholder = { Text("••••••••", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF)) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = agreeState.value,
                        onCheckedChange = { agreeState.value = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = teal,
                            uncheckedColor = Color(0xFFCBD5E1),
                            checkmarkColor = Color.White
                        )
                    )
                    Text(
                        text = "I agree to Terms & Privacy Policy",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = muted
                    )
                }

                Button(
                    onClick = { onCreateAccount(nameState.value.trim(), emailState.value.trim(), passState.value) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = teal),
                    shape = RoundedCornerShape(22.dp),
                    enabled = agreeState.value
                ) {
                    Text("Create account", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                }
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = "Already have an account?",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = muted
            )
            Text(
                text = "Log in",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, bottom = 18.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = teal
            )
            // clickable later; for now you can turn this into a TextButton if you want:
            // but keeping it simple: call onGoToLogin when you’re ready
        }
    }
}