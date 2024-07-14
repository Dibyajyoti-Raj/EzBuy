package com.ITW.ezbuy.login

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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ITW.ezbuy.Profile.ProfilePage
import com.ITW.ezbuy.R
import com.ITW.ezbuy.mainPage.MainPage1
import com.ITW.ezbuy.ui.theme.EzBuyTheme

@Composable
fun SignUp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Screen1") {
        composable("Screen1") { SignUpPage(navController) }
        composable("Screen2") { LogInPage(navController) }
        composable("Screen3") { ForgetPasswordPage(navController) }
        composable("MainScreen") { MainPage1(navController) }

        composable(
            "profile/{name}/{mail}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("mail") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val mail = backStackEntry.arguments?.getString("mail")
            ProfilePage(navController = navController, name = name, mail = mail)
        }
    }
}

    @Composable
    fun SignUpPage(navController: NavController) {
        var name by remember { mutableStateOf(" ") }
        var mail by remember { mutableStateOf(" ") }
        var passwd by remember { mutableStateOf("Password") }

        Column(modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box {
                Text(
                    text = "Sign Up", fontWeight = FontWeight.Bold,
                    color = Color.Black, textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 62.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = mail,
                onValueChange = { mail = it },
                label = { Text("Email") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = passwd,
                onValueChange = { passwd = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = { navController.navigate("Screen2") }) {
                Text(text = "Alredy hav e an account?")
            }
            Spacer(modifier = Modifier.height(26.dp))
            Button(onClick = { navController.navigate("MainScreen") }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "SIGN UP", textAlign = TextAlign.Center)
            }
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(Color.LightGray)
//            ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "or login with a social account.", textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.win),
                        contentDescription = "Microsoft"
                    )
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    val dummyNavController = rememberNavController()
    EzBuyTheme {
        SignUpPage(navController = dummyNavController)
    }
}
