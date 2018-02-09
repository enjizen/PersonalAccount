package cockatoo.enjizen.personalaccount.activity

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import cockatoo.enjizen.personalaccount.R
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.view.View
import org.jetbrains.anko.activityManager


/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
 abstract class BaseActivity : AppCompatActivity() {
    private lateinit var actionBarDrawableToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    protected fun setDrawerLayout() {

        setSupportActionBar(toolBar)

        actionBarDrawableToggle = ActionBarDrawerToggle(this as Activity,drawerLayout, R.string.open_drawer, R.string.close_drawer)



        drawerLayout.addDrawerListener(actionBarDrawableToggle)

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)

        actionBarDrawableToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        actionBarDrawableToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return if (actionBarDrawableToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)


    }
}