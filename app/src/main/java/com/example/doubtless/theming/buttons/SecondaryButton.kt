package com.example.doubtless.theming.buttons

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.doubtless.R
import com.example.doubtless.utils.Utils.dpToPx

class SecondaryButton constructor(
    context: Context,
    attributeSet: AttributeSet?
) : CardView(context, attributeSet) {

    private var text = "" // create a separate data class for these.

    init {
        // set attributes
        val typedArray = context.theme.obtainStyledAttributes(
            /* set = */ attributeSet,
            /* attrs = */ R.styleable.PrimaryButton,
            /* defStyleAttr = */ 0,
            /* defStyleRes = */ 0
        )

        try {
            text = typedArray.getString(R.styleable.PrimaryButton_text) ?: ""
        } finally {
            typedArray.recycle()
        }

        // add textview
        val textView = TextView(context)
        this.addView(textView)

        // setup ui properties
        this.radius = 0.dpToPx() // fully rounded
        this.cardElevation = 0f
        this.setCardBackgroundColor(context.resources.getColor(R.color.cream))
        this.foreground = context.resources.getDrawable(R.drawable.seconday_button_border)

        textView.setTextColor(Color.BLACK)
        textView.text = text

        textView.typeface = resources.getFont(R.font.roboto_medium)

        val padding = 8.dpToPx().toInt()
        textView.setPadding(
            /* left = */ 14.dpToPx().toInt() + padding,
            /* top = */ padding,
            /* right = */ 14.dpToPx().toInt() + padding,
            /* bottom = */ padding
        )

        val lp = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        lp.gravity = Gravity.CENTER
        textView.layoutParams = lp

        textView.textSize = 18f

        // other properties
        isClickable = true
    }
}