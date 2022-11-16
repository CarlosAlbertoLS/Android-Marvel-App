package com.sonder.marvelapplication.characters.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonder.marvelapplication.characters.data.CharactersRepository
import com.sonder.marvelapplication.characters.data.CharactersRepositoryImp
import com.sonder.marvelapplication.characters.data.network.response.CharactersResponse
import com.sonder.marvelapplication.characters.domain.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterUseCase: CharactersRepositoryImp,
    private val characterRepo: CharactersRepository
) : ViewModel() {
    private val _name = MutableLiveData<String>()
    var name: LiveData<String> = _name

    fun onLoginSelected() {
        viewModelScope.launch {
            Log.i("result", characterUseCase.charactersResponse().data.results.toString())
            _name.value = characterUseCase.charactersResponse().data.results.toString()
            name = _name
        }
    }
}
