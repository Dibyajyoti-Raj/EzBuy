package com.ITW.ezbuy.mainPage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ITW.ezbuy.Profile.ProfilePage
import com.ITW.ezbuy.R
import com.ITW.ezbuy.ui.theme.EzBuyTheme

@Composable
fun MainPage1(navController: NavController)
{
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.shopping),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "Background Image",
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(
                        "Fashion Sale", Modifier.padding(8.dp),
                        textAlign = TextAlign.Left, fontWeight = FontWeight.Bold, fontSize = (36.sp)
                    )
                    Button(onClick = { /*TODO*/ }, Modifier.padding(12.dp)) {
                        Text(text = "CHECK")
                    }
                }
            }
        }

    Spacer(modifier = Modifier.height(300.dp))

        BottomAppBar(
            containerColor = colorResource(id = R.color.Col2)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.Col2)),
                horizontalArrangement = Arrangement.SpaceAround) {
                IconButton(
                    onClick = { /* Handle navigation icon click */ }
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }

                IconButton(
                    onClick = { /* Handle navigation icon click */ }
                ) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Search")
                }

                IconButton(
                    onClick = { /* Handle navigation icon click */ }
                ) {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                }

                IconButton(
                    onClick = { /* Handle navigation icon click */ }
                ) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val dummyNavController = rememberNavController()
    EzBuyTheme {
        MainPage1(navController = dummyNavController)
    }
}