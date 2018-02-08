package cockatoo.enjizen.personalaccount.model.retrofit

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
data class ProvinceModel(@SerializedName("provinces")
                          val provinces: MutableList<ProvinceItemModel>) :  Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(ProvinceItemModel.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(provinces)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ProvinceModel> = object : Parcelable.Creator<ProvinceModel> {
            override fun createFromParcel(source: Parcel): ProvinceModel = ProvinceModel(source)
            override fun newArray(size: Int): Array<ProvinceModel?> = arrayOfNulls(size)
        }
    }
}