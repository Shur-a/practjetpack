package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.ui.theme.*
import java.util.*

class calendarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()

            ) {
                Row(modifier = Modifier.padding(all=12.dp)){
                    Text("Календарь",
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
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)) {
                    calendars()

                }
                Spacer(modifier = Modifier.padding(110.dp,110.dp))
                Navigations2()
            }
        }
    }
}
@Composable
fun Navigations2(){
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
                        Image(painter = painterResource(R.drawable.calendargreen), contentDescription = null,modifier = Modifier
                            .size(50.dp))
                    }

                    Text(text = "Calendar", color = Green,fontSize = 10.sp,modifier = Modifier
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
fun calendars() {
    AndroidView(
        {CalendarView(it)},
        modifier = Modifier.wrapContentWidth(),
        update = {view->view.setOnDateChangeListener{calendarView,year,month,dayOfMonth->
            val cal = Calendar.getInstance()
            cal.set(year,month,dayOfMonth)
        }}
    )
}
