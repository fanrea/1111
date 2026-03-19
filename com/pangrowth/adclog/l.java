package com.pangrowth.adclog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class l implements k {
    @Override // com.pangrowth.adclog.k
    public String a(Object obj) {
        String[] strArr = (String[]) obj;
        if (strArr != null && strArr.length != 0) {
            String[] strArr2 = new String[strArr.length];
            int i = 0;
            for (String str : strArr) {
                if (str != null) {
                    strArr2[i] = str;
                    i++;
                }
            }
            if (i != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("╔═══════════════════════════════════════════════════════════════════════════════════════════════════").append("\n");
                for (int i2 = 0; i2 < i; i2++) {
                    String str2 = strArr2[i2];
                    StringBuilder sb2 = new StringBuilder(str2.length() + 10);
                    String[] strArrSplit = str2.split("\n");
                    int length = strArrSplit.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (i3 != 0) {
                            sb2.append("\n");
                        }
                        sb2.append((char) 9553).append(strArrSplit[i3]);
                    }
                    sb.append(sb2.toString());
                    if (i2 != i - 1) {
                        sb.append("\n").append("╟───────────────────────────────────────────────────────────────────────────────────────────────────").append("\n");
                    } else {
                        sb.append("\n").append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
                    }
                }
                return sb.toString();
            }
        }
        return "";
    }
}
