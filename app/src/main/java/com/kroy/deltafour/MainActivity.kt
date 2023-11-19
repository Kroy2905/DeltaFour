package com.kroy.deltafour
import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kroy.deltafour.ui.theme.ExpandableTint
import com.kroy.deltafour.ui.theme.appColor
import java.util.*

class MainActivity : ComponentActivity() {
    lateinit var  context:Context


    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreenContent()
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun MyScreenContent() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
            .background(Color.White)
    ) {
        item {
            StatusBar()
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            CollapseAllButton()
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Use LazyColumn for vertical scrolling
        item {
            CollapsibleSection(title = "Work Summary", "",expanded = false) {
                // Content of Section 1

                WorkSummarySection(workSummary = "", onWorkSummaryChange = {  })
                // Add a DropdownMenu and selected item display below the Work Summary
               // Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Type Of Work",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp

                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "(Add more than 1 if needed)",
                        fontSize = 10.sp

                    )

                }
                WorkSummaryDropdown()
                Row(Modifier.padding(5.dp)) {
                    Text(
                        text = "Start Time",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontSize = 15.sp

                    )
                }
               DatePickerBox(context = LocalContext.current)

                Row(Modifier.padding(5.dp)) {
                    Text(
                        text = "End Time",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontSize = 15.sp

                    )
                }
                DatePickerBox(context = LocalContext.current)

            }
        }
        item {
            CollapsibleSection(title = "General GuideLines","(Tick all possible)", expanded = false) {
                // Content of Section 2
                Switch(content = "Work area free from combustible/flammable/toxic material?")
                Switch(content = "Manholes,catch pits/basin,sewer connections are covered?")


            }
        }
        item {
            CollapsibleSection(title = "PPEs Selection", "(Tick all apllicable fields)",expanded = false) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,

                ) {
                    CheckBoxWithText(text = "Safety Glasses",15.sp)

                    Spacer(modifier = Modifier.width(50.dp)) // Adjust the width as needed

                    CheckBoxWithText(text = "Barricades",15.sp,)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    CheckBoxWithText(text = "Isolation Required ?",24.sp,Color.Red)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    Text(
                        text = "Location of Isolation",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        fontSize = 15.sp

                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 0.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    val indianLocations = listOf(
                        "Mumbai", "Delhi", "Bangalore", "Hyderabad", "Chennai",
                        "Kolkata", "Jaipur", "Pune", "Ahmedabad", "Lucknow",
                        "Kochi", "Chandigarh", "Bhopal", "Indore", "Goa"
                    )

                    CustomDropdown(customItems = indianLocations,"Equipment" )
                }



                // Content of Section 3
            }
        }
        item {
            CollapsibleSection(title = "Part 2:Isolation Details","(Tick all apllicable fields)", expanded = false) {
                // Content of Section 4
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    val customItemList = listOf(
                        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                        "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"
                    )


                    CustomDropdown(customItems = customItemList,"Select Isolation Point(s)" )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    Text(
                        text = "Add isolation Users",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        fontSize = 15.sp

                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 0.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    val customItemList = listOf(
                        "User 1", "User 2", "User 3", "User 4", "User 5",
                        "User 6", "User 7", "User 8", "User 9", "User 10"
                    )



                    CustomDropdown(customItems = customItemList,"Isolation Officer" )
                }


            }
        }
        item {
            CollapsibleSection(title = "PART:3 User Declaration","", expanded = false) {
                // Content of Section 5
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    Text(
                        text = "Select Permit Issuing Authority",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        fontSize = 15.sp

                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 0.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    val customItemList = listOf(
                        "Name 1", "Name 2", "Name 3", "Name 4", "Name 5",
                        "Name 6", "Name 7", "Name 8", "Name 9", "Name 10"
                    )



                    CustomDropdown(customItems = customItemList,"Select Permit Issuer Name" )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    Text(
                        text = "Select Receiver",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        fontSize = 15.sp

                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 0.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    val customItemList = listOf(
                        "Name 1", "Name 2", "Name 3", "Name 4", "Name 5",
                        "Name 6", "Name 7", "Name 8", "Name 9", "Name 10"
                    )




                    CustomDropdown(customItems = customItemList,"Myself" )
                }
            }
        }
        item {
            CollapsibleSection(title = "Manpower Details","", expanded = false) {
                // Content of Section 5
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 10.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Technicians Involved   ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp

                    )
                    Text(
                        text = "(Add more than 1 if needed)",
                        fontSize = 10.sp

                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 0.dp)
                    ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ){
                    val customItemList = listOf(
                        "Name 1", "Name 2", "Name 3", "Name 4", "Name 5",
                        "Name 6", "Name 7", "Name 8", "Name 9", "Name 10"
                    )



                    CustomDropdown(customItems = customItemList,"Select Person(s) involved" )
                }

            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            CheckBoxWithText("Save it to Auto Fill",15.sp)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            SubmitApplicationButton()
        }
    }
}
@Composable
fun Switch(content:String) {
    var switchState by remember { mutableStateOf(true) }


    val switchColors = SwitchDefaults.colors(
        checkedThumbColor = Color.White,
        uncheckedThumbColor = Color.White,
        checkedTrackColor = appColor,
        uncheckedTrackColor = Color.Red,
    )

    Surface(
        modifier = Modifier
            .padding(10.dp)
            .border(1.dp, Color.Gray),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(10.dp, 0.dp)
                ,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Text on the left side
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(10.dp, 7.dp)
                        .weight(0.8f)
                        .background(Color.Transparent),
                    contentAlignment = Alignment.CenterStart
                ) {
                    // Overlay Text on the Switch Thumb
                    Text(
                        text = "$content",
                        color = Color.Black,
                        fontSize = 14.sp,
                    )
                }




                // Switch on the right side
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(10.dp, 7.dp)
                        .background(Color.Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    Switch(
                        checked = switchState,
                        onCheckedChange = { newState -> switchState = newState },
                        colors = switchColors,
                        modifier = Modifier.size(30.dp, 20.dp) // Adjust width and height as needed
                    )

                    // Overlay Text on the Switch Thumb
                    Text(
                        text = if (switchState) "Y" else "N",
                        color = if (switchState) appColor else Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = if (switchState) 14.sp else 11.sp,
                        modifier = if (switchState) Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp) else Modifier.padding(0.dp, 10.dp, 20.dp, 8.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun DatePickerBox(context: Context) {
    var isDatePickerVisible by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isDatePickerVisible = true }
            .padding(10.dp, 5.dp)
            .border(1.dp, Color.Gray)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Date Picker
            showDatePicker(selectedDate)

            // Calendar icon
            Icon(
                painter = painterResource(id = R.drawable.ic_calender),
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp)
                    .clickable {
                        isDatePickerVisible = true
                    }
            )
        }
    }

    if (isDatePickerVisible) {
        // Show date picker dialog
        showDatePickerDialog(context) { year, month, day ->
            selectedDate = "$day/$month/$year"
            isDatePickerVisible = false
        }
    }
}

@Composable
fun showDatePicker(selectedDate: String) {
    Column(
        modifier = Modifier

            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text =   selectedDate.takeIf { it.isNotBlank() } ?: "Select",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Start,

        )
    }
}


fun showDatePickerDialog(context: Context, onDateSelected: (Int, Int, Int) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DATE)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            onDateSelected(year, month, dayOfMonth)
        },
        year, month, day
    )

    datePickerDialog.show()
}

@Composable
fun WorkSummaryDropdown() {
    // Define the items for the dropdown
    val dropdownItems = remember { mutableStateListOf("Cold Work", "Breaking of Pipeline", "Option 3","Option 4") }

    // State to hold the selected items from the dropdown
    val selectedDropdownItems = remember { mutableStateListOf<String>() }

    // State to manage the dropdown visibility
    var expanded by remember { mutableStateOf(false) }

    // Display the dropdown and selected items
    Column(Modifier
        .padding(10.dp)) {
        // Display selected items above the dropdown
        selectedDropdownItems.forEach { selectedItem ->
            Box(modifier = Modifier
                .wrapContentWidth()
                .padding(5.dp)
            ){
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .background(Color.LightGray)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = selectedItem,
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(12.dp),
                        fontSize = 12.sp

                    )


                    // Cross Icon
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cross),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(15.dp)
                    )
                }
            }





        }

        // Dropdown and selected item display
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black) // Border for the box
                .padding(16.dp) // Padding for the box
                .clickable {
                    expanded = !expanded
                },
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Display the selected items
                if (selectedDropdownItems.isEmpty()) {
                    Text(text = "Select an item", modifier = Modifier.weight(1f))
                } else {
                    Text(text = selectedDropdownItems.joinToString(", "), modifier = Modifier.weight(1f))
                }

                // Arrow down icon
                Image(
                    painter = painterResource(id =R.drawable.ic_arrow_down ),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // DropdownMenu
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            expanded = expanded,
            onDismissRequest = {
                // Handle dismiss if needed
                expanded = false
            }
        ) {
            dropdownItems.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(text = item)
                    },
                    onClick = {
                        // Update the selected items when clicked
                        selectedDropdownItems.add(item)
                        // Close the dropdown
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CustomDropdown(
    customItems: List<String>,
    defaultText: String = "Select an item"
) {
    // State to hold the selected items from the dropdown
    val selectedDropdownItems = remember { mutableStateListOf<String>() }

    // State to manage the dropdown visibility
    var expanded by remember { mutableStateOf(false) }

    // Display the dropdown and selected items
    Column(Modifier.padding(5.dp)) {
        // Dropdown and selected item display
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black) // Border for the box
                .padding(10.dp) // Padding for the box
                .clickable {
                    expanded = !expanded
                },
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Display the selected items
                if (selectedDropdownItems.isEmpty()) {
                    Text(text = defaultText, modifier = Modifier.weight(1f))
                } else {
                    Text(
                        text = selectedDropdownItems.joinToString(", "),
                        modifier = Modifier.weight(1f)
                    )
                }

                // Arrow down icon
                Image(
                    painter = painterResource(id =R.drawable.ic_arrow_down ),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // DropdownMenu
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            expanded = expanded,
            onDismissRequest = {
                // Handle dismiss if needed
                expanded = false
            }
        ) {
            customItems.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(text = item)
                    },
                    onClick = {
                        // Update the selected items when clicked
                        selectedDropdownItems.add(item)
                        // Close the dropdown
                        expanded = false
                    }
                )
            }
        }
    }
}












@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkSummarySection(workSummary: String, onWorkSummaryChange: (String) -> Unit) {
    val state = remember {
        mutableStateOf("")
    }


        OutlinedTextField(
            value = state.value,
            onValueChange = { state.value=it },
            leadingIcon = {
                // You can replace this with your pen icon image
                Icon(
                    painter = painterResource(id = R.drawable.ic_pen),
                    contentDescription = null
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                        focusedBorderColor = Color.Gray , // Set the color when focused
                unfocusedBorderColor = Color.Gray , // Set the color when not focused
                        cursorColor = Color.Gray,  // Set the cursor color
                textColor = Color.Gray  // Set the text color


            ),

            label = { Text("Description of Work") },

            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        )



}






@Composable
fun CheckBoxWithText(text: String, fontSize: TextUnit = 14.sp,txtColor:Color = Color.Black) {
    var saveAutoFill by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = saveAutoFill,
            onCheckedChange = { isChecked -> saveAutoFill = isChecked },
            colors = CheckboxDefaults.colors(
                checkedColor = appColor,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White,

            ),
            modifier = Modifier
                .size(30.dp,20.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = text, fontSize = fontSize, color =txtColor)
    }
}


@Composable
fun SubmitApplicationButton() {
    Button(
        onClick = { /* Handle collapse all button click */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = appColor,

            contentColor = Color.White
        ),
        shape = RectangleShape, // Use RectangleShape for a rectangular button
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Text("Submit Application")
    }

}


@Composable
fun StatusBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = appColor) // Set the background color
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = appColor), // Set the background color
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = { /* Handle back button click */ },
                    modifier = Modifier.background(color = appColor) // Set the background color
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp)) // Add space between back icon and title
                Text(
                    "Create Safety Work Permit",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White // Set the text color
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp), // Adjust the padding as needed
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    painter = painterResource(id =R.drawable.ic_save),
                    contentDescription = "Save",
                    tint = Color.White // Set the icon color
                )
                Spacer(modifier = Modifier.width(25.dp)) // Add space between save icon and text
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp), // Adjust the padding as needed
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text("Manage Auto Fill", fontSize = 10.sp, color = Color.White) // Set the text color
        }
    }
}






@Composable
fun CollapseAllButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = { /* Handle collapse all button click */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .border(1.dp, appColor)
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_collapse),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text("Collapse All", color = appColor)
        }

    }
}

@Composable
fun CollapsibleSection(
    title: String,
    additionalInfo: String,
    expanded: Boolean,
    content: @Composable () -> Unit
) {
    var isExpanded by remember { mutableStateOf(expanded) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(ExpandableTint)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.width(10.dp)) // Spacer to push the Image to the end

            Text(
                text = additionalInfo,
                fontSize = 8.sp
            )

            Spacer(modifier = Modifier.weight(1f)) // Spacer to push the Image to the end

            // Wrap the Image with Clickable modifier
            Image(
                painter = if (isExpanded) painterResource(id = R.drawable.ic_arrow_up)
                else painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
                    .clickable { isExpanded = !isExpanded }
            )
        }

        if (isExpanded) {
            content()
        }
    }
}

