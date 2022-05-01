package com.app.rapidnumberconverter.ui.common

import android.content.Context
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.common.LearnCardItem
import com.app.rapidnumberconverter.common.LearnCardItemClickListener
import com.app.rapidnumberconverter.databinding.ItemLearnCardBinding

class CollapsibleCard(
    context: Context,
    attributeSet: AttributeSet? = null
) : LinearLayout(context, attributeSet) {

    private var binding: ItemLearnCardBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.item_learn_card,
        this,
        true
    )

    var item: LearnCardItem? = null
        set(value) {
            field = value
            binding.item = value
        }

    var clickListener: LearnCardItemClickListener? = null
        set(value) {
            field = value
            binding.clickListener = value
        }

    init {
        binding.imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_down)
        binding.imageViewArrow.setOnClickListener {
            //binding.imageViewArrow.setBackgroundResource(0);
            if (binding.group.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(binding.cardView, AutoTransition())
                binding.group.visibility = View.GONE
                binding.imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_down)
            } else {
                binding.group.visibility = View.VISIBLE
                binding.imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_up)
            }
        }
    }
}