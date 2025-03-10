package com.ITW.ezbuy.Bag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ITW.ezbuy.R
import com.ITW.ezbuy.ui.theme.EzBuyTheme

@Composable
fun BagPage(navController: NavController){
    var code by  remember { mutableStateOf("Enter your promo code    ") }
    var total by  remember { mutableStateOf(178.2) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp)) {
        Text(
            text = "My Bag",
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            fontSize = 42.sp
        )

        Spacer(modifier = Modifier.height(26.dp))

        AllProducts()
        
        Spacer(modifier = Modifier.height(12.dp))
        TextField(value = code, onValueChange = {code = it}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Total Amount :  $total$", modifier = Modifier.fillMaxWidth().padding(8.dp), fontSize = 26.sp)

        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().padding(12.dp)) {
            Text(text = "CHECK OUT", textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(), color = Color.Black)
        }

        BottomAppBar(
            containerColor = colorResource(id = R.color.Col2)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.Col2)),
                horizontalArrangement = Arrangement.SpaceAround) {
                IconButton(
                    onClick = { navController.navigate("MainScreen") }
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }

                IconButton(
                    onClick = { navController.navigate("BagPage") }
                ) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Search")
                }

                IconButton(
                    onClick = { navController.navigate("WishPage") }
                ) {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                }

                IconButton(
                    onClick = { navController.navigate("ProfilePage") }
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
        BagPage(navController = dummyNavController)
    }
}













