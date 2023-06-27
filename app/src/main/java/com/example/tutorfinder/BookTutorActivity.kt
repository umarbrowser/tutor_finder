package com.example.tutorfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorfinder.ui.theme.TutorFinderTheme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

class BookTutorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Booking()
                }
            }
        }
    }
}

@Composable
fun Booking(){
    LazyColumn(){
        items(1){
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
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
        Card(modifier = Modifier, elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
            Column {

                Text(
                    text = "Tutor's Subjects",
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
                        text = "Subject Name",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Proficiency (1-5)",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Divider()
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "English Language",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "2",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Mathematics",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "4",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Primary Science",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "3",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }


            }

        }
        Card(modifier = Modifier, elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
            Column {

                Text(
                    text = "Educational Certicate",
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.h5
                )
                Divider()
                Image(
                    painter = painterResource(id = R.drawable.cert1),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp)
                    ,
                    contentScale = ContentScale.Fit
                )

            }

        }
        Row(){
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Cancel Booking",
                    style = MaterialTheme.typography.button
                )

            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Save Tutor",
                    style = MaterialTheme.typography.button
                )

            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Book Tutor",
                    style = MaterialTheme.typography.button
                )

            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    TutorFinderTheme {
        Greeting()
    }
}