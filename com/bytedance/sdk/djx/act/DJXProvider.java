package com.bytedance.sdk.djx.act;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.bytedance.sdk.djx.utils.ActivityLifecycleHelper;
import com.bytedance.sdk.djx.utils.HostContext;
import com.bytedance.sdk.djx.utils.VerifierSp;
import com.hangman.verifier.InfoListener;
import com.hangman.verifier.Verifier;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXProvider extends ContentProvider {
    private static final String TAG = "DJXProvider";

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        HostContext.setContext(context);
        if (context instanceof Application) {
            ActivityLifecycleHelper.getInstance().init((Application) context);
        }
        if (context != null) {
            boolean zIsSettingDisabled = VerifierSp.isSettingDisabled();
            boolean zIsCrashedOverTimes = VerifierSp.isCrashedOverTimes();
            if (zIsSettingDisabled && !zIsCrashedOverTimes) {
                Verifier.init(context, true, new InfoListener() { // from class: com.bytedance.sdk.djx.act.DJXProvider.1
                    @Override // com.hangman.verifier.InfoListener
                    public void onDebugInfo(String str) {
                        Log.i(DJXProvider.TAG, "verifier: onDebugInfo " + str);
                    }

                    @Override // com.hangman.verifier.InfoListener
                    public void onErrorInfo(String str, Throwable th) {
                        Log.e(DJXProvider.TAG, "verifier: onErrorInfo " + str + ", throwable " + th.getMessage());
                    }
                });
                boolean zDisableClassVerify = false;
                try {
                    zDisableClassVerify = Verifier.disableClassVerify();
                } catch (Throwable th) {
                    VerifierSp.markCrash();
                    Log.e(TAG, "verifier: disableClassVerify error, msg = [" + th.getMessage() + "]");
                }
                if (zDisableClassVerify) {
                    Log.d(TAG, "verifier: disableClassVerify success.");
                    VerifierSp.setVerifierDisabled(true);
                } else {
                    Log.i(TAG, "verifier: disableClassVerify failed.");
                }
            } else {
                Log.d(TAG, "verifier: not invoked, classVerifierSettingValue = " + zIsSettingDisabled + ", crashOverTimes = " + zIsCrashedOverTimes);
            }
        }
        return true;
    }
}
