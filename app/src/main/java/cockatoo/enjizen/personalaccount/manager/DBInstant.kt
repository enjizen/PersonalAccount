package cockatoo.enjizen.personalaccount.manager

/**
 * Created by Wanchalerm Yuphasuk on 8/2/2018 AD.
 */
object DBInstant {
    private var dbInstant: DBHelper? = null

    fun init(dbInstant: DBHelper){
        this.dbInstant = dbInstant
    }

    fun getDBInstant() = dbInstant
}