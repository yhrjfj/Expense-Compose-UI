package com.yhr.jfj.expense

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yhr.jfj.expense.data.Finance
import com.yhr.jfj.expense.ui.theme.BlueStart
import com.yhr.jfj.expense.ui.theme.GreenStart
import com.yhr.jfj.expense.ui.theme.OrangeStart
import com.yhr.jfj.expense.ui.theme.PurpleStart

@Preview(showBackground = true)
@Composable
fun FinanceSection(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(financeList.size) {
                FinanceItem(it)
            }
        }
    }
}

// Create list of item
val financeList = listOf(
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransaction",
        backgroundColor = GreenStart
    ),
    Finance(
        icon = Icons.AutoMirrored.Rounded.StarHalf,
        name = "My\nBusiness",
        backgroundColor = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        backgroundColor = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.Money,
        name = "Finance\nAnalytics",
        backgroundColor = PurpleStart
    )
)

// How each finance item will be look like
@Composable
fun FinanceItem(index: Int) {
    val finance = financeList[index]
    val lastItemPaddingEnd = if (index == financeList.size - 1) 16.dp else 0.dp

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .clickable { }
                .size(120.dp)
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.backgroundColor)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}