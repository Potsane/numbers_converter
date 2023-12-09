package com.app.rapidnumberconverter.ui.learn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.rapidnumberconverter.common.ContentCardItem
import com.app.rapidnumberconverter.repository.LearArticlesRepository
import com.app.rapidnumberconverter.ui.about.LaunchExternalPage
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.ui.base.ShowProgress
import com.app.rapidnumberconverter.utils.mockLearnItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

@HiltViewModel
class LearnViewModel @Inject constructor(
    private val learnArticlesRepository: LearArticlesRepository
) : BaseRapidNumbersViewModel() {

    private val _learnArticles = MutableLiveData<List<ContentCardItem>>()
    val learnArticles: LiveData<List<ContentCardItem>> = _learnArticles

    fun onResume() {
        if (_learnArticles.value == null) {
            fetchLearnArticles()
        }
    }

    //TODO (Make API Call)
    private fun fetchLearnArticles() {
        viewModelScope.launch {
            postUiCommand(ShowProgress(true))
            try {
                throw RuntimeException()
                learnArticlesRepository.fetchLearnArticles().let { response ->
                    _learnArticles.value = mockLearnItems
                    //Fix service
                    /*if (response.isSuccessful) {
                        _learnArticles.value = response.body()
                    } else {
                        navigate(LearnFragmentDirections.learnToError())
                    }*/
                }
                postUiCommand(ShowProgress(false))

            } catch (exception: Exception) {
                navigate(LearnFragmentDirections.learnToError())
            }
        }
    }

    fun onMoreButtonClick(item: ContentCardItem) {
        postUiCommand(LaunchExternalPage(item.action.url))
    }
}