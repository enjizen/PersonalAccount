package cockatoo.enjizen.personalaccount.db

import android.content.ContentValues
import android.database.Cursor
import cockatoo.enjizen.personalaccount.constanst.DBConstant
import cockatoo.enjizen.personalaccount.manager.DBInstant
import cockatoo.enjizen.personalaccount.model.Bank
import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder


/**
 * Created by Wanchalerm Yuphasuk on 8/2/2018 AD.
 */
object BankManager {


    private val subjectName = DBConstant.Bank

    fun insert(bank: Bank) {
        val contentValues = setContentValues(bank)

        val db = DBInstant.getDBInstant()!!.readableDatabase
        db.insert(subjectName.TABLE_NAME, null, contentValues)
        db.close()
    }


    fun insert(banks: MutableList<Bank>) {
        val db = DBInstant.getDBInstant()!!.readableDatabase
        banks.forEach {
            val contentValues = setContentValues(it)
            db.insert(subjectName.TABLE_NAME, null, contentValues)
        }
        db.close()

    }

    fun saveUpdate(bank: Bank) {
        if (getCount() == 0) {
            insert(bank)
        } else {
            val bankInDB = getBank(bank.id.toString())

            if (bankInDB.size > 0) {
                update(bank)
            } else {
                insert(bank)
            }

        }
    }

    fun saveOrUpdate(banks: MutableList<Bank>) {

        if (getCount() == 0) {
            insert(banks)
        } else {
            val bankUpdateList = mutableListOf<Bank>()
            val bankInDB = getBank(null)

            banks.forEach { bank ->
                var itemStatus = false
                bankInDB.forEach {
                    if (it.id == bank.id) {

                        itemStatus = true

                       update(it)
                        return@forEach
                    }
                }
                if (!itemStatus) {
                    insert(bank)
                }
            }

          /*  if (bankUpdateList.size > 0)
                update(bankUpdateList)*/

        }
    }

    fun update(bank: Bank) {
        val db = DBInstant.getDBInstant()!!.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(subjectName.NAME, bank.name)
        contentValues.put(subjectName.FORMAT_NUMBER, bank.formatNumber)
        contentValues.put(subjectName.IMAGE_URL, bank.imageUrl)
        contentValues.put(subjectName.IS_DELETED, bank.isDeleted)
        db.update(subjectName.TABLE_NAME, contentValues, subjectName.ID + " = ?", arrayOf(bank.id.toString()))
        db.close()
    }

    fun update(banks: MutableList<Bank>) {

        banks.forEach {
            val db = DBInstant.getDBInstant()!!.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(subjectName.NAME, it.name)
            contentValues.put(subjectName.FORMAT_NUMBER, it.formatNumber)
            contentValues.put(subjectName.IMAGE_URL, it.imageUrl)
            contentValues.put(subjectName.IS_DELETED, it.isDeleted)
            db.update(subjectName.TABLE_NAME, contentValues, subjectName.ID + " = ?", arrayOf(it.id.toString()))
            db.close()
        }


    }

    fun getBank(id: String?): MutableList<Bank> {
        val db = DBInstant.getDBInstant()!!.readableDatabase
        val list = mutableListOf<Bank>()
        val cursor: Cursor


        val sql = if (id.isNullOrEmpty()) SQLiteQueryBuilder
                .select("*")
                .from(subjectName.TABLE_NAME).toString()
        else {
            SQLiteQueryBuilder
                    .select("*")
                    .from(subjectName.TABLE_NAME)
                    .where("${subjectName.ID} = $id").toString()
        }

        cursor = db.rawQuery(sql, null)
        if (cursor != null) {
            if (cursor.count > 0) {
                cursor.moveToFirst()
                do {
                    val id = cursor.getInt(cursor.getColumnIndex(subjectName.ID))
                    val name = cursor.getString(cursor.getColumnIndex(subjectName.NAME))
                    val formatNumber = cursor.getString(cursor.getColumnIndex(subjectName.FORMAT_NUMBER))
                    val imageUrl = cursor.getString(cursor.getColumnIndex(subjectName.IMAGE_URL))
                    val isDeleted = cursor.getInt(cursor.getColumnIndex(subjectName.IS_DELETED))
                    val bank = Bank(id, name, formatNumber, imageUrl, isDeleted)
                    list.add(bank)
                } while (cursor.moveToNext())
            }
        }

        db.close()
        cursor.close()

        return list
    }

    fun getCount(): Int {
        val db = DBInstant.getDBInstant()!!.readableDatabase
        var count = 0
        val cursor: Cursor
        cursor = db.rawQuery("SELECT Count(idBank) as count FROM " + subjectName.TABLE_NAME, null)
        if (cursor != null) {
            if (cursor.count > 0) {
                cursor.moveToFirst()
                do {
                    count = cursor.getInt(cursor.getColumnIndex("count"))

                } while (cursor.moveToNext())
            }
        }

        db.close()
        cursor.close()

        return count
    }

    private fun setContentValues(bank: Bank): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(subjectName.ID, bank.id)
        contentValues.put(subjectName.NAME, bank.name)
        contentValues.put(subjectName.FORMAT_NUMBER, bank.formatNumber)
        contentValues.put(subjectName.IMAGE_URL, bank.imageUrl)
        contentValues.put(subjectName.IS_DELETED, bank.isDeleted)
        return contentValues
    }


      private fun setBankData(bankList: MutableList<Bank>) {
        bankList.add(Bank(1, "กรุงศรี", "####-####", "https://goo.gl/i1UN9U", 0))
        bankList.add(Bank(2, "ไทยพานิชย์", "####-####", "http://facebook.com", 0))
        bankList.add(Bank(3, "กสิกรไทย", "####-####", "http://www.gooogle.co.th", 0))
        bankList.add(Bank(4, "UOB", "####-####", "http://oracle.com", 0))
        bankList.add(Bank(5, "ออมสิน", "####-####", "http://", 0))
        bankList.add(Bank(6, "กรุงเทพ", "####-####", "http://", 0))
    }

     fun insertBankData() {
        val bankList = mutableListOf<Bank>()
        BankManager.setBankData(bankList)
        BankManager.saveOrUpdate(bankList)
    }
}