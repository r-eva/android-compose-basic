package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LayoutBusinessCard()
                }
            }
        }
    }
}


@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(painter = image, contentDescription = null, modifier =
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(), contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }

}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun JetpackArticle(title: String){
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Paragraph(
            firstText = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            secondText = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
        )
    }
}

@Composable
fun Paragraph(firstText: String, secondText: String) {
    Text(
        text = firstText,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
    Text(
        text = secondText,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun ArticleWithImage (title: String) {
    Column {
        val image = painterResource(id = R.drawable.bg_compose_background)
        Box {
            Image(painter = image, contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
        JetpackArticle(title = title)
    }
}

@Composable
fun TaskCompletedSign (firstText: String, secondText: String) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(id = R.drawable.ic_task_completed)
        Box {
            Image(painter = image, contentDescription = null
            )
        }
        Text(
            text = firstText,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = secondText,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ComposableBox(
    color: Color,
    modifier: Modifier = Modifier,
    firstText: String,
    secondText: String
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ) {
        Text(text = firstText,
            modifier = Modifier
                .padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(text = secondText, textAlign = TextAlign.Justify)
    }
}

@Composable
fun ComposableQuadrant() {
    Column (Modifier.fillMaxWidth()) {
        Row (modifier = Modifier.weight(1f)) {
            ComposableBox(color = Color.Green, firstText = "Text composable", secondText = "Displays text and follows Material Design guidelines.", modifier = Modifier.weight(1f))
            ComposableBox(color = Color.Yellow, firstText = "Text composable", secondText = "Displays text and follows Material Design guidelines.", modifier = Modifier.weight(1f))
        }
        Row (modifier = Modifier.weight(1f)) {
            ComposableBox(color = Color.Cyan, firstText = "Text composable", secondText = "Displays text and follows Material Design guidelines.", modifier = Modifier.weight(1f))
            ComposableBox(color = Color.LightGray, firstText = "Text composable", secondText = "Displays text and follows Material Design guidelines.", modifier = Modifier.weight(1f))
        }
    }
}


@Composable
fun Overview(fullName: String, title: String) {
    val ColumnModifier = Modifier
        .fillMaxSize()
    val ColorTitle = Color(0xFF3ddc84)
    Column (
        modifier = ColumnModifier, horizontalAlignment = Alignment.CenterHorizontally)
    {
        val image = painterResource(id = R.drawable.android_logo)
        Image(painter = image, contentDescription = null, modifier = Modifier.size(100.dp))
        Text(text = fullName,
            modifier = Modifier
                .padding(bottom = 4.dp, top = 4.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 30.sp
        )
        Text(text = title, fontSize = 15.sp, color = ColorTitle,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun IconAndText (icon: ImageVector, text: String) {
    val colorIcon = Color(0xFF3ddc84)
    Column {
        CustomDivider()
    }
    Row( modifier = Modifier.padding(start = 50.dp, bottom = 5.dp, top = 5.dp)) {
        Icon(imageVector = icon, contentDescription = "Phone", modifier = Modifier.padding(end = 20.dp), tint = colorIcon)
        Text(text = text, color = Color.White, fontSize = 15.sp)
    }

}

@Composable
fun CustomDivider () {
    Divider (
        color = Color.White,
        modifier = Modifier
            .height(0.5.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    )
}

@Composable
fun DetailsData (number: String, socialMedia: String, email: String){
    val ColumnModifier = Modifier.fillMaxWidth()
    Column(modifier = ColumnModifier) {
        val MyAppIcons = Icons.Rounded
        IconAndText(icon = MyAppIcons.Phone, text = number)
        IconAndText(icon = MyAppIcons.Share, text = socialMedia)
        IconAndText(icon = MyAppIcons.Email, text = email)
    }
}

@Composable
fun LayoutBusinessCard() {
    val backgroudColor = Color(0xFF092F42)
    Column(modifier = Modifier
        .background(color = backgroudColor)
        .fillMaxWidth()
        .padding(top = 40.dp, bottom = 40.dp)
    ) {
        Row(modifier = Modifier.weight(3f)) {
            Overview(fullName = "Regina Eva", title = "Android Developer Extraordinarie")
        }
        Row(modifier = Modifier
            .weight(4f)
            .padding(start = 20.dp, end = 20.dp)
            .wrapContentSize(Alignment.Center)
        ) {
            DiceWithButtonAddImage(modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .weight(1f))
            TipTimeScreen(modifier = Modifier
                .fillMaxSize()
                .weight(1f).padding(start = 20.dp, end = 20.dp)
                .wrapContentSize(Alignment.Center)
            )
        }
        Row(modifier = Modifier
            .weight(2f)
            .wrapContentSize(Alignment.BottomEnd)) {
            DetailsData(number = "+00 000 000", socialMedia = "regina@socialmedia", email = "regina.mandasari@accenture.com")
        }
    }
}

@Composable
fun DiceWithButtonAddImage(modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageResult = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = painterResource(imageResult),
            contentDescription = "1",
            modifier = Modifier.size(180.dp),
        )
        Spacer(modifier = Modifier.height(2.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(text = stringResource(R.string.roll))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
    HappyBirthdayTheme {
        Column {
            LayoutBusinessCard()
        }
    }
}