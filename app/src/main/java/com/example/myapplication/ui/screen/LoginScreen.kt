package com.example.myapplication.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row

@Composable
fun LoginScreen(
    onBack: () -> Unit,
    onLogin: (email: String, password: String) -> Unit,
    onCreateAccount: () -> Unit
) {
    val bg = Color(0xFFFDF7F2)
    val teal = Color(0xFF1FA6A3)
    val textDark = Color(0xFF1F2A37)
    val muted = Color(0xFF6B7280)
    val stroke = Color(0xFFF1E7E0)
    val fieldBg = Color(0xFFFFF3ED)

    val emailState = remember { mutableStateOf("") }
    val passState = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
    ) {
        // header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
                .background(Color.White)
                .border(width = 1.dp, color = stroke)
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
                text = "Log in",
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
                text = "Welcome back",
                fontSize = 26.sp,
                fontWeight = FontWeight.Black,
                color = textDark
            )
            Text(
                text = "Pick up where you left off.",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = muted
            )

            Spacer(Modifier.height(18.dp))

            // card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(26.dp))
                    .background(Color.White)
                    .border(1.dp, stroke, RoundedCornerShape(26.dp))
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text("Email", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = textDark)

                TextField(
                    value = emailState.value,
                    onValueChange = { emailState.value = it },
                    placeholder = {
                        Text("name@email.com", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF))
                    },
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
                    placeholder = {
                        Text("••••••••", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF9CA3AF))
                    },
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

                Text(
                    text = "Forgot password?",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = teal
                )

                Button(
                    onClick = { onLogin(emailState.value.trim(), passState.value) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = teal),
                    shape = RoundedCornerShape(22.dp)
                ) {
                    Text("Log in", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(modifier = Modifier.weight(1f), color = stroke)
                    Text(
                        text = "  OR  ",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF9CA3AF)
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f), color = stroke)
                }

                OutlinedButton(
                    onClick = onCreateAccount,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(22.dp),
                    border = BorderStroke(1.dp, stroke),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
                ) {
                    Text("Create account", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                }
            }

            Spacer(Modifier.weight(1f))

            Text(
                text = "Private family check-ins",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 18.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF9CA3AF)
            )
        }
    }
}