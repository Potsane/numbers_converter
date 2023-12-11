package com.app.rapidnumberconverter.ui.converter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.common.ConversionContext
import com.app.rapidnumberconverter.ui.component.ConverterDropDown
import com.app.rapidnumberconverter.ui.component.NumberInput
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme

@Composable
fun ConverterScreen(
    viewModel: ConverterViewModel
) {

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.dp_one_and_half))
                .fillMaxWidth(),
            text = stringResource(R.string.numbers_converter_heading),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        ConverterDropDown(
            title = stringResource(R.string.system_picker_title_from),
            items = viewModel.numberSystems,
            defaultValue = viewModel.fromNumberSystem.value.orEmpty(),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.dp_one_and_half)),
        ) {
            viewModel.onMenuItemClick(it, ConversionContext.CONVERT_FROM)
        }

        ConverterDropDown(
            title = stringResource(R.string.system_picker_title_to),
            items = viewModel.numberSystems,
            defaultValue = viewModel.toNumberSystem.value.orEmpty(),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.dp_one_and_half)),
        ) {
            viewModel.onMenuItemClick(it, ConversionContext.CONVERT_TO)
        }

        NumberInput(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(R.dimen.dp_one_and_half),
                    horizontal = dimensionResource(R.dimen.dp_standard)
                )
        )

        Button(
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.dp_standard))
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            onClick = { },
        ) {
            Text(
                color = Color.White,
                text = stringResource(R.string.button_convert)
            )
        }
    }
}

@Preview
@Composable
private fun ConverterScreenPreview() {
    NumbersConverterAppTheme {
        //ConverterScreen()
    }
}