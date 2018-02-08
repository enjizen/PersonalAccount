package cockatoo.enjizen.personalaccount.util

import android.support.annotation.StringRes
import android.support.v4.app.FragmentManager
import cockatoo.enjizen.personalaccount.view.AlertDialogFragment

/**
 * Created by wanchalermyuphasuk on 6/2/2018 AD.
 */
object DialogUtil {

    fun showAlertDialog(fragmentManager: FragmentManager, message: String, @StringRes positiveButton: Int) {
        val alertDialogFragment = AlertDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positiveButton)
                .build()

        alertDialogFragment.isCancelable = false
        alertDialogFragment.show(fragmentManager, "alert dialog")

    }
}