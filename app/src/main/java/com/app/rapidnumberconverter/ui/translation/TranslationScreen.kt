package com.app.rapidnumberconverter.ui.translation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.rapidnumberconverter.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TranslationScreen(
    viewModel: TranslationViewModel,
) {

    var translationText by remember { mutableStateOf("") }
    var isDropDownMenuShown by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Row(
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.dp_one_and_half)
            ),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            val iconId = painterResource(R.drawable.ic_arrow_down)
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = stringResource(R.string.translation_direction_picker_title),
                style = MaterialTheme.typography.titleLarge
            )
            Icon(
                modifier = Modifier.clickable {
                    isDropDownMenuShown = !isDropDownMenuShown
                },
                painter = iconId,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )

            DropdownMenu(
                modifier = Modifier.padding(horizontal = 24.dp),
                expanded = isDropDownMenuShown,
                onDismissRequest = { isDropDownMenuShown = false }
            ) {
                viewModel.directions.forEach {
                    DropdownMenuItem(
                        text = { Text(it) },
                        onClick = {
                            viewModel.onMenuItemClick(it)
                            isDropDownMenuShown = false
                        }
                    )
                }
            }
        }

        Text(
            text = viewModel.translationDirection.collectAsState().value,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.dp_half)),
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(R.dimen.dp_one_and_half),
                    horizontal = dimensionResource(R.dimen.dp_standard),
                )
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.primary
            ),

            /*colors = TextFieldDefaults.DecorationBox (
            colors = TextFieldColors(

            )
            //focusedBorderColor = MaterialTheme.colorScheme.primary,
            //unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        ),*/
            value = translationText,
            onValueChange = { translationText = it },
            label = { Text(text = stringResource(R.string.hint_translation_source)) },
        )

        Button(
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.dp_standard))
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            onClick = { viewModel.onTranslate(translationText) },
        ) {
            Text(
                color = Color.White,
                text = stringResource(R.string.button_translate)
            )
        }
    }
}