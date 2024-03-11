package com.evirgenoguz.presentation.loading

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.evirgenoguz.presentation.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class IndicatorPresenterImpl constructor(
    private val context: Context
) : IndicatorPresenter {
    private var loadingDialog: androidx.appcompat.app.AlertDialog? = null

    init {
        initLoadingDialog()
    }

    override fun show() {
        if (loadingDialog == null || isActivityRunning().not()) return

        loadingDialog?.let {
            if (it.isShowing.not()) {
                it.show()
            }
        }
    }

    override fun hide() {
        if (loadingDialog == null || isActivityRunning().not()) return

        loadingDialog?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }

    private fun initLoadingDialog() {
        val builder = MaterialAlertDialogBuilder(context, R.style.StyleLoadingDialog)
        builder.setCancelable(false)
        builder.setView(R.layout.dialog_progress_view)
        loadingDialog = builder.create()
        loadingDialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        (context as AppCompatActivity).lifecycle.addObserver(
            DialogDismissLifecycleObserver(
                loadingDialog
            )
        )
    }

    private fun isActivityRunning(): Boolean =
        (context as AppCompatActivity).lifecycle.currentState != Lifecycle.State.DESTROYED
}


class DialogDismissLifecycleObserver(
    private var dialog: AppCompatDialog?
) : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dialog?.dismiss()
            dialog = null
        }
    }
}