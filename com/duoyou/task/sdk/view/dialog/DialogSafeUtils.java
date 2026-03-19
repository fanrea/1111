package com.duoyou.task.sdk.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DialogSafeUtils {
    private static Dialog mDialog;

    public static void showDialogSafely(Context context, final Dialog dialog) {
        try {
            dismissDialogSafely(mDialog);
            if (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.duoyou.task.sdk.view.dialog.DialogSafeUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    dialog.show();
                    Dialog unused = DialogSafeUtils.mDialog = dialog;
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
                    mDialog = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
