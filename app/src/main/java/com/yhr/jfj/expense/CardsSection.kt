package com.yhr.jfj.expense

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yhr.jfj.expense.data.Card
import com.yhr.jfj.expense.ui.theme.BlueEnd
import com.yhr.jfj.expense.ui.theme.BlueStart
import com.yhr.jfj.expense.ui.theme.GreenEnd
import com.yhr.jfj.expense.ui.theme.GreenStart
import com.yhr.jfj.expense.ui.theme.PurpleEnd
import com.yhr.jfj.expense.ui.theme.PurpleStart

val cardItems = listOf(
    Card(
        cardType = "VISA",
        cardName = "Shadow",
        cardNumber = "5454 8465 2335 3784",
        cardBalance = 43453.53,
        cardColor = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardName = "Light",
        cardNumber = "4735 2735 2835 0173",
        cardBalance = 34402.43,
        cardColor = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardName = "YHRJFJ",
        cardNumber = "8365 2853 0275 2965",
        cardBalance = 84654.84,
        cardColor = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardName = "Demo",
        cardNumber = "0745 1278 2926 1985",
        cardBalance = 3.12,
        cardColor = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

// Main section
@Preview(showSystemUi = true)
@Composable
fun CardsSection(modifier: Modifier = Modifier) {
    LazyRow {
        items(cardItems.size) {
            CardItem(index = it)
        }
    }
}

@Composable
fun CardItem(modifier: Modifier = Modifier, index: Int) {
    val card = cardItems[index]

    // Check if it is last item or not and give padding
    var lastItemPaddingEnd = if (index == cardItems.size - 1) 16.dp else 0.dp

    // Add image according to the card type
    var image =
        if (card.cardType == "VISA") painterResource(id = R.drawable.ic_visa) else painterResource(
            id = R.drawable.ic_mastercard
        )

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.cardColor)
                .width(250.dp)
                .height(170.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.width(70.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Card name
            Text(
                text = card.cardName,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Card balance
            Text(
                text = "$ ${card.cardBalance}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Card number
            Text(
                text = card.cardNumber,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}




















