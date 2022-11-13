package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Green
import com.example.myapplication.ui.theme.LightGreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class editTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize())
            {
                Text(
                    text = "Изменить задачу",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight(800),
                    modifier = Modifier.padding(30.dp)
                )
                Image(painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .size(50.dp)
                        .offset(x = 350.dp, y = -70.dp)
                        .clickable(onClick = {
                            context.startActivity(
                                Intent(context, MainActivity::class.java)
                            )
                        })
                )
                EditText_TaskTitle2()
                EditText_Time2()
                EditText_Date2()
                EditText_TaskDescription2()
                Row(modifier = Modifier.offset(y = -20.dp)) {
                    val context = LocalContext.current
                    Column (modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                    ) {
                        Button(onClick = {context.startActivity(Intent(context, MainActivity::class.java))},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Red),
                            modifier = Modifier.offset(y = 135.dp)
                                .size(340.dp, 50.dp)
                                .clip(RoundedCornerShape(20))
                        ) {
                            Text(
                                text = "Удалить задачу",
                                color = MaterialTheme.colors.background,
                                fontSize = 18.sp, fontWeight = FontWeight(400)
                            )
                        }
                    }

                }
                Row(modifier = Modifier.offset(y = 130.dp)) {
                    ButtonAdd("Записать задачу")
                }
            }
        }
    }
}

@Composable
fun ButtonAdd(name: String) {
    val context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)
    ) {
        Button(onClick = {context.startActivity(Intent(context, MainActivity::class.java))},
            colors = ButtonDefaults.buttonColors(backgroundColor = LightGreen),
            modifier = Modifier
                .size(340.dp, 50.dp)
                .clip(RoundedCornerShape(20))
        ) {
            Text(
                text = name,
                color = MaterialTheme.colors.background,
                fontSize = 18.sp, fontWeight = FontWeight(400)
            )
        }
    }
}
@Composable
fun EditText_TaskTitle2(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "Заголовок задачи")},
        modifier = Modifier
            .size(400.dp, 50.dp)
            .padding(start = 26.dp, end = 16.dp)
            .offset(y = 0.dp)
            .clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent)
    )
}
@Composable
fun EditText_Time2(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "16:30",
            Modifier
                .padding(start = 0.dp)
                .offset(y = -2.dp))},
        modifier = Modifier
            .size(220.dp, 50.dp)
            .padding(start = 26.dp, end = 16.dp)
            .offset(y = 14.dp)
            .clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent), leadingIcon = { Icon(
            painter = painterResource(id = R.drawable.small_gray_alarm),
            contentDescription = "", modifier = Modifier.size(20.dp)
        )
        }
    )
}
@Composable
fun EditText_Date2(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "14.01.2021",
            Modifier
                .padding(start = 0.dp)
                .offset(y = -3.dp))},
        modifier = Modifier
            .size(239.dp, 50.dp)
            .padding(start = 26.dp, end = 46.dp)
            .offset(y = -36.dp, x = 190.dp)
            .clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent), leadingIcon = { Icon(
            painter = painterResource(id = R.drawable.small_gray_calendar),
            contentDescription = "", Modifier.size(20.dp)
        )
        }
    )
}
@Composable
fun EditText_TaskDescription2(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "Описание задачи")},
        modifier = Modifier
            .size(450.dp, 116.dp)
            .padding(start = 26.dp, end = 46.dp)
            .offset(y = -20.dp, x = 0.dp)
            .clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent)
    )
}
