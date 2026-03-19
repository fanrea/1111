package com.bytedance.msdk.u;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk implements com.bytedance.sdk.component.gb.d.an {
    public static final mk d = new mk();
    private volatile SQLiteDatabase hc;

    @Override // com.bytedance.sdk.component.gb.d.an
    public String an() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String b() {
        return "adevent_applog";
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String c() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String d() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String hc() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String u() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public SQLiteDatabase d(Context context) {
        if (this.hc == null) {
            synchronized (this) {
                if (this.hc == null) {
                    this.hc = com.bytedance.msdk.u.d.an.d(context).d().d();
                    com.bytedance.msdk.d.u.b.d("---------------DB CREATE  SUCCESS new------------");
                }
            }
        }
        return this.hc;
    }
}
