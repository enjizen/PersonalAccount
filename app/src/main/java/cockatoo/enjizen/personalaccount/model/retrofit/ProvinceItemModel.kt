package cockatoo.enjizen.personalaccount.model.retrofit

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
data class ProvinceItemModel(@SerializedName("id")  val id: String
                             , @SerializedName("label") val label: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(label)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ProvinceItemModel> = object : Parcelable.Creator<ProvinceItemModel> {
            override fun createFromParcel(source: Parcel): ProvinceItemModel = ProvinceItemModel(source)
            override fun newArray(size: Int): Array<ProvinceItemModel?> = arrayOfNulls(size)
        }
    }
}