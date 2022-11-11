package com.example.circleever

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.circleever.data.DataProvider



@Composable
fun societyContent(navController:NavController){
    //val navController = rememberNavController()
    val societies = remember { DataProvider.societylist}
    LazyColumn(
       // contentPadding = PaddingValues(horizontal = 12.dp , vertical = 4.dp),
        modifier = Modifier
       // background(color = "#FCB144".color),
            .fillMaxSize(),
    ){
        items(
            items = societies,
            itemContent = {
                SocietyListItem(
                    society = it, navController = navController,
                )
            }
        )
    }

}