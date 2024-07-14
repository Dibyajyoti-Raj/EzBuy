package com.ITW.ezbuy.login

import android.graphics.drawable.Icon
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ITW.ezbuy.R
import com.ITW.ezbuy.mainPage.MainPage1
import com.ITW.ezbuy.ui.theme.EzBuyTheme

@Composable
fun LogInPage(navController: NavController){
    var mail by remember { mutableStateOf(" ") }
    var passwd by remember { mutableStateOf("Password") }

    IconButton(onClick = { navController.navigate("Screen1") }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Back")
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Text(
                text = "Login", fontWeight = FontWeight.Bold,
                color = Color.Black, textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 62.sp
            )
        }

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
        TextButton(onClick = { navController.navigate("Screen3") }) {
            Text(text = "Forgot Password?")
        }
        Spacer(modifier = Modifier.height(26.dp))
        Button(onClick = { navController.navigate("MainScreen") }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "LOG IN", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "or login with a social account.", textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
        Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google")
                Spacer(modifier = Modifier.width(16.dp))
                Image(painter = painterResource(id = R.drawable.win), contentDescription = "Microsoft")
            }
        }

    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    val dummyNavController = rememberNavController()

        LogInPage(navController = dummyNavController)

}