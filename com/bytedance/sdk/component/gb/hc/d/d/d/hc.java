package com.bytedance.sdk.component.gb.hc.d.d.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.gb.d.an;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements an {
    public static final hc d = new hc();
    private volatile SQLiteDatabase hc;

    @Override // com.bytedance.sdk.component.gb.d.an
    public String an() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String b() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String c() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String d() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String hc() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public String u() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.gb.d.an
    public SQLiteDatabase d(Context context) {
        if (this.hc == null) {
            synchronized (this) {
                if (this.hc == null) {
                    this.hc = new d(context, this).getWritableDatabase();
                }
            }
        }
        return this.hc;
    }
}
