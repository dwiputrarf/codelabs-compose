package com.kodekita.codelabs.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodekita.codelabs.domain.usecase.UserDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userDataUseCase: UserDataUseCase) : ViewModel() {
    private val _data = MutableStateFlow("")

    val data: StateFlow<String> = _data

    fun loadData() {
        viewModelScope.launch {
            _data.value = userDataUseCase.getData()
        }
    }
}