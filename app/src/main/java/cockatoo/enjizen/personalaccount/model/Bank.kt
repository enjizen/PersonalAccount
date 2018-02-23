package cockatoo.enjizen.personalaccount.model

/**
 * Created by streami.t.mobiledeveloper1 on 8/2/2018 AD.
 */
data class Bank(
        var id: Int,
        var name: String,
        var formatNumber: String,
        var imageUrl: String,
        var isDeleted: Int
)