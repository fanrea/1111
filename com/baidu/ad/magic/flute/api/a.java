package com.baidu.ad.magic.flute.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class a extends Handler {
    private static final int b = 0;
    private static final int c = 1;
    private OnGetIdResultCallback a;

    public a(OnGetIdResultCallback onGetIdResultCallback, Looper looper) {
        super(looper);
        this.a = onGetIdResultCallback;
    }

    public void a(int i, Exception exc, Bundle bundle) {
        obtainMessage(1, i, 0, Pair.create(exc, bundle)).sendToTarget();
    }

    public void a(Object obj, Bundle bundle) {
        obtainMessage(0, Pair.create(obj, bundle)).sendToTarget();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Pair pair = (Pair) message.obj;
                this.a.onResult(((Long) pair.first).longValue(), (Bundle) pair.second);
                break;
            case 1:
                this.a.onError(message.arg1);
                break;
        }
    }
}
