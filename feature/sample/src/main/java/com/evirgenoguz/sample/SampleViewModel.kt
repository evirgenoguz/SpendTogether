package com.evirgenoguz.sample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.domain.GetSampleDataUseCase
import com.evirgenoguz.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val getSampleDataUseCase: GetSampleDataUseCase
) : BaseViewModel() {

    private val _sampleScreenUiState = MutableLiveData<SampleScreenUiState>()
    val sampleScreenUiState: LiveData<SampleScreenUiState> get() = _sampleScreenUiState


    fun getSampleData() {
        viewModelScope.launch {
            getSampleDataUseCase().collect { response ->
                when (response) {
                    is ResponseState.Loading -> {
                        _sampleScreenUiState.postValue(SampleScreenUiState.Loading)
                    }

                    is ResponseState.Success -> {
                        _sampleScreenUiState.postValue(
                            SampleScreenUiState.Success(
                                SampleDataUiState(
                                    id = response.data.id,
                                    user = response.data.user,
                                    lambda = {
                                        Log.d("SampleViewModel", "Burası deneme sadece")
                                    }
                                )
                            )
                        )
                    }

                    is ResponseState.Error -> {
                        _sampleScreenUiState.postValue(SampleScreenUiState.Error(response.message))
                    }
                }
            }
        }
    }

}


sealed class SampleScreenUiState {
    object Loading : SampleScreenUiState()
    data class Error(val message: String) : SampleScreenUiState()
    data class Success(val data: SampleDataUiState) : SampleScreenUiState()
}

data class SampleDataUiState(
    val id: Int,
    val user: String,
    val lambda: () -> Unit //onFavorite vs. buraya örnek olabilir.
)
