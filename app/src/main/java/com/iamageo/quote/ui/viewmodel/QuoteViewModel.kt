package com.iamageo.quote.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.quote.data.model.Quote
import com.iamageo.quote.domain.QuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel @ViewModelInject constructor(private val useCase: QuoteUseCase): ViewModel() {

    val quoteModel = MutableLiveData<Quote>()

    fun onCreate() {

        viewModelScope.launch {
            quoteModel.postValue(useCase()!!)
        }
    }

    fun randomQuote() {
        onCreate()
    }


}