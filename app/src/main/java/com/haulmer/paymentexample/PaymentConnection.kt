package com.haulmer.paymentexample

import android.content.Intent
import android.content.pm.PackageManager
import com.haulmer.paymentexample.model.Request
import com.fasterxml.jackson.databind.ObjectMapper

class PaymentConnection {
    private var packagename = "com.haulmer.paymentapp.integrator"
    fun sendIntentPagos(packageManager: PackageManager, request: Request): Intent? {
        val orm = ObjectMapper()
        var sendIntent = packageManager.getLaunchIntentForPackage(packagename)?.apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, orm.writeValueAsString(request))
            type = "text/json"
            flags = 0
        }
        return sendIntent
    }

    fun existApp(packageManager: PackageManager): Boolean {
        return packageManager.getLaunchIntentForPackage(packagename) != null;
    }
}