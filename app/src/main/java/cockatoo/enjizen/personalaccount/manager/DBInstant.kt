package cockatoo.enjizen.personalaccount.manager

/**
 * Created by Wanchalerm Yuphasuk on 8/2/2018 AD.
 */
object DBInstant {
    private var dbInstantManager: DBManager? = null

    fun init(dbInstantManager: DBManager){
        this.dbInstantManager = dbInstantManager
    }

    fun getDBInstant() = dbInstantManager
}