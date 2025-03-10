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
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.ITW.ezbuy.mainPage.MainPage1
import com.ITW.ezbuy.ui.theme.EzBuyTheme

@Composable
fun ForgetPasswordPage(navController: NavController){
    var mail by remember { mutableStateOf(" ") }
    IconButton(onClick = { navController.navigate("Screen2") }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Back")
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Text(
                text = "Forgot password", fontWeight = FontWeight.Bold,
                color = Color.Black, textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 42.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Please, enter your email address. We will send a link for password update",
            modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        
        Box(){
            TextField(value = mail,
                onValueChange = {mail = it},
                label = { Text("Email") })
//            Text(text = "Not a valid mail address, should be yours mail address",
//                modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "SEND", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    val dummyNavController = rememberNavController()
    EzBuyTheme {
        ForgetPasswordPage(navController = dummyNavController)
    }
}