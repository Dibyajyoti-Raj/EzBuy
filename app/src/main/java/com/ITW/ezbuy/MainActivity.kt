package com.ITW.ezbuy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ITW.ezbuy.Bag.BagPage
import com.ITW.ezbuy.Profile.ProfilePage
import com.ITW.ezbuy.Wishlist.ProductViewModel
import com.ITW.ezbuy.Wishlist.WishPage
import com.ITW.ezbuy.login.ForgetPasswordPage
import com.ITW.ezbuy.login.LogInPage
//import com.ITW.ezbuy.login.SignUp
import com.ITW.ezbuy.login.SignUpPage
import com.ITW.ezbuy.mainPage.MainPage1
import com.ITW.ezbuy.ui.theme.EzBuyTheme

class MainActivity : ComponentActivity() {
    val productVM: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            EzBuyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun SignUp() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Screen1") {
        composable("Screen1") { SignUpPage(navController) }
        composable("Screen2") { LogInPage(navController) }
        composable("Screen3") { ForgetPasswordPage(navController) }

        composable("MainScreen") { MainPage1(navController) }

        composable("BagPage") { BagPage(navController) }

//        composable(
//            "ProfilePage/{name}/{mail}",
//            arguments = listOf(
//                navArgument("name") { type = NavType.StringType },
//                navArgument("mail") { type = NavType.StringType }
//            )
//        ) { backStackEntry ->
//            val name = backStackEntry.arguments?.getString("name")
//            val mail = backStackEntry.arguments?.getString("mail")
////            ProfilePage(navController = navController, name = name, mail = mail)

        composable("WishPage") { WishPage(navController) }

        composable("ProfilePage") { ProfilePage(navController) }
        }

}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    EzBuyTheme {
//        Greeting("Android")
//    }
//}