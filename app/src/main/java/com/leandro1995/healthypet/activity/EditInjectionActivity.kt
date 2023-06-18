package com.leandro1995.healthypet.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.adapter.TypeInjectionCheckedAdapter
import com.leandro1995.healthypet.component.config.callback.ImageSelectorComponentCallBack
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.adapter.TypeInjectionCheckedAdapterCallBack
import com.leandro1995.healthypet.config.callback.intent.DetailInjectionIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityEditInjectionBinding
import com.leandro1995.healthypet.extension.dateFormat
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.extension.putInjection
import com.leandro1995.healthypet.intent.config.DetailInjectionIntentConfig
import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.TypeInjectionChecked
import com.leandro1995.healthypet.model.entity.Injection
import com.leandro1995.healthypet.model.entity.TypeInjection
import com.leandro1995.healthypet.util.ArrayListUtil
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.util.DialogUtil
import com.leandro1995.healthypet.viewmodel.DetailInjectionViewModel

class EditInjectionActivity : AppCompatActivity(), DetailInjectionIntentCallBack {

    private lateinit var editInjectionBinding: ActivityEditInjectionBinding

    private val detailInjectionViewModel by viewModels<DetailInjectionViewModel>()

    private lateinit var typeInjectionCheckedAdapter: TypeInjectionCheckedAdapter

    private val typeInjectionCheckedArrayList = arrayListOf<TypeInjectionChecked>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DetailInjectionIntentConfig.instance(detailInjectionIntentCallBack = this)

        editInjectionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_edit_injection)

        editInjectionBinding.detailInjectionViewModel = detailInjectionViewModel

        materialToolbar()
        putExtra()
        collect()
    }

    private fun putExtra() {

        detailInjectionViewModel.injection = (Setting.INJECTION_PUT putInjection this)!!
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(activity = this,
            materialToolbar = editInjectionBinding.appBar.toolbar,
            idTitle = R.string.edit_injection_text_title,
            isArrow = true,
            method = { finish() })
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            detailInjectionViewModel.detailInjectionMutableStateFlow.collect { detailInjectionIntent ->

                DetailInjectionIntentConfig.detailInjectionSelect(detailInjectionIntent = detailInjectionIntent)
            }
        })
    }

    override fun view() {

        typeInjectionCheckedArrayList.clear()
        typeInjectionCheckedArrayList.addAll(
            ArrayListUtil.typeInjectionCheckedArrayList(
                activity = this,
                typeInjectionId = detailInjectionViewModel.injection.typeInjection.id
            )
        )

        typeInjectionCheckedAdapter = TypeInjectionCheckedAdapter()

        typeInjectionCheckedAdapter.typeInjectionCheckedAdapterCallBack =
            object : TypeInjectionCheckedAdapterCallBack {

                override fun typeInjection(typeInjection: TypeInjection) {

                    this@EditInjectionActivity.detailInjectionViewModel.injection.typeInjection =
                        typeInjection
                }
            }

        editInjectionBinding.apply {

            typeInjectionRecycler.let { recyclerView ->

                recyclerView.layoutManager =
                    GridLayoutManager(this@EditInjectionActivity, Setting.GRID_LAYOUT_TWO)
                recyclerView.adapter = typeInjectionCheckedAdapter
            }

            imageSelectorComponent.imageSelectorComponentCallBack =
                object : ImageSelectorComponentCallBack {

                    override fun photoUrl(url: String) {

                        this@EditInjectionActivity.detailInjectionViewModel.injection.photoUrl =
                            url
                    }
                }
        }

        typeInjectionCheckedAdapter.submitList(typeInjectionCheckedArrayList)
    }

    override fun injectionStatus(isStatus: Boolean, injection: Injection) {

        setResult(Activity.RESULT_OK, Intent().apply {

            putExtra(Setting.BOOLEAN_PUT, isStatus)
            putExtra(Setting.INJECTION_PUT, injection)
        })
        finish()
    }

    override fun datePickerDialog(calendar: Calendar) {

        DialogUtil.datePickerDialog(activity = this, calendar = calendar) { dateLong ->

            editInjectionBinding.dateText.text =
                dateLong.dateFormat(format = Setting.DATE_FORMAT_ONE)
        }
    }
}