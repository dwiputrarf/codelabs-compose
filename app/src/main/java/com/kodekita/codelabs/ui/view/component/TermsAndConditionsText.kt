package com.kodekita.codelabs.ui.view.component

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kodekita.codelabs.ui.theme.neutral70

@Composable
fun TermsAndConditionsText(
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    val annotatedText = buildAnnotatedString {
        append("Dengan Masuk atau mendaftar, anda menyetujui ")

        // Add clickable "Syarat Ketentuan"
        pushStringAnnotation(tag = "TERMS", annotation = "terms_condition_screen")
        withStyle(
            style = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        ) {
            append("Syarat Ketentuan")
        }
        pop()

        append(" dan ")

        // Add clickable "Kebijakan Privasi"
        pushStringAnnotation(tag = "PRIVACY_POLICY", annotation = "privacy_policy_screen")
        withStyle(
            style = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        ) {
            append("Kebijakan Privasi")
        }
        pop()

        append(".")
    }

    ClickableText(
        text = annotatedText,
        style = TextStyle(
            color = neutral70,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        ),
        modifier = modifier,
        onClick = { offset ->
            annotatedText.getStringAnnotations(start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    when (annotation.tag) {
                        "TERMS" -> navController?.navigate(annotation.item)
                        "PRIVACY_POLICY" -> navController?.navigate(annotation.item)
                    }
                }
        }
    )
}