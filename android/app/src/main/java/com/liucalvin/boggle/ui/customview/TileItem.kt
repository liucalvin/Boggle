package com.liucalvin.boggle.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.liucalvin.boggle.R
import kotlin.math.max

class TileItem @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attributeSet, defStyle) {

    init {

        isAllCaps = true
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        height = ViewGroup.LayoutParams.WRAP_CONTENT
        textAlignment = TEXT_ALIGNMENT_CENTER

        setTileState(false)

    }

    private fun setTileState(isSelected: Boolean = false) {
        setBackgroundResource(
            if (isSelected) {
                R.drawable.item_letter_background
            } else {
                R.drawable.item_letter_selected_background
            }
        )
        setBackgroundResource(R.drawable.item_letter_background)
        setTextColor(ContextCompat.getColor(context, R.color.light_text))
        textSize = resources.getDimension(R.dimen.tile_letter_size)
        setTextAppearance(R.style.TileLetter)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                performClick()
                setTileState(true)
            }
            MotionEvent.ACTION_MOVE -> performClick()
            MotionEvent.ACTION_UP -> motionComplete()
        }
        return false
    }

    private fun motionComplete() {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        val height = measuredHeight
        val dimen = max(width, height)
        setMeasuredDimension(dimen, dimen)
    }

    override fun performClick(): Boolean {
        super.performClick()

        return true
    }


}