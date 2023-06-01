package com.leandro1995.healthypet.util

import android.content.Context
import android.net.Uri
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.facebook.drawee.view.SimpleDraweeView
import com.leandro1995.healthypet.component.ImageSelectorComponent
import com.leandro1995.healthypet.component.SexSelectionComponent
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.extension.dateFormat

class DataBindingUtil {

    companion object {

        @BindingAdapter("app:date")
        @JvmStatic
        fun setDateLong(textView: TextView, long: Long) {

            if (long != -1L) {

                textView.text = long.dateFormat(format = Setting.DATE_FORMAT_ONE)
            }
        }

        @InverseBindingAdapter(attribute = "app:date", event = "android:textAttrChanged")
        @JvmStatic
        fun getDateLong(textView: TextView): Long {

            return if (textView.text.isEmpty()) {

                -1L
            } else {

                textView.text.toString() dateFormat Setting.DATE_FORMAT_ONE
            }
        }

        @BindingAdapter("app:pet_specie", "app:context")
        @JvmStatic
        fun setSpecie(textView: TextView, id: Int, context: Context) {

            textView.text =
                ArrayListUtil.spiceFilter(id = id, activity = (context as AppCompatActivity))!!.name
        }

        @BindingAdapter("app:pet_sex")
        @JvmStatic
        fun setSex(textView: TextView, isSex: Boolean) {

            textView.setText(DesignUtil.sexText(isSex = isSex))
        }

        @BindingAdapter("app:pet_date")
        @JvmStatic
        fun setPetDateLong(textView: TextView, string: String) {

            if (string.isNotEmpty()) {

                textView.text = string
            }
        }

        @Suppress("DEPRECATION")
        @BindingAdapter("app:image_url")
        @JvmStatic
        fun setImageUrl(simpleDraweeView: SimpleDraweeView, uri: Uri) {

            simpleDraweeView.setImageURI(uri)
        }

        @BindingAdapter("app:pet_image_url")
        @JvmStatic
        fun setImagePetUrl(imageSelectorComponent: ImageSelectorComponent, uri: Uri) {

            imageSelectorComponent.imageUrl(uri = uri)
        }

        @BindingAdapter("app:pet_sex")
        @JvmStatic
        fun setPetSex(sexSelectionComponent: SexSelectionComponent, boolean: Boolean) {

            sexSelectionComponent.selectSex(isSex = boolean)
        }

        @BindingAdapter("app:pet_date")
        @JvmStatic
        fun setPetDate(textView: TextView, long: Long) {

            if (long != -1L) {

                textView.text =
                    long.dateFormat(format = Setting.DATE_FORMAT_ONE, isCalendar = false)
            }
        }

        @InverseBindingAdapter(attribute = "app:pet_date", event = "android:textAttrChanged")
        @JvmStatic
        fun getPetDate(textView: TextView): Long {

            return if (textView.text.isEmpty()) {

                -1L
            } else {

                textView.text.toString() dateFormat Setting.DATE_FORMAT_ONE
            }
        }
    }
}