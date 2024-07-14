package com.ITW.ezbuy.Wishlist

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.ITW.ezbuy.MainActivity
import com.ITW.ezbuy.R
import com.ITW.ezbuy.ui.theme.EzBuyTheme

@Composable
fun WishPage(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Favorites",
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(26.dp))

//        productScreen(productVM = productVM)
//        val product by productVM.products.observeAsState(emptyList<Product>())
//        LazyColumn {
//        items(product) { product ->
//            ProductItem(product = product)
//        }
    }


//        Spacer(modifier = Modifier.weight(1f))

        BottomAppBar(
            containerColor = colorResource(id = R.color.Col2)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.Col2)),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
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

//@Composable
//fun productScreen(productVM: ProductViewModel) {
//    val product by productVM.products.observeAsState(emptyList<Product>())
//
//    LazyColumn {
//        items(product) { product ->
//            ProductItem(product = product)
//        }
//    }
//}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WishPagePreview() {
    val dummyNavController = rememberNavController()
    EzBuyTheme {
        WishPage(navController = dummyNavController)
    }
}
