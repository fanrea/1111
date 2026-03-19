package com.bytedance.bdtracker;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.sdk.internal.bu;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.oneid.IDBindCallback;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001e\u0010\u0015\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u0019\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/applog/oneid/OneIDManager;", "", "engine", "Lcom/bytedance/applog/engine/Engine;", "(Lcom/bytedance/applog/engine/Engine;)V", "appLogInstance", "Lcom/bytedance/applog/AppLogInstance;", "kotlin.jvm.PlatformType", "getEngine", "()Lcom/bytedance/applog/engine/Engine;", bu.a, "Lcom/bytedance/applog/log/IAppLogLogger;", "mainHandler", "Landroid/os/Handler;", "bind", "", "identities", "", "", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/applog/oneid/IDBindCallback;", "reportFail", "code", "", cm.V, "reportSuccess", "result", "Lcom/bytedance/applog/oneid/IDBindResult;", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class g3 {
    public final d a;
    public final Handler b;
    public final IAppLogLogger c;
    public final e0 d;

    public static final class a implements Runnable {
        public final /* synthetic */ Map b;
        public final /* synthetic */ IDBindCallback c;

        public a(Map map, IDBindCallback iDBindCallback) {
            this.b = map;
            this.c = iDBindCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x010c  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() throws org.json.JSONException {
            /*
                Method dump skipped, instructions count: 375
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.g3.a.run():void");
        }
    }

    public g3(e0 e0Var) {
        Intrinsics.checkParameterIsNotNull(e0Var, "engine");
        this.d = e0Var;
        this.a = e0Var.d;
        this.b = new Handler(Looper.getMainLooper());
        d dVar = e0Var.d;
        Intrinsics.checkExpressionValueIsNotNull(dVar, "engine.appLog");
        this.c = dVar.D;
    }

    public final void a(Map<String, String> map, IDBindCallback iDBindCallback) {
        Intrinsics.checkParameterIsNotNull(map, "identities");
        x.a.submit(new a(map, iDBindCallback));
    }
}
