package cockatoo.enjizen.personalaccount.db

import android.content.ContentValues
import android.database.Cursor
import cockatoo.enjizen.personalaccount.constanst.DBConstant
import cockatoo.enjizen.personalaccount.manager.DBInstant
import cockatoo.enjizen.personalaccount.model.Bank

/**
 * Created by Wanchalerm Yuphasuk on 8/2/2018 AD.
 */
object BankManager {


    private val subjectName = DBConstant.Bank

    fun insert(contentValues: ContentValues){
        val db = DBInstant.getDBInstant()!!.readableDatabase
        db.insert(subjectName.TABLE_NAME,null,contentValues)
        db.close()
    }

   fun getAll() : MutableList<Bank>{
        val db = DBInstant.getDBInstant()!!.readableDatabase
        val list = mutableListOf<Bank>()
        val cursor: Cursor
        cursor = db.rawQuery("SELECT * FROM "+ subjectName.TABLE_NAME,null)
        if(cursor != null){
            if(cursor.count > 0){
                cursor.moveToFirst()
                do{
                    val id = cursor.getInt(cursor.getColumnIndex(subjectName.ID))
                    val name = cursor.getString(cursor.getColumnIndex(subjectName.NAME))
                    val bank = Bank(id,name,"",false)
                    list.add(bank)
                }while (cursor.moveToNext())
            }
        }

       db.close()
       cursor.close()

        return list
    }
}