package com.ITW.ezbuy.Profile

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ITW.ezbuy.R
import com.ITW.ezbuy.ui.theme.EzBuyTheme

@Composable
fun ProfilePage(name: String?, mail: String?, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "My profile", textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth(), color = Color.DarkGray, fontSize = (62.sp)
        )
        Spacer(modifier = Modifier.height(26.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.acc),
                    contentDescription = "profile"
                )
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    Text(text = "$name", modifier = Modifier.padding(4.dp), fontSize = 20.sp)
                    Text(text = "$mail")
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "My Order")
            Text(text = "Already have 12 orders.")
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "right")
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "My Order")
            Text(text = "Already have 12 orders.")
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "right")
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "My Order")
            Text(text = "Already have 12 orders.")
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "right")
        }
//        }

    Spacer(modifier = Modifier.height(300.dp))

        BottomAppBar(
            containerColor = colorResource(id = R.color.Col2),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.Col2)),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
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
        ProfilePage(name = "Dibyajyoti Raj Mohaptra", mail = "Ruxtz 2004", navController = dummyNavController)
    }
}











