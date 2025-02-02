package com.kodekita.codelabs.ui.view.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kodekita.codelabs.R
import com.kodekita.codelabs.ui.theme.primaryLight
import com.kodekita.codelabs.ui.view.component.TermsAndConditionsText

@Composable
fun LoginScreen(
    navController: NavController? = null,
    onForgotPasswordClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Custom background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            // Back icon
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = null,
                tint = primaryLight,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .size(20.dp)
                    .clickable {
                        navController?.popBackStack()
                    },
            )

            // Logo centered horizontally
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Kinara Kitchen Logo",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .size(width = 120.dp, height = 50.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Title
            Text(
                text = "Login",
                color = primaryLight,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Instruction text
            Text(
                text = "Silakan login dengan No. Handphone yang terdaftar",
                color = primaryLight,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(32.dp))

//            // Phone Number Input Field
//            CustomOutlinedTextField(
//                value = phoneNumber,
//                onValueChange = { phoneNumber = it },
//                label = "No. Handphone",
//                keyboardType = KeyboardType.Phone
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Password Input Field with Visibility Toggle
//            CustomOutlinedTextField(
//                value = password,
//                onValueChange = { password = it },
//                label = "Password",
//                isPasswordField = true,
//                passwordVisible = passwordVisible,
//                onPasswordToggleClick = { passwordVisible = !passwordVisible }
//            )

            Spacer(modifier = Modifier.height(8.dp))

            // Forgot Password
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Daftar akun baru",
                    color = primaryLight,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable {
                        navController?.navigate("register_choose_screen")
                    }
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Lupa Password?",
                    color = primaryLight,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable {
                        onForgotPasswordClick()
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

//            errorMessage?.let {
//                Text(text = it, color = Color.Red)
//            }
//
//            // Handle login success
//            if (loginSuccess == true) {
//                viewModel.resetLoginStatus()
//                navController?.navigate("otp_validation_screen/${token}/login/${phoneNumber}/${token}")
//            }

            // Login Button
            Button(
                onClick = {
//                    viewModel.loginUser(phoneNumber, password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryLight),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Login", color = Color.White, fontWeight = FontWeight.Bold)
            }

            // Terms and Conditions Text
            TermsAndConditionsText(
                navController = navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
            )
        }

        // Loading overlay
//        if (loading) {
//            Loading()
//        }
    }
}
