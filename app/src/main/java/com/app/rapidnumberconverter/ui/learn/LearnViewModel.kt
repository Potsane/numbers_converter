package com.app.rapidnumberconverter.ui.learn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.rapidnumberconverter.common.LearnCardItem
import com.app.rapidnumberconverter.common.LearnCardItemClickListener
import com.app.rapidnumberconverter.repository.LearArticlesRepository
import com.app.rapidnumberconverter.ui.about.LaunchExternalPage
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.ui.base.ShowProgress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LearnViewModel @Inject constructor(
    private val learnArticlesRepository: LearArticlesRepository
) : BaseRapidNumbersViewModel(), LearnCardItemClickListener {

    private val _learnArticles = MutableLiveData<List<LearnCardItem>>()
    val learnArticles: LiveData<List<LearnCardItem>> = _learnArticles

    fun onResume() {
        if (_learnArticles.value == null) {
            fetchLearnArticles()
        }
    }

    private fun fetchLearnArticles() {
        viewModelScope.launch {
            postUiCommand(ShowProgress(true))
            try {
                learnArticlesRepository.fetchLearnArticles().let { response ->
                    if (response.isSuccessful) {
                        _learnArticles.value = response.body()
                    } else {
                        navigate(LearnFragmentDirections.learnToError())
                    }
                }
                postUiCommand(ShowProgress(false))

            } catch (exception: Exception) {
                navigate(LearnFragmentDirections.learnToError())
            }
        }
    }

    override fun onMoreButtonClick(item: LearnCardItem) {
        postUiCommand(LaunchExternalPage(item.url))
    }
}