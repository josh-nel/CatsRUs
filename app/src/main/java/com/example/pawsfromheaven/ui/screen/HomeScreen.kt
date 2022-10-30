package com.example.pawsfromheaven.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pawsfromheaven.R
import com.example.pawsfromheaven.ui.theme.DarkPink

@Composable
fun HomeScreen(){
    Scaffold() {
        Box(
            modifier = Modifier
                .background(DarkPink)
                .padding(24.dp)
                .fillMaxSize()
        ){
            LazyColumn() {
                item{
                    Header()
                    Spacer(modifier = Modifier.height(24.dp))
                    SearchField()
                    Spacer(modifier = Modifier.height(24.dp))
                    
                }
            }



        }
    }
}

@Composable
fun Header(name: String = "Josh"){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Greeting, $name",
                style = MaterialTheme.typography.h2,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )
            Text(
                text = "Come and find your new friend!!! $name",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }

        //Icon
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_pets_24),
            contentDescription = "paw icon",
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )

    }
}


//Text Field
@Composable
fun SearchField(){
    val textFieldValue = remember { mutableStateOf("")}
    TextField(
        value = textFieldValue.value,
        onValueChange = {value -> textFieldValue.value = value},
        textStyle = TextStyle(
            fontSize = 24.sp,
            color = Color.White,
        ),
        placeholder = {
            Text(
                text = "Type a cat name: ",
                color = Color.White,
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "Search Icon Button",
                tint = Color.White,
            )
        },

        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.White,
        )
    )
}