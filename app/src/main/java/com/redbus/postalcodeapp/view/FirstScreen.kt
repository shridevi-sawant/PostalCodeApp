package com.redbus.postalcodeapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen( btnClick: (String) -> Unit){

    var pCode by remember {
        mutableStateOf("")
    }

    var isValid by remember {
        mutableStateOf(true)
    }
    
    Surface {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(value = pCode, onValueChange = {
                pCode = it
            }, placeholder = {
                Text(text = "Enter 6 digit postal code")
            } )

            Spacer(modifier = Modifier.size(40.dp))

            Button(onClick = {
                if (pCode.isEmpty()){
                    isValid = false
                }
                btnClick(pCode)
            }) {
                Text(text = "Show Places", fontSize = 30.sp)
            }
            
            if (!isValid){
                Text(text = "Please enter valid pincode",
                    color = Color.Red)
            }
        }
    }

}