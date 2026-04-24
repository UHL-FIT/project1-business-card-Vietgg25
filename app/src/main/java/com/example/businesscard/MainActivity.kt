package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

val AndroidGreen = Color(0xFF3DDC84)
val DarkBackground = Color(0xFF073042)

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.weight(1f))


        ProfileSection()

        Spacer(modifier = Modifier.weight(1f))


        ContactSection()
    }
}

@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFF073042))
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Họ tên
        Text(
            text = "Tran Xuan Viet",
            fontSize = 36.sp,
            fontWeight = FontWeight.Light,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "CNTT-K1C",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AndroidGreen
        )
    }
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .height(1.dp)
                .background(Color.Gray)
        )


        ContactRow(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "Phone",
                    tint = AndroidGreen
                )
            },
            text = "+84 387 360 736"
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .height(1.dp)
                .background(Color.Gray)
        )


        ContactRow(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Social",
                    tint = AndroidGreen
                )
            },
            text = "@tranxuanviet"
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .height(1.dp)
                .background(Color.Gray)
        )


        ContactRow(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email",
                    tint = AndroidGreen
                )
            },
            text = "tranxuanviet@android.com"
        )
    }
}

@Composable
fun ContactRow(
    icon: @Composable () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.75f)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}