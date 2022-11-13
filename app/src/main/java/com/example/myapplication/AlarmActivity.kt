package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.*

class AlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()

            ) {
                Row(modifier = Modifier.padding(all=12.dp)){
                    Text("Будильник",
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
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.padding(16.dp)) {
                    Column(modifier = Modifier.padding(all=8.dp)) {
                        Text( "07:30", fontSize = 60.sp,
                            color = MaterialTheme.colors.surface,
                            )
                        Text( "08:30", fontSize = 60.sp,
                            color = MaterialTheme.colors.surface,
                            )
                    }
                    Row(modifier = Modifier.padding(46.dp)) {}
                    Column(modifier = Modifier.padding(all=42.dp)) {
                        Switch1()
                        Spacer(modifier = Modifier.padding(18.dp))
                        Switch2()
                    }
                }
                Column(modifier = Modifier.fillMaxHeight().wrapContentSize(Alignment.BottomCenter)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Spacer(modifier = Modifier.padding(96.dp))
                        Button2(style = Stroke(width = 30f))
                        Spacer(modifier = Modifier.padding(110.dp,10.dp))
                        Navigations1()
                    }

                }


            }
        }
    }
}
@Composable
fun Button2(style: DrawStyle){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)){
        val context = LocalContext.current
        Button(onClick = {
            context.startActivity(Intent(context, editAlarm::class.java))
        },
            Modifier.size(360.dp, 50.dp),
            colors =  ButtonDefaults.buttonColors(backgroundColor = LightGreen)){
            Text(text = "Добавить будильник", color = white)

        }
    }
}
@Composable
fun Navigations1(){
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
                        Image(painter = painterResource(R.drawable.clockgreen), contentDescription = null,modifier = Modifier
                            .size(50.dp))
                    }

                    Text(text = "Alarm", color = Green,modifier = Modifier
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
fun Switch1(
    scale: Float = 2f,
    width: Dp = 36.dp,
    height: Dp = 20.dp,
    checkedTrackColor: androidx.compose.ui.graphics.Color = Color(0xFFAAF683),
    uncheckedTrackColor: androidx.compose.ui.graphics.Color = Color(0xFFFF9B85),
    thumbColor: androidx.compose.ui.graphics.Color = white,
    gapBetweenThumbAndTrackEdge: Dp = 4.dp
) {

    val switchON = remember {
        mutableStateOf(true)
    }

    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    // To move the thumb, we need to calculate the position (along x axis)
    val animatePosition = animateFloatAsState(
        targetValue = if (switchON.value)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
    )

    Canvas(
        modifier = Modifier
            .size(width = width, height = height)
            .scale(scale = scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        // This is called when the user taps on the canvas
                        switchON.value = !switchON.value
                    }
                )
            }
    ) {

        // Track
        drawRoundRect(
            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx())
        )

        // Thumb
        drawCircle(
            color = thumbColor,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )

    }

    Spacer(modifier = Modifier.height(18.dp))
}

@Composable
fun Switch2(
    scale: Float = 2f,
    width: Dp = 36.dp,
    height: Dp = 20.dp,
    checkedTrackColor: androidx.compose.ui.graphics.Color = Color(0xFFAAF683),
    uncheckedTrackColor: androidx.compose.ui.graphics.Color = Color(0xFFFF9B85),
    thumbColor: androidx.compose.ui.graphics.Color = white,
    gapBetweenThumbAndTrackEdge: Dp = 4.dp
) {

    val switchON = remember {
        mutableStateOf(true)
    }

    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    // To move the thumb, we need to calculate the position (along x axis)
    val animatePosition = animateFloatAsState(
        targetValue = if (switchON.value)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
    )

    Canvas(
        modifier = Modifier
            .size(width = width, height = height)
            .scale(scale = scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        // This is called when the user taps on the canvas
                        switchON.value = !switchON.value
                    }
                )
            }
    ) {

        // Track
        drawRoundRect(
            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx())
        )

        // Thumb
        drawCircle(
            color = thumbColor,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )

    }

    Spacer(modifier = Modifier.height(18.dp))
}