package com.fc.tjcpl.sdk.h;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c implements b {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public String a() {
        return "https://stat.91taojin.com.cn/app/reportAppList";
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public boolean b() {
        return true;
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public void c() {
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public String d() {
        StringBuilder sbAppend;
        String str;
        if (TextUtils.isEmpty(this.b)) {
            sbAppend = new StringBuilder().append("IMEI=");
            str = this.a;
        } else {
            sbAppend = new StringBuilder().append("OAID=");
            str = this.b;
        }
        return sbAppend.append(str).append("&AppsList=").append(this.c).append("&Token=").append(this.e).append("&sign=").append(this.d).append("&OpenNameBase64=1").toString();
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public boolean e() {
        return false;
    }
}
