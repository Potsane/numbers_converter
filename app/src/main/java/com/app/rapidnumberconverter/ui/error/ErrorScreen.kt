package com.app.rapidnumberconverter.ui.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme

@Composable
fun ErrorScreen(
    onTryAgain: () -> Unit,
    onGotIt: () -> Unit
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.vlc_error))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        LottieAnimation(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.dp_one_and_half))
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )

        Text(
            modifier = Modifier.padding(
                vertical = dimensionResource(R.dimen.dp_one_and_half),
                horizontal = dimensionResource(R.dimen.dp_standard)
            ),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.generic_error_message),
            style = MaterialTheme.typography.titleLarge
        )

        Button(
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.dp_standard))
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            onClick = { onTryAgain() },
        ) {
            Text(
                color = Color.White,
                text = stringResource(R.string.button_try_again)
            )
        }

        OutlinedButton(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.dp_standard))
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            onClick = { onGotIt() }
        ) {
            Text(
                color = MaterialTheme.colorScheme.primary,
                text = stringResource(R.string.button_got_it)
            )
        }
    }
}

@Preview
@Composable
private fun CollapsibleCardPreview() {
    NumbersConverterAppTheme {
        ErrorScreen({}) {}
    }
}