package com.mikeni.records.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mikeni.records.data.entities.Record
import com.mikeni.records.data.repository.RecordRepository
import com.mikeni.records.utils.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber


@ExperimentalCoroutinesApi
class RecordViewModel @ViewModelInject constructor(
    private val repository: RecordRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState = MutableLiveData<DataState<List<Record>>>()
    val dataState: LiveData<DataState<List<Record>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetRecordEvents -> {
                    repository.getRecords()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> Timber.d("None")
            }
        }
    }
}

sealed class MainStateEvent {
    object GetRecordEvents : MainStateEvent()
    object None : MainStateEvent()
}