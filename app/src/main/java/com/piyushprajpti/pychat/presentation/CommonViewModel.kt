package com.piyushprajpti.pychat.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(

) : ViewModel() {

    fun onResetPassword(email: String, callBack: () -> Unit) {
        viewModelScope.launch {

        }
    }
}