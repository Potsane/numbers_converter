package com.app.rapidnumberconverter.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme

@Composable
fun ConverterDropDown(
    modifier: Modifier = Modifier,
    items: List<String>,
    title: String,
    defaultValue: String,
    onFormatSelected: (String) -> Unit
) {

    var selectedNumberSystem by remember { mutableStateOf(defaultValue) }
    var expanded by remember { mutableStateOf(false) }
    var selectedItemIndex by remember { mutableIntStateOf(items.indexOf(selectedNumberSystem)) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.dp_standard)),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Start
        )

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            val iconId = painterResource(R.drawable.ic_arrow_down)

            Text(
                text = selectedNumberSystem,
                modifier = Modifier.padding(
                    end = dimensionResource(R.dimen.dp_half)
                ),
            )
            Icon(
                modifier = Modifier
                    .clickable {
                        expanded = true
                    },
                painter = iconId,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = item,
                                fontWeight = if (index == selectedItemIndex) FontWeight.Bold else null
                            )
                        },
                        onClick = {
                            selectedItemIndex = index
                            selectedNumberSystem = items[index]
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun ConverterDropDownPreview() {
    NumbersConverterAppTheme {
    }
}