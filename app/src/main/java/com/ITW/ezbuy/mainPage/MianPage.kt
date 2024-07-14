package com.ITW.ezbuy.mainPage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import com.ITW.ezbuy.Wishlist.ProductViewModel
import com.ITW.ezbuy.ui.theme.EzBuyTheme

@Composable
fun MainPage1(navController: NavController)
{
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(4.dp)) {
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

            Spacer(modifier = Modifier.height(16.dp))


        }

        Spacer(modifier = Modifier.height(16.dp))
        MyApp()

    Spacer(modifier = Modifier.height(300.dp))

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

data class Person(val name: String, val age: Double)

@Composable
fun MyApp() {
    val people = listOf(
        Person("Fjallraven - Backpack", 109.95),
        Person("Mens Cotton Jacket", 55.99),
        Person("Portable External Hard Drive - USB 3.0", 64.50),
        Person("SanDisk SSD PLUS 1TB Internal SS", 197.0)
    )

    PersonList(people)
}

@Composable
fun PersonList(people: List<Person>) {
    LazyColumn {
        items(people.size) {index ->
            val person = people[index]
            Column() {
//                Image(
//                    painter = painterResource(id = image),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(130.dp)
//                        .padding(8.dp),
//                    contentScale = ContentScale.Fit,
//                )

                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    colors = CardColors(
                        containerColor = colorResource(id = R.color.Col1),
                        contentColor = Color.Black,
                        disabledContentColor = Color.Black,
                        disabledContainerColor = colorResource(id = R.color.Col1)
                    )
                ) {
                    Text(text = person.name, modifier = Modifier.padding(8.dp))
                    Text(text = "Price: ${person.age}", modifier = Modifier.padding(8.dp))
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