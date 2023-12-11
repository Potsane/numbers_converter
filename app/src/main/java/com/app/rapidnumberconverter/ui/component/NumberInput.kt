package com.app.rapidnumberconverter.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.app.rapidnumberconverter.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberInput(
    modifier: Modifier,
    onCopyText: (String) -> Unit,
    onPasteText: () -> String,
    onSubmit: (String) -> Unit
) {

    var conversionValue by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {

        Card(
            modifier = modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            shape = MaterialTheme.shapes.small,
            elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.dp_one_eighth)),
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.padding(vertical = dimensionResource(R.dimen.dp_half))
            ) {

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.dp_standard)),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.primary
                    ),
                    value = conversionValue,
                    placeholder = { Text(text = "0.0") },
                    onValueChange = { conversionValue = it },
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = { conversionValue = "" },
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = MaterialTheme.colorScheme.primary
                        ),
                        contentPadding = PaddingValues(horizontal = dimensionResource(R.dimen.dp_standard))
                    ) {
                        Text(
                            text = stringResource(R.string.button_clear),
                            textAlign = TextAlign.Start
                        )
                    }

                    Button(
                        onClick = { onCopyText(conversionValue) },
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = MaterialTheme.colorScheme.primary
                        ),
                        contentPadding = PaddingValues(horizontal = dimensionResource(R.dimen.dp_standard))
                    ) {
                        Text(
                            text = stringResource(R.string.button_copy),
                            textAlign = TextAlign.Start
                        )
                    }

                    Button(
                        onClick = { conversionValue = onPasteText() },
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = MaterialTheme.colorScheme.primary
                        ),
                        contentPadding = PaddingValues(horizontal = dimensionResource(R.dimen.dp_standard))
                    ) {
                        Text(
                            text = stringResource(R.string.button_paste),
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }
        }

        Button(
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.dp_standard))
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            onClick = { onSubmit(conversionValue) },
        ) {
            Text(
                color = Color.White,
                text = stringResource(R.string.button_convert)
            )
        }
    }
}
