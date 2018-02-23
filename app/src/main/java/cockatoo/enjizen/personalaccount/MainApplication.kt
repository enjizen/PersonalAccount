package cockatoo.enjizen.personalaccount

import android.app.Application
import cockatoo.enjizen.personalaccount.db.BankManager
import cockatoo.enjizen.personalaccount.manager.Contextor
import cockatoo.enjizen.personalaccount.manager.DBManager
import cockatoo.enjizen.personalaccount.manager.DBInstant
import cockatoo.enjizen.personalaccount.util.Log
import com.google.gson.Gson

/**
 * Created by wanchalermyuphasuk on 2/2/2018 AD.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Contextor.init(applicationContext)
        val myDatabaseOpenHelper =  DBManager(applicationContext)
        DBInstant.init(myDatabaseOpenHelper)

        BankManager.insertBankData()

        Log.i("MainApplication", "Result = " + Gson().toJson(BankManager.getBank(null)))
    }
}