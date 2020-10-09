package com.mikeni.records.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mikeni.records.R
import com.mikeni.records.data.entities.Record
import com.mikeni.records.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: RecordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetRecordEvents)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Record>> -> {
                    displayProgressBar(false)
                    Timber.d("Data: ${dataState.data}")
                    appendRecordTitles(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        message?.let { Timber.d(it) } ?: Timber.d("Unknown error")
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        Timber.d("Is displayed $isDisplayed")
    }

    private fun appendRecordTitles(records: List<Record>) {
        val delitos = records.joinToString { it.fields.delito }
        Timber.d("Delitos $delitos")
    }
}