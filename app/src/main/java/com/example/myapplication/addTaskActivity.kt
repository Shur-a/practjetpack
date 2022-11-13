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

class addTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize())
            {
                Text(text = "Добавить задачу", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight(800), modifier = Modifier.padding(30.dp))
                Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = "avatar", modifier = Modifier
                    .size(50.dp)
                    .offset(x = 350.dp, y = -70.dp)
                    .clickable(onClick = {
                        context.startActivity(
                            Intent(context, MainActivity::class.java)
                        )
                    }))
                EditText_TaskTitle()
                EditText_Time()
                EditText_Date()
                EditText_TaskDescription()
                Row(modifier = Modifier.offset(y = 180.dp)) {
                    ButtonAdd2("Записать задачу")
                }
            }
        }
    }
}

@Composable
fun EditText_TaskTitle(){
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
fun EditText_Time(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "16:30",
            Modifier
                .padding(start = 0.dp)
                .offset(y = -3.dp))},
        modifier = Modifier
            .size(220.dp, 50.dp)
            .padding(start = 26.dp, end = 16.dp)
            .offset(y = 20.dp)
            .clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent),
        leadingIcon = { Icon(painter = painterResource(id = R.drawable.small_gray_alarm), contentDescription = "", Modifier.size(20.dp)) }
    )
}
@Composable
fun EditText_Date(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "14.01.2021",
            Modifier
                .padding(start = 30.dp)
                .offset(y = -3.dp))},
        modifier = Modifier
            .size(239.dp, 50.dp)
            .padding(start = 26.dp, end = 46.dp)
            .offset(y = -30.dp, x = 190.dp)
            .clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent),
        leadingIcon = { Icon(painter = painterResource(id = R.drawable.small_gray_calendar), contentDescription = "", Modifier.size(20.dp)) }
    )
}
@Composable
fun EditText_TaskDescription(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "Описание задачи")},
        modifier = Modifier
            .size(420.dp, 116.dp)
            .padding(start = 26.dp, end = 46.dp)
            .offset(y = -10.dp, x = 0.dp)
            .clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent)
    )
}
@Composable
fun ButtonAdd2(name: String) {
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