package com.leandro1995.healthypet.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.activity.DetailInjectionActivity
import com.leandro1995.healthypet.component.config.callback.InjectionListComponentCallBack
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.InjectionIntentCallBack
import com.leandro1995.healthypet.databinding.FragmentInjectionBinding
import com.leandro1995.healthypet.extension.putInjection
import com.leandro1995.healthypet.extension.putInt
import com.leandro1995.healthypet.extension.viewLifecycleOwner
import com.leandro1995.healthypet.intent.config.InjectionIntentConfig
import com.leandro1995.healthypet.model.entity.Injection
import com.leandro1995.healthypet.model.entity.Pet
import com.leandro1995.healthypet.util.ActivityUtil
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.InjectionViewModel

class InjectionFragment : Fragment(), InjectionIntentCallBack {

    private lateinit var injectionBinding: FragmentInjectionBinding

    private val injectionViewModel by viewModels<InjectionViewModel>()

    private val injectionArrayList = ArrayList<Injection>()

    private val resultRegister = ActivityUtil.activityResultLauncher(fragment = this, resultData = {

        injectionArrayList.add((it putInjection Setting.INJECTION_PUT)!!)

        injectionBinding.injectionListComponent.injectionArrayList(injectionArrayList = injectionArrayList)
    })

    private val resultEdit = ActivityUtil.activityResultLauncher(fragment = this, resultData = {

    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        InjectionIntentConfig.instance(injectionIntentCallBack = this)

        injectionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_injection, container, false)

        injectionBinding.injectionViewModel = injectionViewModel

        putExtra()
        materialToolBar()
        collect()

        return injectionBinding.root
    }

    private fun putExtra() {

        injectionViewModel.pet.id = Setting.ID_PET_PUT putInt requireActivity()
    }

    private fun collect() {

        viewLifecycleOwner(fragment = this, method = {

            injectionViewModel.injectionMutableStateFlow.collect { injectionIntent ->

                InjectionIntentConfig.injectionSelect(injectionIntent = injectionIntent)
            }
        })
    }

    private fun materialToolBar() {

        DesignUtil.materialToolbar(
            activity = requireActivity(),
            materialToolbar = injectionBinding.appBar.toolbar,
            idTitle = R.string.injection_text_title
        )
    }

    override fun view() {

        injectionViewModel.onClick.invoke(InjectionViewModel.INJECTION_LIST)

        injectionBinding.injectionListComponent.injectionListComponentCallBack =
            object : InjectionListComponentCallBack {

                override fun injection(injection: Injection) {

                    starActivityDetailInjection(injection = injection)
                }
            }
    }

    override fun registerInjection(activity: Activity, pet: Pet) {

        resultRegister.launch(Intent(requireActivity(), activity::class.java).apply {

            putExtra(Setting.ID_PET_PUT, pet.id)
        })
    }

    override fun injectionArrayList(injectionArrayList: ArrayList<Injection>) {

        this.injectionArrayList.clear()
        this.injectionArrayList.addAll(injectionArrayList)

        injectionBinding.injectionListComponent.injectionArrayList(injectionArrayList = this.injectionArrayList)
    }

    private fun starActivityDetailInjection(injection: Injection) {

        resultEdit.launch(Intent(requireActivity(), DetailInjectionActivity::class.java).apply {

            putExtra(Setting.INJECTION_PUT, injection)
        })
    }
}