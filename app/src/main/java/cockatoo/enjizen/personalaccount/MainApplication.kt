package cockatoo.enjizen.personalaccount

import android.app.Application
import cockatoo.enjizen.personalaccount.manager.Contextor

/**
 * Created by wanchalermyuphasuk on 2/2/2018 AD.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
       Contextor.init(applicationContext)
    }
}