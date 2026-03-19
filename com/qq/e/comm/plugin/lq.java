package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class lq {
    protected final Context a;
    protected final String b;
    protected final String c;
    protected final ADListener d;
    protected final e2 e;
    protected final mb f;
    protected final f5 g;

    protected abstract e2 a();

    public lq(Context context, String str, String str2, mb mbVar, ADListener aDListener) throws JSONException {
        f5 f5Var = new f5();
        this.g = f5Var;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.f = mbVar;
        this.d = aDListener;
        e2 e2VarA = a();
        this.e = e2VarA;
        f5Var.c(str2);
        f5Var.a(e2VarA);
    }
}
