package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class tg {
    private String a;
    private String[] b;

    public tg(String str, String... strArr) {
        this.a = str;
        this.b = strArr;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        String str = this.a;
        if (str != null) {
            sb.append(str);
            sb.append("(");
            String[] strArr = this.b;
            if (strArr != null && strArr.length > 0) {
                sb.append(m10.a(",", strArr));
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
