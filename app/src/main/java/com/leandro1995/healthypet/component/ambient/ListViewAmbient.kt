package com.leandro1995.healthypet.component.ambient

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.component.config.ComponentSetting
import com.leandro1995.healthypet.component.util.TypeArrayComponentUtil
import com.leandro1995.healthypet.databinding.ComponentListPetBinding
import com.leandro1995.healthypet.extension.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

open class ListViewAmbient(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    protected lateinit var componentListPetBinding: ComponentListPetBinding

    private var isLoading = false

    init {

        typedArray(
            typedArray = attributes(
                intArray = R.styleable.ListViewAmbient, attrs = attrs
            )
        )

        isLoading()
        adapter()
    }

    override fun view() {

        componentListPetBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_list_pet,
            this,
            true
        )
    }

    override fun typedArray(typedArray: TypedArray?) {

        TypeArrayComponentUtil.let { typedArrayComponent ->

            componentListPetBinding.errorImage.setImageResource(
                typedArrayComponent.typeArrayImage(
                    typedArray = typedArray,
                    indexAttr = R.styleable.ListViewAmbient_image_error_list
                )
            )

            componentListPetBinding.errorText.text = typedArrayComponent.typeArrayText(
                typedArray = typedArray, indexAttr = R.styleable.ListViewAmbient_text_error_list
            )

            isLoading = typedArrayComponent.typeArrayBoolean(
                typedArray = typedArray, indexAttr = R.styleable.ListViewAmbient_is_loading_list
            )
        }
    }

    protected open fun adapter() {}

    protected fun errorMessageVisible() {

        componentListPetBinding.messageErrorLinear.visibility = View.VISIBLE
        componentListPetBinding.listLinear.visibility = View.GONE
    }

    protected fun errorMessageGone() {

        componentListPetBinding.messageErrorLinear.visibility = View.GONE
        componentListPetBinding.listLinear.visibility = View.VISIBLE
    }

    protected fun isLoadingList(method: () -> Unit) {

        coroutineScope(context = Dispatchers.Main, method = {

            if (isLoading) {

                delay(TimeUnit.SECONDS.toMillis(ComponentSetting.TIME_OUT_LIST))
            }

            method()

            isLoading = false
            loadingGone()
        })
    }

    private fun isLoading() {

        if (!isLoading) {

            loadingGone()
            errorMessageVisible()
        }
    }

    private fun loadingGone() {

        componentListPetBinding.progressBar.visibility = View.GONE
    }
}