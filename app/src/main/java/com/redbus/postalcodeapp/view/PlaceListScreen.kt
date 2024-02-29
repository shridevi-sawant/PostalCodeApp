package com.redbus.postalcodeapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.redbus.postalcodeapp.model.Place
import com.redbus.postalcodeapp.viewModel.ApiViewModel

@Composable
fun PlaceListScreen(pCode: String, vModel: ApiViewModel = viewModel()){

    vModel.fetchPlaces(pCode)

    val pList = vModel.placeList.observeAsState()
    
    pList.value?.let {
        if (it.isNotEmpty()){
            Text(text = "Count of places: ${it.size}")
            ShowList(list = it)

        }else {
            Text(text = "Could not get places")
        }
    }
}

@Composable
fun ShowList(list: List<Place>){

    Surface {
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(list){
                ShowPlace(it)
            }
        }
    }
}

@Composable
fun ShowPlace(place: Place){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Cyan)

        ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
            Text(text = "${place.placeName}" , fontSize = 30.sp)
            Text(text = "City: ${place.adminName1}")
            Text(text = "State:${place.adminName2}")
            Text("CountryCode: ${place.countryCode}")
        }
    }
}