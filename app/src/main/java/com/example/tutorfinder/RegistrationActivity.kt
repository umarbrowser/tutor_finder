package com.example.tutorfinder

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorfinder.ui.theme.TutorFinderTheme
import java.util.*

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RegisterScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
) {
    val options = listOf("Select an option", "Tutor", "Student", "Parent")
    var selectedOptionText by remember {
        mutableStateOf(options[0])
    }
    var expanded by remember { mutableStateOf(false) }

    // Gender
    val optionsGender = listOf("Select an option", "Male", "Female")
    var selectedOptionTextGender by remember {
        mutableStateOf(optionsGender[0])
    }
    var expandedGender by remember { mutableStateOf(false) }

    // Gender
    val optionsCountry = listOf("Select an option", "Nigerian", "Non Nigerian")
    var selectedOptionTextCountry by remember {
        mutableStateOf(optionsCountry[0])
    }
    var expandedCountry by remember { mutableStateOf(false) }

    // Gender
    val optionsState = listOf("Select State Here", "Abia", "Adamawa", "Akwa Ibom", "Anambra", "Bauchi", "Bayelsa", "Benue", "Borno", "Cross River", "Delta", "Ebonyi", "Edo", "Ekiti", "Enugu", "FCT(Abuja)", "Gombe", "Imo", "Jigawa", "Kaduna", "Kano", "Katsina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nasarawa", "Niger", "Ogun", "Ondo", "Osun", "Oyo", "Plateau", "Rivers", "Sokoto", "Taraba", "Yobe", "Zamfara")
    var selectedOptionTextState by remember {
        mutableStateOf(optionsState[0])
    }
    var expandedState by remember { mutableStateOf(false) }

    val accountType = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    // Fetching the Local Context
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring a string value to
    // store date in string format
    val mDate = remember { mutableStateOf("") }
    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, mYear, mMonth, mDay
    )

    LazyColumn(
    ) {
        items(1) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Registration",
                    modifier = Modifier.padding(start = 30.dp, bottom = 10.dp, end = 30.dp),
                    style = MaterialTheme.typography.h2)

                Text(
                    text = "Personal Information",
                    modifier = Modifier.padding(start = 30.dp, bottom = 10.dp, end = 30.dp),
                    style = MaterialTheme.typography.h5
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
                        label = { Text("Account Type") },
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
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    singleLine = true,
                    modifier = modifier,
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = {
                        Text(
                            "First Name" +
                                    ""
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    singleLine = true,
                    modifier = modifier,
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = {
                        Text(
                            "Last Name" +
                                    ""
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        mDatePickerDialog.show()
                    },
                ) {
                    Text(text = "Date Of Birth")
                }
                Spacer(modifier = Modifier.height(10.dp))
                ExposedDropdownMenuBox(
                    expanded = expandedGender,
                    onExpandedChange = {
                        expandedGender = !expandedGender
                    }
                ) {
                    TextField(
                        readOnly = true,
                        value = selectedOptionTextGender,
                        onValueChange = { },
                        label = { Text("Gender") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expandedGender
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expandedGender,
                        onDismissRequest = {
                            expandedGender = false
                        }
                    ) {
                        optionsGender.forEach { selectionOption ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedOptionTextGender = selectionOption
                                    expandedGender = false
                                }
                            ) {
                                Text(text = selectionOption)
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    singleLine = true,
                    modifier = modifier,
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = {
                        Text(
                            "Phone Number" +
                                    ""
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                ExposedDropdownMenuBox(
                    expanded = expandedCountry,
                    onExpandedChange = {
                        expandedCountry = !expandedCountry
                    }
                ) {
                    TextField(
                        readOnly = true,
                        value = selectedOptionTextCountry,
                        onValueChange = { },
                        label = { Text("Country Of Residence") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expandedCountry
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expandedCountry,
                        onDismissRequest = {
                            expandedCountry = false
                        }
                    ) {
                        optionsCountry.forEach { selectionOption ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedOptionTextCountry = selectionOption
                                    expandedCountry = false
                                }
                            ) {
                                Text(text = selectionOption)
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                ExposedDropdownMenuBox(
                    expanded = expandedState,
                    onExpandedChange = {
                        expandedState = !expandedState
                    }
                ) {
                    TextField(
                        readOnly = true,
                        value = selectedOptionTextState,
                        onValueChange = { },
                        label = { Text("State Of Residence") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expandedState
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expandedState,
                        onDismissRequest = {
                            expandedState = false
                        }
                    ) {
                        optionsState.forEach { selectionOption ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedOptionTextState = selectionOption
                                    expandedState = false
                                }
                            ) {
                                Text(text = selectionOption)
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
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
                        label = { Text("Local Government Of Residence ") },
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
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    singleLine = true,
                    modifier = modifier,
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = {
                        Text(
                            "Email Address" +
                                    ""
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
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
                        label = { Text("Marital Status") },
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
                Spacer(modifier = Modifier.height(10.dp))
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
                        label = { Text("Religion") },
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
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    singleLine = true,
                    modifier = modifier,
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = {
                        Text(
                            "Contact Address" +
                                    ""
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Login Details",
                    modifier = Modifier.padding(start = 30.dp, bottom = 10.dp, end = 30.dp),
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    singleLine = true,
                    modifier = modifier,
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = {
                        Text(
                            "Password" +
                                    ""
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    singleLine = true,
                    modifier = modifier,
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = {
                        Text(
                            "Confirm Password" +
                                    ""
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))


            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    TutorFinderTheme {
        RegisterScreen()
    }
}