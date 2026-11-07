package com.example.sharedflowdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class DemoViewModel: ViewModel() {
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        sharedFlowInit()
    }

    fun sharedFlowInit() {
        viewModelScope.launch {
            for (i in 1..100) {
                delay(2000.milliseconds)
                println("Emitting $i")
                _sharedFlow.emit(i)
            }
        }
    }
}