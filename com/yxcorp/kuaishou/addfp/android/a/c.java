package com.yxcorp.kuaishou.addfp.android.a;

import android.text.TextUtils;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class c {
    private String a;
    private String b;
    private ReentrantLock c;

    private c() {
        this.b = "";
        this.c = new ReentrantLock();
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace(com.alipay.sdk.m.s.a.n, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            java.lang.String r0 = ""
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L5a
            r2 = 33
            r3 = 1
            r4 = 0
            if (r1 >= r2) goto L39
            r2 = 29
            if (r1 < r2) goto L3a
            java.lang.String r1 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> L5a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L5a
            if (r2 != 0) goto L2f
            java.lang.String r2 = r1.toLowerCase()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = "redmi"
            boolean r2 = r2.contains(r5)     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L2f
            java.lang.String r1 = r1.toLowerCase()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r2 = "note 7"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto L2f
            r4 = 1
        L2f:
            java.lang.String r1 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L5a
            java.lang.String r2 = "HONOR"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto L3a
        L39:
            r4 = 1
        L3a:
            if (r4 != 0) goto L53
            com.yxcorp.kuaishou.addfp.android.Orange r1 = com.yxcorp.kuaishou.addfp.android.Orange.getInstance()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r1 = r1.gSer()     // Catch: java.lang.Throwable -> L5a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L5a
            if (r2 != 0) goto L53
            java.lang.String r2 = "KWE"
            boolean r2 = r1.startsWith(r2)     // Catch: java.lang.Throwable -> L5a
            if (r2 != 0) goto L53
            return r1
        L53:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L5a
            if (r1 != 0) goto L5e
            return r0
        L5a:
            r0 = move-exception
            r0.printStackTrace()
        L5e:
            java.lang.String r0 = "KWE_N"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.b():java.lang.String");
    }

    public static c c() {
        return b.a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.a) ? this.a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(89:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|(3:191|26|27)|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(3:181|44|45)|(3:175|46|47)|(3:167|48|(1:50))|59|60|61|62|193|63|67|68|69|70|71|72|179|73|74|173|75|76|80|81|171|82|(3:165|83|84)|177|85|94|95|169|96|99|100|101|102|103|104|105|106|107|108|109|(1:126)(3:115|(4:117|118|183|119)(1:123)|124)|127|128|188|129|(4:132|(2:134|198)(1:199)|135|130)|197|136|140|152|(1:154)|155|156) */
    /* JADX WARN: Can't wrap try/catch for region: R(91:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|191|26|27|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(3:181|44|45)|(3:175|46|47)|(3:167|48|(1:50))|59|60|61|62|193|63|67|68|69|70|71|72|179|73|74|173|75|76|80|81|171|82|(3:165|83|84)|177|85|94|95|169|96|99|100|101|102|103|104|105|106|107|108|109|(1:126)(3:115|(4:117|118|183|119)(1:123)|124)|127|128|188|129|(4:132|(2:134|198)(1:199)|135|130)|197|136|140|152|(1:154)|155|156) */
    /* JADX WARN: Can't wrap try/catch for region: R(93:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|191|26|27|30|31|32|33|34|35|36|37|38|39|40|41|42|43|181|44|45|(3:175|46|47)|(3:167|48|(1:50))|59|60|61|62|193|63|67|68|69|70|71|72|179|73|74|173|75|76|80|81|171|82|(3:165|83|84)|177|85|94|95|169|96|99|100|101|102|103|104|105|106|107|108|109|(1:126)(3:115|(4:117|118|183|119)(1:123)|124)|127|128|188|129|(4:132|(2:134|198)(1:199)|135|130)|197|136|140|152|(1:154)|155|156) */
    /* JADX WARN: Can't wrap try/catch for region: R(95:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|191|26|27|30|31|32|33|34|35|36|37|38|39|40|41|42|43|181|44|45|175|46|47|(3:167|48|(1:50))|59|60|61|62|193|63|67|68|69|70|71|72|179|73|74|173|75|76|80|81|171|82|(3:165|83|84)|177|85|94|95|169|96|99|100|101|102|103|104|105|106|107|108|109|(1:126)(3:115|(4:117|118|183|119)(1:123)|124)|127|128|188|129|(4:132|(2:134|198)(1:199)|135|130)|197|136|140|152|(1:154)|155|156) */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x030f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0310, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0178, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0179, code lost:
    
        r0.printStackTrace();
        r11 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c8, code lost:
    
        r11 = " ";
        r15 = "AD_AND";
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01cb, code lost:
    
        r11 = " ";
        r15 = "AD_AND";
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01cf, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0208, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0209, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0228, code lost:
    
        r3 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0287 A[Catch: all -> 0x036d, TryCatch #11 {all -> 0x036d, blocks: (B:59:0x0155, B:61:0x0162, B:67:0x017e, B:69:0x0187, B:71:0x019a, B:80:0x01d1, B:85:0x0202, B:94:0x0210, B:99:0x022a, B:101:0x0233, B:103:0x0244, B:105:0x024d, B:107:0x026b, B:109:0x0279, B:111:0x0287, B:113:0x028d, B:115:0x0295, B:117:0x029b, B:119:0x02a3, B:124:0x02af, B:128:0x02b8, B:140:0x0313, B:139:0x0310, B:122:0x02aa, B:145:0x0369, B:146:0x036c, B:66:0x0179, B:58:0x0150, B:91:0x020a, B:129:0x02bf, B:132:0x02c8, B:134:0x02dc, B:135:0x02e7, B:136:0x02ea, B:63:0x016b), top: B:185:0x0150, inners: #0, #10, #13, #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02c8 A[Catch: all -> 0x030f, TryCatch #13 {all -> 0x030f, blocks: (B:129:0x02bf, B:132:0x02c8, B:134:0x02dc, B:135:0x02e7, B:136:0x02ea), top: B:188:0x02bf, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0392  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r25, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 930
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    public void b(String str) {
        this.a = str;
    }
}
