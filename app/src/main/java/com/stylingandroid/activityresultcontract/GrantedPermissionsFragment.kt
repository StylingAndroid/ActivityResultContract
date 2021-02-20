package com.stylingandroid.activityresultcontract

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.fragment.app.Fragment
import com.stylingandroid.activityresultcontract.databinding.FragmentGrantedPermissionsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GrantedPermissionsFragment : Fragment(R.layout.fragment_granted_permissions) {

    @Inject
    lateinit var myLogic: MyLogic

    private val getPermission = registerForActivityResult(RequestPermission()) { granted ->
        if (granted) {
            binding.secondaryPermission.setText(R.string.permission_granted)
        } else {
            binding.secondaryPermission.setText(R.string.permission_denied)
        }
    }

    lateinit var binding: FragmentGrantedPermissionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGrantedPermissionsBinding.bind(view)

        binding.requestSecondary.setOnClickListener {
            getPermission.launch(Manifest.permission.READ_CONTACTS)
        }

        binding.requestExternal.setOnClickListener {
            myLogic.doSomething().observe(viewLifecycleOwner) { granted ->
                if (granted) {
                    binding.externalPermission.setText(R.string.permission_granted)
                } else {
                    binding.externalPermission.setText(R.string.permission_denied)
                }
            }
        }
    }
}
