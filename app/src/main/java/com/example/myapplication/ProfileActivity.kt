package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Green
import com.example.myapplication.ui.theme.LightGreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.white

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()

            ) {
                Row(modifier = Modifier.padding(all=12.dp)){
                    Profiles_enter(text = "Профиль пользователя")
                }
                Spacer(modifier = Modifier.height(40.dp))
                Image(painter = painterResource(R.drawable.avatar_big), contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .wrapContentSize(
                            Alignment.Center
                        )
                        .size(200.dp))
                Spacer(modifier = Modifier.padding(18.dp))
                Text("Вход не выполенен", fontSize = 12.sp, modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center), color = white)
                Spacer(modifier = Modifier.padding(88.dp))
                Button3()
                Spacer(modifier = Modifier.padding(18.dp))
                Button4()
            }


        }
    }
}

@Composable
fun Button3(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)){
        val context = LocalContext.current
        Button(onClick = {context.startActivity(Intent(context, userLogin::class.java))

        },
            Modifier.size(360.dp, 50.dp),
            colors =  ButtonDefaults.buttonColors(backgroundColor = LightGreen)){
            Text(text = "Войти", color = white)

        }
    }
}
@Composable
fun Button4(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)){
        val context = LocalContext.current
        Button(onClick = {context.startActivity(Intent(context, userLogin2::class.java))
        },
            Modifier.size(360.dp, 50.dp),
            colors =  ButtonDefaults.buttonColors(backgroundColor = LightGreen)){
            Text(text = "Регистрация", color = white)

        }
    }
}
@Composable
fun Profiles_enter(text:String) {
    Row(modifier = Modifier
        .padding(all=16.dp)) {
        Column(modifier = Modifier
            .padding(top = 4.dp)){
            Text(text = text,
                fontSize = 24.sp,
                color = white,
                fontWeight = FontWeight.Bold
                )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)
            .offset(x = 0.dp, y = (-10).dp)
            .padding(end = 24.dp, top = 8.dp)) {
            val context = LocalContext.current
            IconButton(onClick = { context.startActivity(Intent(context, settindsActivity::class.java))}) {
                Image(painter = painterResource(R.drawable.backbutton), contentDescription = "Vector",
                    modifier = Modifier

                        .size(50.dp)
                        .clip(CircleShape))
            }

        }
        Spacer(modifier = Modifier.padding(16.dp))

    }

}