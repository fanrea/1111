package com.lk.oaid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import lk.repeackage.f;
import lk.repeackage.g;
import lk.repeackage.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class OAIDHelper {
    private boolean isBack;
    private IGetter listener;
    private final Object lock = new Object();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OAIDHelper.this.oaidGetFail(ErrorCode.STATE_TIME_OUT, new Exception("OAID获取超时,请稍后重试"));
        }
    }

    public class b extends Thread {
        public final /* synthetic */ Context a;

        public class a implements lk.repeackage.c {
            public a() {
            }

            @Override // lk.repeackage.c
            public void a(String str) {
                f.a("OAID query msg: " + str);
                OAIDHelper.this.oaidGetLog(str);
            }

            @Override // lk.repeackage.c
            public void onOAIDGetComplete(String str) {
                f.a("OAID query success: " + str);
                if (TextUtils.isEmpty(str) || str.startsWith("00000")) {
                    b bVar = b.this;
                    if (OAIDHelper.this.isHonorSupport(bVar.a)) {
                        b bVar2 = b.this;
                        OAIDHelper.this.getOaidHonor(bVar2.a);
                        return;
                    }
                }
                OAIDHelper.this.oaidGetSuccess(str);
            }

            @Override // lk.repeackage.c
            public void onOAIDGetError(ErrorCode errorCode, Exception exc) {
                b bVar = b.this;
                if (!OAIDHelper.this.isHonorSupport(bVar.a)) {
                    OAIDHelper.this.oaidGetFail(errorCode, exc);
                } else {
                    b bVar2 = b.this;
                    OAIDHelper.this.getOaidHonor(bVar2.a);
                }
            }
        }

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws PackageManager.NameNotFoundException {
            super.run();
            lk.repeackage.d dVarA = g.a(this.a);
            OAIDHelper.this.oaidGetLog(dVarA.getClass().getName());
            dVarA.a(new a());
        }
    }

    public class c implements lk.repeackage.c {
        public c() {
        }

        @Override // lk.repeackage.c
        public void a(String str) {
            f.a("OAID query msg: " + str);
            OAIDHelper.this.oaidGetLog(str);
        }

        @Override // lk.repeackage.c
        public void onOAIDGetComplete(String str) {
            f.a("OAID query success: " + str);
            OAIDHelper.this.oaidGetSuccess(str);
        }

        @Override // lk.repeackage.c
        public void onOAIDGetError(ErrorCode errorCode, Exception exc) {
            OAIDHelper.this.oaidGetFail(errorCode, exc);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OAIDHelper.this.listener != null) {
                OAIDHelper.this.listener.onOAIDGetComplete(this.a);
            }
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ ErrorCode a;
        public final /* synthetic */ Exception b;

        public e(ErrorCode errorCode, Exception exc) {
            this.a = errorCode;
            this.b = exc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ErrorCode errorCode, Exception exc) {
            OAIDHelper.this.listener.onOAIDGetError(errorCode, exc);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OAIDHelper.this.listener != null) {
                Handler handler = OAIDHelper.this.handler;
                final ErrorCode errorCode = this.a;
                final Exception exc = this.b;
                handler.post(new Runnable() { // from class: com.lk.oaid.OAIDHelper$e$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(errorCode, exc);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOaidHonor(Context context) {
        lk.repeackage.d dVarB = g.b(context);
        if (dVarB == null) {
            oaidGetFail(ErrorCode.STATE_DEVICE_NOSUPPORT, new lk.repeackage.e("Honor Advertising identifier info is null"));
        } else {
            ((m) dVarB).a(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHonorSupport(Context context) {
        lk.repeackage.d dVarB = g.b(context);
        return dVarB != null && ((m) dVarB).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oaidGetFail(ErrorCode errorCode, Exception exc) {
        if (this.isBack) {
            return;
        }
        synchronized (this.lock) {
            if (!this.isBack) {
                this.isBack = true;
                this.handler.post(new e(errorCode, exc));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oaidGetLog(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oaidGetSuccess(String str) {
        if (this.isBack) {
            return;
        }
        synchronized (this.lock) {
            if (!this.isBack) {
                this.isBack = true;
                this.handler.post(new d(str));
            }
        }
    }

    public void getOaid(Context context, IGetter iGetter) {
        this.listener = iGetter;
        if (context != null) {
            this.handler.postDelayed(new a(), com.alipay.sdk.m.u.b.a);
            new b(context).start();
            return;
        }
        f.a("context is null");
        IGetter iGetter2 = this.listener;
        if (iGetter2 != null) {
            iGetter2.onOAIDGetError(ErrorCode.STATE_CALL_PARAM, new lk.repeackage.e("context is null"));
        }
    }

    public boolean supportedOaid(Context context) {
        return g.a(context).a() || supportedOaid(context);
    }
}
