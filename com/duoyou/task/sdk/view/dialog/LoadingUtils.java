package com.duoyou.task.sdk.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.alipay.sdk.m.x.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LoadingUtils {
    private static LoadingDialog progressDialog;

    public static void showLoading(Activity activity) {
        showLoading(activity, a.i);
    }

    public static void showLoading(Activity activity, String str) {
        dismissDialogSafely(progressDialog);
        LoadingDialog loadingDialog = new LoadingDialog(activity, str);
        progressDialog = loadingDialog;
        loadingDialog.setCancelable(true);
        showDialogSafely(activity, progressDialog);
    }

    public static void hideLoading() {
        dismissDialogSafely(progressDialog);
        progressDialog = null;
    }

    public static void showDialogSafely(Context context, final LoadingDialog loadingDialog) {
        try {
            dismissDialogSafely(progressDialog);
            if (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing() || loadingDialog == null || loadingDialog.isShowing()) {
                return;
            }
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.duoyou.task.sdk.view.dialog.LoadingUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    loadingDialog.show();
                    LoadingDialog unused = LoadingUtils.progressDialog = loadingDialog;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dismissDialogSafely(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                    progressDialog = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
