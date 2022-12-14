package com.example.pawsfromheaven.ui.screen

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pawsfromheaven.data.PetData
import com.example.pawsfromheaven.ui.theme.Pink

@Composable
fun DetailScreen(navController: NavController, petData : PetData){
    //Text("${petData.name}")

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White )
                    }
                },
                modifier = Modifier.height(68.dp),
                title = { Text(text = "Kittens ", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
                actions = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = null, tint = Color.White)
                }},
                        //add cat emoji here after the word kitte
                elevation = 0.dp,
                backgroundColor = Pink,
                contentColor = Color.White,
            )
        },
        bottomBar = {
            Row(Modifier.padding(16.dp)){
                Button(
                    onClick = { /*TODO*/ },
                    Modifier
                        .fillMaxWidth()
                        .height(53.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text("Support Me", style = MaterialTheme.typography.h5)
                }
            }
        },
        backgroundColor = Pink,
        contentColor = Color.White
    ) {
        Body(Modifier.padding(16.dp), petData = petData)
    }
}

@Composable
fun Body(modifier: Modifier,petData: PetData){
    Column(modifier = modifier) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(280.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        ){
            Image(painter = painterResource(id = petData.ImagePath), contentDescription =null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize() )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(petData.name, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            val mod = Modifier
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .weight(1F)
                .background(Color.DarkGray)
                .padding(all = 8.dp)
            DetailsBox(title = "Gender", info = "${petData.sex}",mod)
            Spacer(modifier = Modifier.width(6.dp))
            DetailsBox(title = "Age", info = "${petData.age}",mod)
            Spacer(modifier = Modifier.width(6.dp))
            DetailsBox(title = "Weight", info = "${petData.weight}",mod)
            Spacer(modifier = Modifier.width(6.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text("Summary", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(12.dp))
        Text("This is the most adorable Cat you'll ever see in your Life", style = MaterialTheme.typography.body2)
    }
}

@Composable
fun DetailsBox(title:String, info:String, modifier: Modifier = Modifier){
    Box(modifier = modifier){
        Column() {
            Text(text = title, Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text(text = info, Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}