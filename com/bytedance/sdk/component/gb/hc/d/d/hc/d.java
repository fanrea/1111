package com.bytedance.sdk.component.gb.hc.d.d.hc;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends h {
    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.h
    public byte b() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.h
    public byte hc() {
        return (byte) 1;
    }

    public d(Context context, com.bytedance.sdk.component.gb.hc.c.hc.d dVar, com.bytedance.sdk.component.gb.d.u uVar) {
        super(context, dVar, uVar);
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.h, com.bytedance.sdk.component.gb.hc.d.d.hc.hc
    public String d() {
        return this.hc.hc().u();
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.h, com.bytedance.sdk.component.gb.hc.d.d
    public boolean d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return com.bytedance.sdk.component.gb.hc.b.d.u(hcVar);
    }

    public static String hc(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String b(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }
}
