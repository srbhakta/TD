package com.example.td

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.td.remote.Card
import com.example.td.remote.CardDetail
import dev.chrisbanes.accompanist.coil.CoilImage as CoilImage

@Composable
fun HomeScreen(
    cards: List<CardDetail>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        style = TextStyle(
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                },
                backgroundColor = Color.White
            )
        },
        bodyContent = {
            LazyColumnFor(items = cards) { cardDetail ->
                Card(Modifier.fillMaxWidth().padding(8.dp),
                    elevation = 4.dp,
                    shape = RoundedCornerShape(3.dp))
                {
                    when (cardDetail.card_type) {
                        "text" -> TextCard(cardDetail.card)
                        "title_description" -> TitleDescriptionCard(card = cardDetail.card)
                        "image_title_description" -> ImageTitleDescriptionCard(card = cardDetail.card)
                    }
                }

            }
        }
    )
}

@Composable
fun TextCard(card: Card) {
    Column(modifier = Modifier.padding(8.dp)) {
        val value = card.value!!
        val textColor = card.attributes?.text_color!!
        val fontSize = card.attributes.font.size
        Text(
            value,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit.Companion.Sp(fontSize),
                color = Color(textColor.toColorInt())
            )
        )
    }
}

@Composable
fun TitleDescriptionCard(card: Card) {
    Column(modifier = Modifier.padding(8.dp)) {
        card.title?.let {
            Text(
                it.value,
                style = TextStyle(
                    fontSize = TextUnit.Companion.Sp(it.attributes.font.size),
                    color = Color(it.attributes.text_color.toColorInt())
                )
            )
        }
        card.description?.let {
            Text(
                it.value,
                style = TextStyle(
                    fontSize = TextUnit.Companion.Sp(it.attributes.font.size),
                    color = Color(it.attributes.text_color.toColorInt())
                )
            )
        }
    }
}

@Composable
fun ImageTitleDescriptionCard(card: Card) {
    val url = card.image?.url!!
    Box(contentAlignment = Alignment.BottomStart) {
        CoilImage(data = url)
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.Bottom){
            Column {
                card.title?.let {
                    Text(
                        it.value,
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(it.attributes.font.size),
                            color = Color(it.attributes.text_color.toColorInt())
                        )
                    )
                }
                card.description?.let {
                    Text(
                        it.value,
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(it.attributes.font.size),
                            color = Color(it.attributes.text_color.toColorInt())
                        )
                    )
                }
            }
        }
    }
}