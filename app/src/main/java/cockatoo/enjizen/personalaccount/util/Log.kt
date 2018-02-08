package cockatoo.enjizen.personalaccount.util

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
object Log: AnkoLogger {

    val isShow = true

    fun i(tag: String, msg: String){
        if(isShow) {
            info { "$tag : $msg" }
        }
    }
}