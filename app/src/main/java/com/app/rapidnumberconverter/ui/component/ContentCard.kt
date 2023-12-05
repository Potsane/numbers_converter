package com.app.rapidnumberconverter.ui.component

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.common.ContentCardItem
import com.app.rapidnumberconverter.common.ContentCardItemAction
import com.app.rapidnumberconverter.common.ContentCardItemActionType
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentCard(
    cardItem: ContentCardItem,
    isCollapsibleCard: Boolean = false,
    onCardItemClick: (ContentCardItem) -> Unit = {}
) {

    var collapsed by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        modifier = Modifier.background(Color.Red),
        onClick = { onCardItemClick(cardItem) },
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.dp_one_eighth)),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.dp_half))
        ) {

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {

                Text(
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.dp_standard),
                            top = dimensionResource(R.dimen.dp_standard)
                        )
                        .fillMaxWidth(0.9f),
                    text = cardItem.title,
                    style = MaterialTheme.typography.titleMedium
                )

                if (isCollapsibleCard) {
                    IconButton(onClick = { collapsed = !collapsed }) {
                        val iconId = if (collapsed) painterResource(R.drawable.ic_arrow_up)
                        else painterResource(R.drawable.ic_arrow_down)
                        Icon(
                            painter = iconId,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            if ((isCollapsibleCard && collapsed) || !isCollapsibleCard) {
                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(R.dimen.dp_standard),
                            vertical = dimensionResource(R.dimen.dp_half)
                        )
                        .fillMaxWidth(),
                    text = cardItem.description,
                )
            }

            Button(
                onClick = { onCardItemClick(cardItem) },
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(start = dimensionResource(R.dimen.dp_half))
            ) {
                Text(
                    text = cardItem.action.name,
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
        ContentCard(
            cardItem = ContentCardItem(
                title = "title",
                description = "description",
                action = ContentCardItemAction(
                    name = " got it",
                    type = ContentCardItemActionType.REDIRECT
                )
            )
        )
    }
}

@Preview
@Composable
private fun CollapsibleCardPreview() {
    NumbersConverterAppTheme {
        ContentCard(
            isCollapsibleCard = true,
            cardItem = ContentCardItem(
                title = "title",
                description = "description",
                action = ContentCardItemAction(
                    name = " got it",
                    type = ContentCardItemActionType.REDIRECT
                )
            )
        )
    }
}