package com.tk.core.e.a;

import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class c implements b {
    public int ahQ;
    public int state;
    public String type;
    public HashMap<String, Object> ahP = new HashMap<>();
    public long timestamp = System.currentTimeMillis();

    @Override // com.tk.core.e.a.b
    public void n(HashMap<String, Object> map) {
        this.ahP = map;
    }

    @Override // com.tk.core.e.a.b
    public final void bX(String str) {
        this.type = str;
    }

    @Override // com.tk.core.e.a.b
    public void setState(int i) {
        this.state = i;
        dY(i);
    }

    private void dY(int i) {
        this.ahQ = i;
    }
}
