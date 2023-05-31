package com.leandro1995.healthypet.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.callback.intent.ProfileIntentCallBack
import com.leandro1995.healthypet.databinding.FragmentProfileBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.ProfileIntentConfig
import com.leandro1995.healthypet.viewmodel.ProfileViewModel

class ProfileFragment : Fragment(), ProfileIntentCallBack {

    private lateinit var profileBinding: FragmentProfileBinding

    private val profileViewModel by viewModels<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        ProfileIntentConfig.instance(profileIntentCallBack = this)

        profileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        profileBinding.profileViewModel = profileViewModel

        collect()

        return profileBinding.root
    }

    private fun collect() {

        lifecycleScope(activity = requireActivity(), method = {

            profileViewModel.profileMutableStateFlow.collect { profileIntent ->

                ProfileIntentConfig.profileSelect(profileIntent = profileIntent)
            }
        })
    }

    override fun view() {

    }
}