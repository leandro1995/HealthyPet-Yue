package com.leandro1995.healthypet.util

import android.net.Uri
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
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