package com.kodekita.codelabs.ui.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodekita.codelabs.ui.theme.neutral70
import com.kodekita.codelabs.ui.theme.primaryLight
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordField: Boolean = false,
    passwordVisible: Boolean = false,
    trailingIcon: (@Composable () -> Unit)? = null,
    onPasswordToggleClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    enable: Boolean = true,
    readOnly: Boolean = false,
    onClick: (() -> Unit)? = null // New parameter for click action when readOnly
) {
    Box(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            enabled = enable,
            readOnly = readOnly,
            onValueChange = onValueChange,
            label = { Text(text = label, color = neutral70) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = if (isPasswordField && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            trailingIcon = if (isPasswordField) {
                {
                    val icon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { onPasswordToggleClick?.invoke() }) {
                        Icon(imageVector = icon, contentDescription = "Toggle Password Visibility", tint = primaryLight)
                    }
                }
            } else trailingIcon,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = primaryLight,
                focusedBorderColor = primaryLight,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black,
                cursorColor = primaryLight,
            )
        )

        if (readOnly && onClick != null) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable(onClick = onClick)
            )
        }
    }
}



@Preview(showBackground = false)
@Composable
fun PreviewCustomOutlinedTextField() {
    Column {
        // Example usage for a normal text field
        CustomOutlinedTextField(
            value = "John Doe",
            onValueChange = {},
            label = "Nama Lengkap"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Example usage for a password field
        CustomOutlinedTextField(
            value = "password123",
            onValueChange = {},
            label = "Password",
            isPasswordField = true,
            passwordVisible = false,
            onPasswordToggleClick = { /* Toggle password visibility */ }
        )
    }
}
