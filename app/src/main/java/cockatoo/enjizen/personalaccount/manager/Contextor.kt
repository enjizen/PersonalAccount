package cockatoo.enjizen.personalaccount.manager

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
/**
 * Created by wanchalermyuphasuk on 2/2/2018 AD.
 */
 object Contextor {

    private var context: Context? = null


    fun init(context: Context){
        this.context = context
    }

    fun getContext() = context
}