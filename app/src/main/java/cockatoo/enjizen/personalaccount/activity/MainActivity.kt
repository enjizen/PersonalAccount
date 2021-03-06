package cockatoo.enjizen.personalaccount.activity

import android.os.Bundle
import cockatoo.enjizen.personalaccount.R
import cockatoo.enjizen.personalaccount.fragment.MainFragment

/**
 * Wanchalerm Yuphasuk
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDrawerLayout()

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstance())
                    .commit()
        }



    }


}
