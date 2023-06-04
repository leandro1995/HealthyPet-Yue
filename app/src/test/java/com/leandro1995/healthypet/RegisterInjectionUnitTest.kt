package com.leandro1995.healthypet

import com.leandro1995.healthypet.intent.RegisterInjectionIntent
import com.leandro1995.healthypet.viewmodel.RegisterInjectionViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class RegisterInjectionUnitTest {

    private val registerInjection = RegisterInjectionViewModel()

    @Test
    fun checkInjectionPhoto() {

        registerInjection.apply {

            onClick.invoke(RegisterInjectionViewModel.VERIFY_INJECTION)

            assertEquals(
                R.string.photo_url_injection_message,
                messageError(registerInjectionIntent = registerInjectionMutableSateFlow.value)
            )
        }
    }

    @Test
    fun checkInjectionNextAppointment() {

        registerInjection.apply {

            injection.let { injection ->

                injection.photoUrl = "urlPhoto"
            }

            onClick.invoke(RegisterInjectionViewModel.VERIFY_INJECTION)

            assertEquals(
                R.string.next_appointment_message,
                messageError(registerInjectionIntent = registerInjectionMutableSateFlow.value)
            )
        }
    }

    @Test
    fun checkInjectionTypeInjection() {

        registerInjection.apply {

            injection.let { injection ->

                injection.photoUrl = "urlPhoto"
                injection.nextAppointment = 1L
            }

            onClick.invoke(RegisterInjectionViewModel.VERIFY_INJECTION)

            assertEquals(
                R.string.select_injection_message,
                messageError(registerInjectionIntent = registerInjectionMutableSateFlow.value)
            )
        }
    }

    private fun messageError(registerInjectionIntent: RegisterInjectionIntent) =
        (registerInjectionIntent as RegisterInjectionIntent.MessageErrorDialog).message.messageError()
}