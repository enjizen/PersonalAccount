package cockatoo.enjizen.personalaccount.manager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import cockatoo.enjizen.personalaccount.constanst.Constant
import cockatoo.enjizen.personalaccount.constanst.DBConstant
import org.jetbrains.anko.db.*

/**
 * Created by Wanchalerm Yuphasuk on 8/2/2018 AD.
 */
class DBManager(ctx: Context) : ManagedSQLiteOpenHelper(ctx, DB_NAME,null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        createTableBank(db)
    }

    private fun createTableBank(db: SQLiteDatabase?) {
        db!!.createTable(DBConstant.Bank.TABLE_NAME,true,
                  DBConstant.Bank.ID to INTEGER + PRIMARY_KEY + UNIQUE ,
                            DBConstant.Bank.NAME to TEXT,
                            DBConstant.Bank.FORMAT_NUMBER to TEXT,
                            DBConstant.Bank.IS_DELETED to INTEGER
                        )
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