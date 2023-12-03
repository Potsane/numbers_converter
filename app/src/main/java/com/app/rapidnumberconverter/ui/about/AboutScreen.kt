package com.app.rapidnumberconverter.ui.about

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
import com.app.rapidnumberconverter.ui.component.AboutCard
import com.app.rapidnumberconverter.utils.aboutItems

@Composable
fun AboutScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.sp_one_and_half)
            ),
            text = stringResource(R.string.about_app_heading),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.dp_half)),
            text = stringResource(R.string.about_app_title)
        )

        LazyColumn {
            items(aboutItems) {
                Column(
                    modifier = Modifier
                        .padding(
                            vertical = dimensionResource(R.dimen.dp_half),
                            horizontal = dimensionResource(R.dimen.dp_standard)
                        )
                ) {
                    AboutCard(cardItem = it)
                }
            }
        }
    }
}