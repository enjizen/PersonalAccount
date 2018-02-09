package cockatoo.enjizen.personalaccount.activity

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import cockatoo.enjizen.personalaccount.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import cockatoo.enjizen.personalaccount.fragment.BankAccountFragment
import cockatoo.enjizen.personalaccount.fragment.BankFragment


/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
abstract class BaseActivity : AppCompatActivity() {
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    protected fun setUpViewDrawerLayout() {
        setSupportActionBar(toolbar)
        setupDrawerContent()

        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(drawerToggle)
    }

    private fun setupDrawerContent() {
        nvView.setNavigationItemSelectedListener(
                { menuItem ->
                    selectDrawerItem(menuItem)
                    true
                })
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        drawerToggle.onConfigurationChanged(newConfig)
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        var fragment: Fragment? = null
        val fragmentClass: Class<*> = when (menuItem.itemId) {
            R.id.nav_bank -> BankFragment::class.java
            R.id.nav_second_fragment -> BankAccountFragment::class.java
            else -> BankFragment::class.java
        }

        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Insert the fragment by replacing any existing fragment
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.contentContainer, fragment).commit()

        // Highlight the selected item has been done by NavigationView
        menuItem.isChecked = true
        // Set action bar title
        title = menuItem.title
        // Close the navigation drawer
        drawerLayout.closeDrawers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }


}