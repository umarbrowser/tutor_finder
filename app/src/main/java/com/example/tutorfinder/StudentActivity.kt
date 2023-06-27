package com.example.tutorfinder

import android.content.Context
import android.content.Intent
import android.graphics.Paint.Style
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tutorfinder.ui.theme.TutorFinderTheme
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.*

class StudentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2(LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun Greeting2( context: Context) {
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
                            painter = painterResource(id = R.drawable.umar),
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
                            text = "Umar Abdullahi",
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
                                imageVector = Icons.Default.Favorite,
                                contentDescription = null
                            )
                            Text(
                                text = "Tutors Saved",
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
                                text = "My Bookings",
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
               Tutors(context)
            }
        }

    }
}

@Composable
fun Tutors(context: Context) {
    val singapore = LatLng(10.3118884, 11.1843913)
    var uiSettings by remember { mutableStateOf(MapUiSettings()) }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }


    Column(modifier = Modifier.padding(15.dp)) {
        Card(modifier = Modifier, elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.tutor1),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp)
                        ,
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "Aminu Musa",
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.h5
                )
                Divider()
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Gender: Male",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Location: Federal Lowcost Gombe , Gome State",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Age: 34 Years",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Phone Number: 09056545644",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Availabilty: 1 Hours",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Day(s): Saturday, Thursday,",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Price: ₦ 1,500 /Hour",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Highest Qualification: Masters",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Card(elevation = 4.dp, modifier = Modifier.height(200.dp), shape = RoundedCornerShape(20.dp)) {
                    Column {
                        // WebViewPage("https://www.google.com/maps")

                        GoogleMap(
                            modifier = Modifier.fillMaxSize(),
                            //  cameraPositionState = cameraPositionState,
                            properties = properties,
                            uiSettings = uiSettings
                        ) {
                            Marker(
                                state = MarkerState(position = singapore),
                                title = "Singapore",
                                snippet = "Marker in Singapore"
                            )
                        }

                    }

                }




            }

        }
        Row(modifier = Modifier.padding(8.dp)) {
            OutlinedButton(
                onClick = { context.startActivity(Intent(context, SendMessageActivity::class.java))},
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null,
                )
                Spacer(Modifier.size(ButtonDefaults.IconSize))
                Text(
                    text = "Message",
                    style = MaterialTheme.typography.button
                )

            }
            OutlinedButton(
                onClick = { context.startActivity(Intent(context, BookTutorActivity::class.java)) },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = null
                )
                Spacer(Modifier.size(ButtonDefaults.IconSize))
                Text(
                    text = "Book Tutor",
                    style = MaterialTheme.typography.button
                )

            }
        }

    }
    Column(modifier = Modifier.padding(15.dp)) {
        Card(modifier = Modifier, elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
            Column {

                Image(
                    painter = painterResource(id = R.drawable.tutor2),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "Mr. Shehu Uthman",
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.h5
                )
                Divider()
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Gender: Male",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Location: Tudn Wada Shamaki Ward Gombe , Gombe State",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Age: 32 Years",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Phone Number: 09056545645",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Availabilty: 2 Hours",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Day(s): Wednesday, Thursday",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Price: ₦ 2,000 /Hour",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Highest Qualification: Masters",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Card(elevation = 4.dp, modifier = Modifier.height(200.dp), shape = RoundedCornerShape(20.dp)) {
                    Column {
                        // WebViewPage("https://www.google.com/maps")

                        GoogleMap(
                            modifier = Modifier.fillMaxSize(),
                            //  cameraPositionState = cameraPositionState,
                            properties = properties,
                            uiSettings = uiSettings
                        ) {
                            Marker(
                                state = MarkerState(position = singapore),
                                title = "Singapore",
                                snippet = "Marker in Singapore"
                            )
                        }

                    }

                }


            }

        }
        Row(modifier = Modifier.padding(8.dp)) {
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null
                )
                Spacer(Modifier.size(ButtonDefaults.IconSize))
                Text(
                    text = "Message",
                    style = MaterialTheme.typography.button
                )

            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = null
                )
                Spacer(Modifier.size(ButtonDefaults.IconSize))
                Text(
                    text = "Book Tutor",
                    style = MaterialTheme.typography.button
                )

            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    TutorFinderTheme {
        Greeting2(LocalContext.current)
    }
}