package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.*

class settindsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()

            ) {
                Row(modifier = Modifier.padding(all=12.dp)){
                    Text("Настройки",
                        fontSize = 26.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,)
                    val context = LocalContext.current
                    Image(painter = painterResource(R.drawable.avatar), contentDescription = null,modifier = Modifier
                        .offset(x = 170.dp, y = 0.dp)
                        .size(65.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                        .clickable(onClick = {
                            context.startActivity(
                                Intent(context, ProfileActivity::class.java)
                            )
                        })
                    )
                }
                Profiles("Профиль пользователя")
                Profiles1("Дата и время")
                Profiles2("Настройки звука")
                Profiles3("Проверить обновления")
                Spacer(modifier = Modifier.padding(110.dp,214.dp))
                Navigations3()
            }
        }
    }
}

@Composable
fun Profiles(text:String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 18.dp)) {
        Column(){
            Text(text = text,
            fontSize = 24.sp,
            color = white)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)
            .offset(x = 10.dp, y = (-10).dp)
            .padding(end = 24.dp, top = 8.dp)) {
            val context = LocalContext.current
            IconButton(onClick = {context.startActivity(Intent(context, ProfileActivity::class.java))}) {
                Image(painter = painterResource(R.drawable.vector), contentDescription = "Vector",
                    modifier = Modifier.size(20.dp))
            }

        }


    }

}
@Composable
fun Profiles1(text:String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 18.dp)) {
        Column(){
            Text(text = text,
                fontSize = 24.sp,
                color = white)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)
            .offset(x = 10.dp, y = (-10).dp)
            .padding(end = 24.dp, top = 8.dp)) {
            val context = LocalContext.current
            IconButton(onClick = {context.startActivity(Intent(context, ProfileActivity::class.java))}) {
                Image(painter = painterResource(R.drawable.vector), contentDescription = "Vector",
                    modifier = Modifier.size(20.dp))
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))

    }

}
@Composable
fun Profiles2(text:String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 18.dp)) {
        Column(){
            Text(text = text,
                fontSize = 24.sp,
                color = white)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)
            .offset(x = 10.dp, y = (-10).dp)
            .padding(end = 24.dp, top = 8.dp)) {
            val context = LocalContext.current
            IconButton(onClick = {context.startActivity(Intent(context, ProfileActivity::class.java))}) {
                Image(painter = painterResource(R.drawable.vector), contentDescription = "Vector",
                    modifier = Modifier.size(20.dp))
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))
    }

}
@Composable
fun Profiles3(text:String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 18.dp)) {
        Column(){
            Text(text = text,
                fontSize = 24.sp,
                color = white)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)
            .offset(x = 10.dp, y = (-10).dp)
            .padding(end = 24.dp, top = 8.dp)) {
            val context = LocalContext.current
            IconButton(onClick = {context.startActivity(Intent(context, ProfileActivity::class.java))}) {
                Image(painter = painterResource(R.drawable.vector), contentDescription = "Vector",
                    modifier = Modifier.size(20.dp))
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))

    }

}
@Composable
fun Navigations3(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Card(
            modifier = Modifier
                .size(360.dp, 88.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp,

                        )
                ),
            backgroundColor = LightGreen
        ){
            Row(modifier = Modifier.padding(all=8.dp)) {
                Column(modifier = Modifier.padding(start = 22.dp)) {
                    val context = LocalContext.current
                    IconButton(
                        onClick = {context.startActivity(Intent(context, MainActivity::class.java))}){
                        Image(painter = painterResource(R.drawable.listred), contentDescription = null,modifier = Modifier
                            .size(50.dp))
                    }


                    Text(text = "List", color = LightRed,modifier = Modifier
                        .width(50.dp)
                        .wrapContentSize(Alignment.Center))
                }
                Column(modifier = Modifier.padding(start = 32.dp)) {
                    val context = LocalContext.current
                    IconButton(
                        onClick = {context.startActivity(Intent(context, AlarmActivity::class.java))}){
                        Image(painter = painterResource(R.drawable.alarm), contentDescription = null,modifier = Modifier
                            .size(50.dp))
                    }

                    Text(text = "Alarm", color = LightRed,modifier = Modifier
                        .width(50.dp)
                        .wrapContentSize(Alignment.Center))
                }
                Column(modifier = Modifier.padding(start = 32.dp)) {
                    val context = LocalContext.current
                    IconButton(
                        onClick = {context.startActivity(Intent(context, calendarActivity::class.java))}){
                        Image(painter = painterResource(R.drawable.calendar), contentDescription = null,modifier = Modifier
                            .size(50.dp))
                    }

                    Text(text = "Calendar", color = LightRed,fontSize = 10.sp,modifier = Modifier
                        .width(50.dp)
                        .wrapContentSize(Alignment.Center))
                }
                Column(modifier = Modifier.padding(start = 32.dp)) {
                    IconButton(
                        onClick = {}){
                        Image(painter = painterResource(R.drawable.settgreen), contentDescription = null,modifier = Modifier
                            .size(50.dp))
                    }

                    Text(text = "Settings", color = Green, fontSize = 10.sp,modifier = Modifier
                        .width(40.dp)
                        .wrapContentSize(Alignment.Center))
                }

            }

        }
    }
}


