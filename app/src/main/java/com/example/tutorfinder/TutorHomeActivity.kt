package com.example.tutorfinder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorfinder.ui.theme.TutorFinderTheme
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

class TutorHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting5(context = LocalContext.current)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Greeting5(context: Context) {
    val title = remember {
        mutableStateOf("")
    }
    val monCheckedState = remember {
        mutableStateOf(false)
    }
    val tueCheckedState = remember {
        mutableStateOf(false)
    }
    val wedCheckedState = remember {
        mutableStateOf(false)
    }
    val thuCheckedState = remember {
        mutableStateOf(false)
    }
    val friCheckedState = remember {
        mutableStateOf(false)
    }
    val satCheckedState = remember {
        mutableStateOf(false)
    }
    val sunCheckedState = remember {
        mutableStateOf(false)
    }
    val options = listOf("Select an option", "1","2","3","4","5","6","7","8","9","10",
        "11","12","13","14","15","16","17","18","19","20","21","22","23","24",)
    var selectedOptionText by remember {
        mutableStateOf(options[0])
    }
    var expanded by remember { mutableStateOf(false) }
    Column( verticalArrangement = Arrangement.SpaceBetween) {
        Card(elevation = 4.dp) {
            Column() {


                Row(
                    modifier = Modifier.padding(
                        top = 20.dp,
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    )
                ) {
                    Card(
                        modifier = Modifier
                            .size(50.dp)
                            .fillMaxHeight(0.4f),
                        shape = RoundedCornerShape(125.dp),
                        elevation = 10.dp
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.tutor1),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )

                    }


                    Column(
                        modifier = Modifier
                            .weight(5f)
                            .padding(start = 5.dp)
                    ) {
                        Text(
                            text = "Online Tutor Booking System",
                            modifier = Modifier,
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = "Aminu Musa",
                            style = MaterialTheme.typography.body2
                        )

                    }
                    IconButton(onClick = {
                        context.startActivity(Intent(context, MainActivity::class.java))
                    }) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp, contentDescription = "Location",
                            modifier = Modifier
                                .size(30.dp)
                                .padding(3.dp)
                                .weight(1f)


                        )

                    }

                }
                Row(modifier = Modifier.padding(top = 10.dp)) {
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null
                            )
                            Text(
                                text = "Add Subject",
                                style = MaterialTheme.typography.button
                            )
                        }

                    }
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null
                            )
                            Text(
                                text = "Bookings",
                                style = MaterialTheme.typography.button
                            )
                        }

                    }
                    OutlinedButton(
                        onClick = { context.startActivity(Intent(context, SendMessageActivity::class.java)) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null
                            )
                            Text(
                                text = "Messages",
                                style = MaterialTheme.typography.button
                            )
                        }

                    }
                }
            }
        }

        LazyColumn() {
            items(1) {
                Column(modifier = Modifier.padding(15.dp)) {
                    Card(modifier = Modifier, elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Set Price Per Hour",
                                modifier = Modifier
                                    .padding(16.dp),
                                style = MaterialTheme.typography.h5
                            )
                            Divider()
                            Text(
                                text = "Price in Naira(N) Per Day *",
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.body2
                            )
                            OutlinedTextField(

                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                singleLine = true,
                                value = title.value,
                                onValueChange = { title.value = it },
                                label = {
                                    Text(text = "Price")
                                },

                                )
                            Text(
                                text = "Number Of Hours Available Per Day *",
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.body2
                            )
                            ExposedDropdownMenuBox(
                                expanded = expanded,
                                onExpandedChange = {
                                    expanded = !expanded
                                }
                            ) {
                                TextField(
                                    readOnly = true,
                                    value = selectedOptionText,
                                    onValueChange = { },
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = expanded
                                        )
                                    },
                                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                                )
                                ExposedDropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = {
                                        expanded = false
                                    }
                                ) {
                                    options.forEach { selectionOption ->
                                        DropdownMenuItem(
                                            onClick = {
                                                selectedOptionText = selectionOption
                                                expanded = false
                                            }
                                        ) {
                                            Text(text = selectionOption)
                                        }
                                    }
                                }
                            }
                            Text(
                                text = "Days Available *",
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.body2
                            )
                            Row(){
                                Checkbox(checked = monCheckedState.value, onCheckedChange = {
                                    monCheckedState.value = it
                                })
                                Text(text = "Monday")
                                Checkbox(checked = tueCheckedState.value, onCheckedChange = {
                                    tueCheckedState.value = it
                                })
                                Text(text = "Tuesday")
                            }
                            Row(){
                                Checkbox(checked = wedCheckedState.value, onCheckedChange = {
                                    wedCheckedState.value = it
                                })
                                Text(text = "Wednesday")
                                Checkbox(checked = thuCheckedState.value, onCheckedChange = {
                                    thuCheckedState.value = it
                                })
                                Text(text = "Thursday")
                            }
                            Row(){
                                Checkbox(checked = friCheckedState.value, onCheckedChange = {
                                    friCheckedState.value = it
                                })
                                Text(text = "Friday")
                                Checkbox(checked = satCheckedState.value, onCheckedChange = {
                                    satCheckedState.value = it
                                })
                                Text(text = "Saturday")
                            }
                            Row(){
                                Checkbox(checked = sunCheckedState.value, onCheckedChange = {
                                    sunCheckedState.value = it
                                })
                                Text(text = "Sunday")

                            }
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
                                Text(text = "Set Price / Update Price", fontSize = 16.sp)
                            }
                            Spacer(modifier = Modifier.height(5.dp))


                        }

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(
                            top = 20.dp,
                            start = 10.dp,
                            end = 10.dp,
                            bottom = 10.dp
                        )
                    ) {
                        Card(
                            modifier = Modifier
                                .size(50.dp)
                                .fillMaxHeight(0.4f),
                            shape = RoundedCornerShape(125.dp),
                            elevation = 10.dp
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.naira),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                        Column(
                            modifier = Modifier
                                .weight(5f)
                                .padding(start = 5.dp)
                        ) {
                            Text(
                                text = "My Price",
                                modifier = Modifier,
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = "N 200 Naira Per Day",
                                style = MaterialTheme.typography.body2
                            )

                        }

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(
                            top = 20.dp,
                            start = 10.dp,
                            end = 10.dp,
                            bottom = 10.dp
                        )
                    ) {
                        Card(
                            modifier = Modifier
                                .size(50.dp)
                                .fillMaxHeight(0.4f),
                            shape = RoundedCornerShape(125.dp),
                            elevation = 10.dp
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.calender),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                        Column(
                            modifier = Modifier
                                .weight(5f)
                                .padding(start = 5.dp)
                        ) {
                            Text(
                                text = "Availability",
                                modifier = Modifier,
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = "4 Days Per Week",
                                style = MaterialTheme.typography.body2
                            )

                        }

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(
                            top = 20.dp,
                            start = 10.dp,
                            end = 10.dp,
                            bottom = 10.dp
                        )
                    ) {
                        Card(
                            modifier = Modifier
                                .size(50.dp)
                                .fillMaxHeight(0.4f),
                            shape = RoundedCornerShape(125.dp),
                            elevation = 10.dp
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.clock),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                        Column(
                            modifier = Modifier
                                .weight(5f)
                                .padding(start = 5.dp)
                        ) {
                            Text(
                                text = "Hours Available",
                                modifier = Modifier,
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = "4 Hours Per Day",
                                style = MaterialTheme.typography.body2
                            )

                        }

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(
                            top = 20.dp,
                            start = 10.dp,
                            end = 10.dp,
                            bottom = 10.dp
                        )
                    ) {
                        Card(
                            modifier = Modifier
                                .size(50.dp)
                                .fillMaxHeight(0.4f),
                            shape = RoundedCornerShape(125.dp),
                            elevation = 10.dp
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.salari),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                        Column(
                            modifier = Modifier
                                .weight(5f)
                                .padding(start = 5.dp)
                        ) {
                            Text(
                                text = "Monthly Price",
                                modifier = Modifier,
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = "N 6,000",
                                style = MaterialTheme.typography.body2
                            )

                        }

                    }

                        }

                    }


                }
            }
        }




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview7() {
    TutorFinderTheme {
        Greeting5(context = LocalContext.current)
    }
}