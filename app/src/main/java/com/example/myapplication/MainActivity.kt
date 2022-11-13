package com.example.myapplication

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()

            ) {
                Row(modifier = Modifier.padding(all=12.dp)){
                    Text("Список дел",
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
                Spacer(modifier = Modifier.height(20.dp))
                RoundedCornerShapeDemo()
            }
        }
    }
}
@Composable
fun RoundedCornerShapeDemo(){
    ExampleBox(shape = RoundedCornerShape(100.dp))
    Spacer(modifier = Modifier.height(16.dp))
    ExampleBox1(shape = RoundedCornerShape(100.dp))
    Spacer(modifier = Modifier.height(16.dp))
    ExampleBox2(shape = RoundedCornerShape(100.dp))
    Spacer(modifier = Modifier.height(134.dp))
    Button1(style = Stroke(width = 30f))
    Spacer(modifier = Modifier.height(16.dp))
    Navigations()
}
@Composable
fun Button1(style: DrawStyle){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)){
        val context = LocalContext.current
        Button(onClick = {
            context.startActivity(Intent(context, addTaskActivity::class.java))
        },
            Modifier.size(360.dp, 50.dp),
            colors =  ButtonDefaults.buttonColors(backgroundColor = LightGreen)){
            Text(text = "Добавить задачу", color = white)

        }
    }
}

@Composable
fun Navigations(){
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
                        onClick = {}){
                        Image(painter = painterResource(R.drawable.maskgroup), contentDescription = null,modifier = Modifier
                        .size(50.dp))
                    }


                    Text(text = "List", color = Green,modifier = Modifier
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
                    val context = LocalContext.current
                    IconButton(
                        onClick = {context.startActivity(Intent(context, settindsActivity::class.java))}){
                        Image(painter = painterResource(R.drawable.settings), contentDescription = null,modifier = Modifier
                            .size(50.dp))
                    }

                    Text(text = "Settings", color = LightRed, fontSize = 10.sp,modifier = Modifier
                        .width(40.dp)
                        .wrapContentSize(Alignment.Center))
                }

            }

        }
    }
}
@Composable
fun ExampleBox(shape: Shape,){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Card(
            modifier = Modifier
                .size(360.dp, 100.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 0.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 0.dp,

                        )
                ),
            backgroundColor = Yellow
        ) {
            Row(modifier = Modifier.padding(all=8.dp)) {
                Column(modifier = Modifier.padding(all=12.dp)) {
                    Text( "Вечерний поход в кино", fontSize = 20.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,)
                    Text("Идем в кино с коллегами!",fontSize = 16.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)

                }
                Column(modifier = Modifier.padding(all=12.dp)) {
                    Text("10.02.2021",fontSize = 16.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)
                    Text("19:40",fontSize = 16.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)
                }

            }


        }
    }
}
@Composable
fun ExampleBox1(shape: Shape,){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Card(
            modifier = Modifier
                .size(360.dp, 100.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 0.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 0.dp,

                        )
                ),
            backgroundColor = Yellow
        ) {
            Row(modifier = Modifier.padding(all=8.dp)) {
                Column(modifier = Modifier.padding(all=12.dp)) {
                    Text( "Забрать заказ Ozon", fontSize = 20.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,)
                    Text("Пункт выдачи на ул.Ленина,103",fontSize = 14.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)

                }
                Column(modifier = Modifier.padding(all=12.dp)) {
                    Text("10.02.2021",fontSize = 16.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)
                    Text("19:40",fontSize = 16.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)
                }

            }


        }
    }
}
@Composable
fun ExampleBox2(shape: Shape,){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Card(
            modifier = Modifier
                .size(360.dp, 100.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 0.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 0.dp,

                        )
                ),
            backgroundColor = Yellow
        ) {
            Row(modifier = Modifier.padding(all=8.dp)) {
                Column(modifier = Modifier.padding(all=12.dp)) {
                    Text( "Запись в автосервис", fontSize = 20.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,)
                    Text("Сдать автомобиль в автосервис на ул.\n" +
                            "Бисертская, д. 14. Замена масла",fontSize = 12.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)

                }
                Column(modifier = Modifier.padding(all=12.dp)) {
                    Text("10.02.2021",fontSize = 16.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)
                    Text("19:40",fontSize = 16.sp,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Light,)
                }

            }


        }
    }
}