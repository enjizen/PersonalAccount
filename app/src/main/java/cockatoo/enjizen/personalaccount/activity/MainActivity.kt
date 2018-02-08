package cockatoo.enjizen.personalaccount.activity

import android.Manifest
import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cockatoo.enjizen.personalaccount.R
import cockatoo.enjizen.personalaccount.db.BankDBHelper
import cockatoo.enjizen.personalaccount.fragment.MainFragment
import cockatoo.enjizen.personalaccount.util.Log
import com.google.gson.Gson
import pl.tajchert.nammu.Nammu
import pl.tajchert.nammu.PermissionCallback

/**
 * Wanchalerm Yuphasuk
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstance())
                    .commit()
        }

       // checkRuntimPermission()


       val contentValue = ContentValues()
        contentValue.put("name","ooooooooo")

      //  BankDBHelper.insert(contentValue)

        val result = BankDBHelper.getAll()

        Log.i("MainActivity","Result = " + Gson().toJson(result))
/*
        val result = myDatabaseOpenHelper.getBank()

        Log.i("MainActivity","Result = " + Gson().toJson(result))


        myDatabaseOpenHelper.deleteAllBank()*/


    }

    // Check Runtime Permission -- BEGIN
    fun checkRuntimPermission() {
        Nammu.init(this)
        // Check Runtime Permission
        Nammu.askForPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, object : PermissionCallback {
            override fun permissionGranted() {

            }

            override fun permissionRefused() {
                finish()
            }
        })
    }
}
