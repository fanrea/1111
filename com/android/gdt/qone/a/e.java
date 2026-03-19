package com.android.gdt.qone.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.gdt.qone.ak.o;
import com.android.gdt.qone.ak.q;
import com.android.gdt.qone.ap.f;
import com.android.gdt.qone.log.IObservableLog;
import com.android.gdt.qone.sdk.IAsyncQoneListener;
import com.android.gdt.qone.sdk.IQoneNetworkAdapter;
import com.android.gdt.qone.sdk.IQoneSDK;
import com.android.gdt.qone.sdk.Qone;
import com.android.gdt.qone.sdk.debug.IDebugger;
import com.android.gdt.qone.strategy.terminal.ITerminalStrategy;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e implements IQoneSDK {
    public final /* synthetic */ o a;
    public final /* synthetic */ String b;

    public e(o oVar, String str) {
        this.a = oVar;
        this.b = str;
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final IQoneSDK addUserId(String str, String str2) {
        this.a.b.put(str, str2);
        return this;
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final IDebugger getDebugger() {
        return new c(this.a.c);
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final Qone getQone() {
        String str = this.b;
        o oVar = this.a;
        com.android.gdt.qone.ak.b bVarA = !oVar.l() ? null : f.a(oVar.d);
        if (bVarA == null) {
            return null;
        }
        return new Qone(bVarA.b(), str);
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final String getSdkVersion() {
        return "2.1.3.19";
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final ITerminalStrategy getStrategy() {
        return new b(com.android.gdt.qone.at.a.a(this.a.d).a);
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final String getToken() {
        o oVar = this.a;
        if (oVar.l()) {
            return q.b(oVar.d).b();
        }
        com.android.gdt.qone.af.c.a("SDK_INIT", "getToken fail, sdk not init!", new Object[0]);
        q.b(oVar.d).e = "1";
        return "";
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final boolean init(Context context, IQoneNetworkAdapter iQoneNetworkAdapter) {
        return false;
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final IQoneSDK setAppVersion(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.android.gdt.qone.w.a.c = str;
        }
        return this;
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final IQoneSDK setChannelID(String str) {
        this.a.g = str;
        return this;
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final IQoneSDK setLogAble(boolean z) {
        synchronized (this.a) {
            com.android.gdt.qone.af.a.a(z);
            com.android.gdt.qone.af.a.b(z);
        }
        return this;
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final IQoneSDK setLogObserver(IObservableLog iObservableLog) {
        o oVar = this.a;
        a aVar = new a(iObservableLog);
        synchronized (oVar) {
            com.android.gdt.qone.af.a.a(aVar);
        }
        return this;
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final IQoneSDK setSdkName(String str) {
        o oVar = this.a;
        if (!oVar.f) {
            oVar.h = str;
        }
        return this;
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final boolean init(Context context) {
        o oVar = this.a;
        synchronized (oVar) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (oVar.f) {
                return true;
            }
            com.android.gdt.qone.af.c.b("SDK_INIT", "\n\n\n\n< Your AppKey is: %s SDK_VERSION is: %s>\n", oVar.d, "2.1.3.19");
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                oVar.e = applicationContext;
                if (applicationContext == null) {
                    oVar.e = context;
                }
            }
            if (!oVar.j()) {
                com.android.gdt.qone.af.c.a("SDK_INIT", "appkey:%s parameter exception", oVar.d);
                return false;
            }
            oVar.k();
            com.android.gdt.qone.af.c.b("SDK_INIT", "\n\n\n\n\t\t\t\t ----- initialization finished! From appkey:%s ----- \n\n\n\n\t\t\t\t", oVar.d);
            oVar.f = true;
            oVar.i = SystemClock.uptimeMillis() - jUptimeMillis;
            return true;
        }
    }

    @Override // com.android.gdt.qone.sdk.IQoneSDK
    public final void getQone(IAsyncQoneListener iAsyncQoneListener) {
        this.a.b(new d(iAsyncQoneListener, this.b));
    }
}
