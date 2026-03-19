package com.kwai.middleware.azeroth.network;

import android.util.Log;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.utils.Callback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class EmptyCallback<T> implements Callback<T> {
    @Override // com.kwai.middleware.azeroth.utils.Callback
    public void onSuccess(T t) {
    }

    @Override // com.kwai.middleware.azeroth.utils.Callback
    public void onFailure(Throwable th) {
        if (Azeroth.get().isDebugMode()) {
            Log.e("open_azeroth", "", th);
        }
    }
}
