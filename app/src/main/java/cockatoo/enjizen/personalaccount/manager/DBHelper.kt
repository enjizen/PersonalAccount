package cockatoo.enjizen.personalaccount.manager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Wanchalerm Yuphasuk on 8/2/2018 AD.
 */
class DBHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, DB_NAME,null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.createTable("bank",true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE ,
                "name" to TEXT)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
      //  db!!.dropTable("bank")

    }



    private companion object {
        @JvmField
        val DB_VERSION = 1
        @JvmField
        val DB_NAME = "personalaccount"
    }





}