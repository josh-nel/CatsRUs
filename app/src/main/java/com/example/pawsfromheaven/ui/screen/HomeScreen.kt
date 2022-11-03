package com.example.pawsfromheaven.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pawsfromheaven.R
import com.example.pawsfromheaven.data.PetData
import com.example.pawsfromheaven.data.PetList
import com.example.pawsfromheaven.ui.theme.DarkPink
import com.example.pawsfromheaven.ui.theme.Pink

@Composable
fun HomeScreen(navController: NavController){
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
                    Text("New Cats", style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold))
                    Spacer(Modifier.height(12.dp))
                }
                items(PetList.size){
                    item -> PetListItem(item = PetList[item], onCardClick = {
                        item -> navController.navigate("details/${item.id}")
                })



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
        Modifier.fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 24.sp,
            color = Color.White,
        ),
        maxLines = 1,
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
        ),

    )
}

@Composable
fun PetListItem(item:PetData, onCardClick : (PetData) -> Unit){
    Card(backgroundColor = Pink,
        modifier = Modifier
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(size = 8.dp))
            .background(Pink)
            .clickable(onClick = { onCardClick(item) }, enabled = true)
            .padding(4.dp),
        elevation = 0.dp
    ) {
        Column(Modifier.padding(8.dp)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(color = Color.Gray),
                        Alignment.Center
            ){
                Image(painter = painterResource(id = item.ImagePath),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize())
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(item.name, style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp))
            PetDetails(age = item.age, weight = item.weight )
        }
    }

}

@Composable
fun PetDetails(age:Int, weight: Double){
    Row(horizontalArrangement = Arrangement.SpaceBetween){
        Column (
            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
                ) {
            val year = if (age > 1) "Years" else "Year"
            Text("Weight", style = TextStyle(
                color = Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
                textAlign = TextAlign.Center
            )
            Text("$weight kg", textAlign = TextAlign.Center, color = Color(0xFFdfdfdf))
        }
    }
}