package com.stylingandroid.activityresultcontract

import android.Manifest
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.stylingandroid.activityresultcontract.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController: NavController by lazy(LazyThreadSafetyMode.NONE) {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController
    }

    private val permission = Manifest.permission.READ_PHONE_STATE

    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                navController.navigate(R.id.grantedPermissionsFragment)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when {
            ContextCompat.checkSelfPermission(this, permission) == PERMISSION_GRANTED ->
                navController.navigate(R.id.grantedPermissionsFragment)
            shouldShowRequestPermissionRationale(permission) -> showRationale()
            else -> requestPermissions.launch(permission)
        }
    }

    private fun showRationale() {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.dialog_title)
            .setMessage(R.string.dialog_message)
            .setPositiveButton(R.string.button_ok) { _, _ ->
                requestPermissions.launch(permission)
            }
            .setNegativeButton(R.string.button_cancel) { _, _ -> }
            .show()
    }
}
