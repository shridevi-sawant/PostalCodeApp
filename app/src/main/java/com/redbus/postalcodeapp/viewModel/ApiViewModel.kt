package com.redbus.postalcodeapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redbus.postalcodeapp.model.GeonamesInterface
import com.redbus.postalcodeapp.model.Place
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiViewModel: ViewModel() {

    var placeList = MutableLiveData<List<Place>> ()

    fun fetchPlaces(postalCode: String){

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = GeonamesInterface.getInstance().getPlaces(postalCode)
                placeList.postValue(response.postalCodes)
                Log.d("ApiViewModel", "Got places: ${response.postalCodes.size}")
            }catch (err: Exception){
                Log.d("ApiViewModel", "Error: ${err.localizedMessage}")
            }
        }
    }
}