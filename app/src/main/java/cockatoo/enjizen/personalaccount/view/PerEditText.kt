package cockatoo.enjizen.personalaccount.view

import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.os.Parcelable
import android.text.method.DigitsKeyListener
import android.text.style.TtsSpan
import android.util.AttributeSet
import android.view.View

import cockatoo.enjizen.personalaccount.R
import cockatoo.enjizen.personalaccount.view.state.BundleSavedState
import kotlinx.android.synthetic.main.edit_text_per.view.*
import android.text.InputFilter
import android.view.inputmethod.EditorInfo


class PerEditText : BaseCustomViewGroup {

    constructor(context: Context) : super(context) {
        initInflate()
        initInstances()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initInflate()
        initInstances()
        initWithAttrs(attrs, 0, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initInflate()
        initInstances()
        initWithAttrs(attrs, defStyleAttr, 0)
    }

    @TargetApi(21)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        initInflate()
        initInstances()
        initWithAttrs(attrs, defStyleAttr, defStyleRes)
    }

    private fun initInflate() {
        inflate(context, R.layout.edit_text_per, this)
    }

    private fun initInstances() {
    }

    private fun initWithAttrs(attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) {

        val typedArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.per_edit_text,
                defStyleAttr, defStyleRes)

        try {
            updateAttribute(typedArray)

        } finally {
            typedArray.recycle()
        }

    }

    private fun updateAttribute(typedArray: TypedArray?) {
        hintText.text = typedArray!!.getString(R.styleable.per_edit_text_hintText)
        editText.setText(typedArray.getString(R.styleable.per_edit_text_text))
        editText.isEnabled = typedArray.getBoolean(R.styleable.per_edit_text_enable,true)
        val inputType = typedArray.getInt(R.styleable.per_edit_text_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)

        editText.inputType = inputType

        val required = typedArray.getBoolean(R.styleable.per_edit_text_required,false)
        tvRequired.visibility = if(required) View.VISIBLE else View.GONE


        val filter = InputFilter { source, start, end, dest, dstart, dend ->
            val blockCharacterSet = context.getString(R.string.myAlphaNumeric)
            if (source != null && !blockCharacterSet.contains("" + source)) {
                ""
            } else null

        }

        editText.filters = arrayOf(filter)



    }

    override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()

// Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return BundleSavedState(superState)
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        val ss = state as BundleSavedState
        super.onRestoreInstanceState(ss.superState)

        val bundle = ss.bundle
        // Restore State from bundle here
    }

}
