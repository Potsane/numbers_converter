package com.app.rapidnumberconverter.ui.learn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.common.ContentCardItem
import com.app.rapidnumberconverter.ui.component.ContentCard

@Composable
fun LearnScreen(
    learnItems: List<ContentCardItem>,
    onCardClick: (ContentCardItem) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.dp_one_and_half),
                bottom =  dimensionResource(R.dimen.dp_standard),
            ),
            text = stringResource(R.string.title_learn_articles),
            style = MaterialTheme.typography.titleLarge
        )

        LazyColumn {
            items(learnItems) {
                Column(
                    modifier = Modifier
                        .padding(
                            vertical = dimensionResource(R.dimen.dp_half),
                            horizontal = dimensionResource(R.dimen.dp_standard)
                        )
                ) {
                    ContentCard(
                        cardItem = it,
                        isCollapsibleCard = true
                    ) { onCardClick(it) }
                }
            }
        }
    }
}