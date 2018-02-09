package cockatoo.enjizen.personalaccount.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import cockatoo.enjizen.personalaccount.R
import cockatoo.enjizen.personalaccount.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Wanchalerm Yuphasuk
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setDrawerLayout()

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstance())
                    .commit()
        }

    }


}
