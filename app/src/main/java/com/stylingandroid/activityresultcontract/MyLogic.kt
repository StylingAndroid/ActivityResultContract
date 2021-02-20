package com.stylingandroid.activityresultcontract

import android.Manifest
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class MyLogic @Inject constructor(registry: ActivityResultRegistry) {

    private val enabled = MutableLiveData(false)

    private val getPermission = registry.register(REGISTRY_KEY, RequestPermission()) { granted ->
        enabled.value = granted
    }

    fun doSomething(): LiveData<Boolean> {
        getPermission.launch(Manifest.permission.READ_CALENDAR)
        return enabled
    }

    companion object {
        private const val REGISTRY_KEY = "Read Calendar Permission"
    }
}
