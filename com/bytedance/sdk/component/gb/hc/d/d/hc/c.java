package com.bytedance.sdk.component.gb.hc.d.d.hc;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends an {
    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.an
    public byte b() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.an
    public byte hc() {
        return (byte) 1;
    }

    public c(Context context, com.bytedance.sdk.component.gb.hc.c.hc.d dVar, com.bytedance.sdk.component.gb.d.u uVar) {
        super(context, dVar, uVar);
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.an, com.bytedance.sdk.component.gb.hc.d.d.hc.hc
    public String d() {
        com.bytedance.sdk.component.gb.d.an anVarHc = this.hc.hc();
        if (anVarHc != null) {
            return anVarHc.d();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.an, com.bytedance.sdk.component.gb.hc.d.d
    public boolean d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return com.bytedance.sdk.component.gb.hc.b.d.d(hcVar);
    }

    public static String hc(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String b(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }
}
