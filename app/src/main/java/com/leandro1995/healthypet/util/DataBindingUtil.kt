package com.leandro1995.healthypet.util

import android.content.Context
import android.net.Uri
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.facebook.drawee.view.SimpleDraweeView
import com.leandro1995.healthypet.R
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

            textView.setText(

                if (isSex) {

                    R.string.female_text
                } else {

                    R.string.male_text
                }
            )
        }

        @BindingAdapter("app:pet_date")
        @JvmStatic
        fun setPetDateLong(textView: TextView, long: Long) {

            if (long != -1L) {

                textView.text =
                    long.dateFormat(format = Setting.DATE_FORMAT_ONE, isCalendar = false)
            }
        }

        @Suppress("DEPRECATION")
        @BindingAdapter("app:image_url")
        @JvmStatic
        fun setImageUrl(simpleDraweeView: SimpleDraweeView, uri: Uri) {

            simpleDraweeView.setImageURI(uri)
        }
    }
}