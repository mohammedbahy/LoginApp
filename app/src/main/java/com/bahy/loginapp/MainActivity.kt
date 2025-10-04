package com.bahy.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bahy.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginDesign(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginDesign(modifier: Modifier = Modifier) {
    var emailText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Google Logo
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Google Logo",
            modifier = Modifier
                .size(48.dp)
                .padding(top = 24.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Sign in Title
        Text(
            text = "Sign in",
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF202124)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Subtitle
        Text(
            text = "Use your Google Account",
            fontSize = 16.sp,
            color = Color(0xFF5F6368)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Email or phone TextField
        OutlinedTextField(
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text("Email or phone") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF1A73E8),
                unfocusedBorderColor = Color(0xFFDADCE0),
                focusedLabelColor = Color(0xFF1A73E8),
                unfocusedLabelColor = Color(0xFF5F6368)
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot email link
        Text(
            text = "Forgot email?",
            color = Color(0xFF1A73E8),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.clickable { /* Handle click */ }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Info text
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF5F6368))) {
                    append("Not your computer? Use Private Browsing windows to sign in. ")
                }
                withStyle(style = SpanStyle(color = Color(0xFF1A73E8))) {
                    append("Learn more about using Guest mode")
                }
            },
            fontSize = 14.sp,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Row with Create account and Next
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Create account link
            Text(
                text = "Create account",
                color = Color(0xFF1A73E8),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { /* Handle click */ }
            )

            // Next Button
            Button(
                onClick = { /* Handle click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A73E8)
                ),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.height(36.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
private fun GreetingPreview() {
    LoginAppTheme {
        LoginDesign()
    }
}