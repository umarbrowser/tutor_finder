package com.example.tutorfinder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorfinder.ui.theme.TutorFinderTheme

class SendMessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListMessages()
                }
            }
        }
    }
}

@Composable
fun ListMessages(){
    LazyColumn(){
        items(1){
            Column() {
                Greeting4()
                Column(modifier = Modifier.padding(15.dp)) {
                    Card(modifier = Modifier, elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
                        Column {
                            Row() {
                                Text(
                                    text = "Khadija Sa'aed (TBS0003)",
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(16.dp),
                                    style = MaterialTheme.typography.body1
                                )
                                Text(
                                    text = "Wednesday, 2nd August 2017",
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(16.dp),
                                    style = MaterialTheme.typography.body1
                                )
                            }
                            Divider()

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Subject: Alternate Phone Number",
                                modifier = Modifier

                                    .padding(16.dp),
                                style = MaterialTheme.typography.body1
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Message:",
                                modifier = Modifier

                                    .padding(16.dp),
                                style = MaterialTheme.typography.body1
                            )

                            Text(
                                text = "Please Ma, can you forward to me your alternative phone numbe, because the one on your profile is not accessible",
                                modifier = Modifier

                                    .padding(16.dp),
                                style = MaterialTheme.typography.body2
                            )





                        }

                    }

                }
                Column(modifier = Modifier.padding(15.dp)) {
                    Card(modifier = Modifier, elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
                        Column {
                            Row() {
                                Text(
                                    text = "Mr. Shehu Uthman (TBS0002)",
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(16.dp),
                                    style = MaterialTheme.typography.body1
                                )
                                Text(
                                    text = "Wednesday, 2nd August 2022",
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(16.dp),
                                    style = MaterialTheme.typography.body1
                                )
                            }
                            Divider()

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Subject: Fee Negotiation",
                                modifier = Modifier

                                    .padding(16.dp),
                                style = MaterialTheme.typography.body1
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Message:",
                                modifier = Modifier

                                    .padding(16.dp),
                                style = MaterialTheme.typography.body1
                            )

                            Text(
                                text = "Please Sir am in need of your services, but your price seem little bit costly. Can you please reduce your price a little bit to N70 per Hour",
                                modifier = Modifier

                                    .padding(16.dp),
                                style = MaterialTheme.typography.body2
                            )





                        }

                    }

                }

            }

        }
    }

}

@Composable
fun Greeting4() {
    val username = remember {
        mutableStateOf("")
    }
    val title = remember {
        mutableStateOf("")
    }
    val body = remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(15.dp)) {
        Card(modifier = Modifier, elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Compose Message",
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.h5
                )
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    singleLine = true,
                    value = "Umar Abdullahi(TBS0002)",
                    onValueChange = { },
                   )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    singleLine = true,
                    value = title.value,
                    onValueChange = {title.value = it },
                    label = {
                        Text(text = "Title")}
                   )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = body.value, onValueChange = {body.value = it} , label = {
                    Text(text = "Message")
                })
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 55.dp, end = 55.dp),
                    colors =
                    ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary
                    )
                ) {
                    Text(text = "Send", fontSize = 16.sp)
                }




            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview6() {
    TutorFinderTheme {
        ListMessages()
    }
}