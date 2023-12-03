package com.app.rapidnumberconverter.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.common.AboutCardItem
import com.app.rapidnumberconverter.common.AboutCardItemType
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme

@Composable
fun AboutCard(cardItem: AboutCardItem) {

    Card(
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.dp_one_eighth)),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.dp_half))
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(R.dimen.dp_standard),
                        top = dimensionResource(R.dimen.dp_standard)
                    )
                    .fillMaxWidth(),
                text = cardItem.title,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.dp_standard),
                        vertical = dimensionResource(R.dimen.dp_half)
                    )
                    .fillMaxWidth(),
                text = cardItem.description,
            )

            Button(
                onClick = {},
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(start = dimensionResource(R.dimen.dp_half))
            ) {
                Text(
                    text = cardItem.primaryButton,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardPreview() {
    NumbersConverterAppTheme {
        AboutCard(
            cardItem = AboutCardItem(
                title = "title",
                description = "description",
                primaryButton = "got it",
                type = AboutCardItemType.SHARE_APP
            )
        )
    }
}