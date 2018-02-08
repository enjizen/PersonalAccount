package cockatoo.enjizen.personalaccount.view

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cockatoo.enjizen.personalaccount.R
import cockatoo.enjizen.personalaccount.constanst.Constant
import kotlinx.android.synthetic.main.fragment_alert_dialog.*

/**
 * Created by wanchalermyuphasuk on 6/2/2018 AD.
 */
class AlertDialogFragment : DialogFragment() {



    private var message: String? = null
    private var positive: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (savedInstanceState) {
            null -> restoreArguments(arguments)
            else -> onRestoreInstanceState(savedInstanceState)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater!!.inflate(R.layout.fragment_alert_dialog,container,false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvMessage.text = message
        btnPositive.setText(positive)

        btnPositive.setOnClickListener {
            getAlertDialogListener()?.onPositiveButtonClick()
            dismiss()
        }

    }

    private fun getAlertDialogListener() : AlertDialogListener? {
        val fragment = parentFragment
        try{
            return if(fragment != null){
                fragment as AlertDialogListener
            } else{
                activity as AlertDialogListener
            }
        }catch (ignored: ClassCastException){

        }

        return null
    }


    private fun restoreArguments(bundle: Bundle){
        message = bundle.getString(Constant.KEY_MESSAGE)
        positive = bundle.getInt(Constant.KEY_POSITIVE)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState!!.putString(Constant.KEY_MESSAGE,message)
        outState.putInt(Constant.KEY_POSITIVE,positive)
    }

    private fun onRestoreInstanceState(savedInstanceState: Bundle?){
        message = savedInstanceState!!.getString(Constant.KEY_MESSAGE)
        positive = savedInstanceState.getInt(Constant.KEY_POSITIVE)
    }


    interface AlertDialogListener {
        fun onPositiveButtonClick()
    }


    class Builder {
        private var message: String? = null
        private var positive: Int = 0

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setPositive(@StringRes positive: Int): Builder {
            this.positive = positive
            return this
        }


        fun build(): AlertDialogFragment {
            return AlertDialogFragment.newInstance(message!!, positive)
        }
    }




    companion object {
        fun newInstance(message: String, @StringRes positive: Int) : AlertDialogFragment{
            val fragment = AlertDialogFragment()
            val bundle = Bundle()
            bundle.putString(Constant.KEY_MESSAGE,message)
            bundle.putInt(Constant.KEY_POSITIVE,positive)
            fragment.arguments = bundle
            return fragment

        }
    }


}