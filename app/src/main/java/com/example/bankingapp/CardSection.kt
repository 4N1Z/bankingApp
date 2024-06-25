package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedapps.bankningappui.ui.theme.BlueEnd
import com.ahmedapps.bankningappui.ui.theme.BlueStart
import com.ahmedapps.bankningappui.ui.theme.GreenEnd
import com.ahmedapps.bankningappui.ui.theme.GreenStart
import com.ahmedapps.bankningappui.ui.theme.OrangeEnd
import com.ahmedapps.bankningappui.ui.theme.OrangeStart
import com.ahmedapps.bankningappui.ui.theme.PurpleEnd
import com.ahmedapps.bankningappui.ui.theme.PurpleStart
import com.example.bankingapp.data.Card


val cardItems = listOf<Card>(

    Card(
        cardType = "AR TREASURE HUNT",
        cardMember = "123 234 456",
        cardName = "Dubai Mall",
        balance = 456.600,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MALL RUSH",
        cardMember = "123 234 456",
        cardName = "LuLu Mall",
        balance = 314,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VR ZONE",
        cardMember = "123 234 456",
        cardName = "Aniz Inc",
        balance = 9998,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "TREASURE HUNT",
        cardMember = "123 234 456",
        cardName = "Aniz Inc",
        balance = 1234,
        color = getGradient(GreenStart, GreenEnd)
    ),
)



fun getGradient(
    startColor:Color,
    endColor : Color
    ):Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )

}

@Preview
@Composable
fun CardSection(){
    LazyRow {
        items(cardItems.size){ index ->
            CardItem(index)

        }

    }

}

@Composable
fun CardItem(index:Int){
    val card = cardItems[index]
    var lastItemPaddingEnd = 0.dp

    if(index == cardItems.size - 1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)

    if(card.cardType == "TREASURE HUNT"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box (
        modifier = Modifier
            .padding(start = 16.dp , end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),

            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter =image ,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "${card.balance} /",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text =" 1M",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            Text(
                text = card.cardMember,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

    }

}