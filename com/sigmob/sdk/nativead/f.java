package com.sigmob.sdk.nativead;

import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f implements com.sigmob.sdk.base.common.r {
    public static final String a = "NativeAdViewAbilitySession";

    private void a(BaseAdUnit adUnit, String event, String sub, final HashMap<String, String> options) {
        com.sigmob.sdk.base.common.ac.a(event, sub, adUnit, new ac.a() { // from class: com.sigmob.sdk.nativead.f$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                f.a(options, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(HashMap map, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            if (com.sigmob.sdk.base.utils.e.b(map)) {
                pointEntitySigmob.getOptions().putAll(map);
            }
        }
    }

    public void a(BaseAdUnit adUnit, String event) {
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, int duration, int endTime) {
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0219 A[Catch: all -> 0x07bb, TryCatch #2 {all -> 0x07bb, blocks: (B:3:0x0007, B:7:0x0016, B:10:0x0022, B:13:0x002e, B:16:0x003a, B:19:0x0046, B:22:0x0051, B:25:0x005c, B:28:0x0067, B:31:0x0072, B:34:0x007d, B:37:0x0087, B:40:0x0091, B:43:0x0099, B:46:0x00a1, B:53:0x00e9, B:55:0x00f4, B:59:0x0101, B:62:0x014c, B:63:0x0187, B:68:0x01d9, B:70:0x020b, B:72:0x0213, B:74:0x0223, B:76:0x027a, B:77:0x02b6, B:81:0x02f9, B:83:0x0343, B:85:0x0361, B:86:0x036e, B:88:0x0376, B:89:0x0383, B:78:0x02ba, B:80:0x02c8, B:73:0x0219, B:64:0x018b, B:66:0x0199, B:67:0x01ca, B:90:0x0390, B:112:0x0793, B:115:0x079b, B:116:0x07a3, B:117:0x07a7, B:118:0x07b0), top: B:126:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027a A[Catch: all -> 0x07bb, TryCatch #2 {all -> 0x07bb, blocks: (B:3:0x0007, B:7:0x0016, B:10:0x0022, B:13:0x002e, B:16:0x003a, B:19:0x0046, B:22:0x0051, B:25:0x005c, B:28:0x0067, B:31:0x0072, B:34:0x007d, B:37:0x0087, B:40:0x0091, B:43:0x0099, B:46:0x00a1, B:53:0x00e9, B:55:0x00f4, B:59:0x0101, B:62:0x014c, B:63:0x0187, B:68:0x01d9, B:70:0x020b, B:72:0x0213, B:74:0x0223, B:76:0x027a, B:77:0x02b6, B:81:0x02f9, B:83:0x0343, B:85:0x0361, B:86:0x036e, B:88:0x0376, B:89:0x0383, B:78:0x02ba, B:80:0x02c8, B:73:0x0219, B:64:0x018b, B:66:0x0199, B:67:0x01ca, B:90:0x0390, B:112:0x0793, B:115:0x079b, B:116:0x07a3, B:117:0x07a7, B:118:0x07b0), top: B:126:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02ba A[Catch: all -> 0x07bb, TryCatch #2 {all -> 0x07bb, blocks: (B:3:0x0007, B:7:0x0016, B:10:0x0022, B:13:0x002e, B:16:0x003a, B:19:0x0046, B:22:0x0051, B:25:0x005c, B:28:0x0067, B:31:0x0072, B:34:0x007d, B:37:0x0087, B:40:0x0091, B:43:0x0099, B:46:0x00a1, B:53:0x00e9, B:55:0x00f4, B:59:0x0101, B:62:0x014c, B:63:0x0187, B:68:0x01d9, B:70:0x020b, B:72:0x0213, B:74:0x0223, B:76:0x027a, B:77:0x02b6, B:81:0x02f9, B:83:0x0343, B:85:0x0361, B:86:0x036e, B:88:0x0376, B:89:0x0383, B:78:0x02ba, B:80:0x02c8, B:73:0x0219, B:64:0x018b, B:66:0x0199, B:67:0x01ca, B:90:0x0390, B:112:0x0793, B:115:0x079b, B:116:0x07a3, B:117:0x07a7, B:118:0x07b0), top: B:126:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0343 A[Catch: all -> 0x07bb, TryCatch #2 {all -> 0x07bb, blocks: (B:3:0x0007, B:7:0x0016, B:10:0x0022, B:13:0x002e, B:16:0x003a, B:19:0x0046, B:22:0x0051, B:25:0x005c, B:28:0x0067, B:31:0x0072, B:34:0x007d, B:37:0x0087, B:40:0x0091, B:43:0x0099, B:46:0x00a1, B:53:0x00e9, B:55:0x00f4, B:59:0x0101, B:62:0x014c, B:63:0x0187, B:68:0x01d9, B:70:0x020b, B:72:0x0213, B:74:0x0223, B:76:0x027a, B:77:0x02b6, B:81:0x02f9, B:83:0x0343, B:85:0x0361, B:86:0x036e, B:88:0x0376, B:89:0x0383, B:78:0x02ba, B:80:0x02c8, B:73:0x0219, B:64:0x018b, B:66:0x0199, B:67:0x01ca, B:90:0x0390, B:112:0x0793, B:115:0x079b, B:116:0x07a3, B:117:0x07a7, B:118:0x07b0), top: B:126:0x0007 }] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.sigmob.sdk.nativead.f] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v110 */
    /* JADX WARN: Type inference failed for: r4v111 */
    /* JADX WARN: Type inference failed for: r4v112 */
    /* JADX WARN: Type inference failed for: r4v113 */
    /* JADX WARN: Type inference failed for: r4v114 */
    /* JADX WARN: Type inference failed for: r4v115 */
    /* JADX WARN: Type inference failed for: r4v116 */
    /* JADX WARN: Type inference failed for: r4v117 */
    /* JADX WARN: Type inference failed for: r4v118 */
    /* JADX WARN: Type inference failed for: r4v119 */
    /* JADX WARN: Type inference failed for: r4v120 */
    /* JADX WARN: Type inference failed for: r4v121 */
    /* JADX WARN: Type inference failed for: r4v122 */
    /* JADX WARN: Type inference failed for: r4v123 */
    /* JADX WARN: Type inference failed for: r4v124 */
    /* JADX WARN: Type inference failed for: r4v125 */
    /* JADX WARN: Type inference failed for: r4v126 */
    /* JADX WARN: Type inference failed for: r4v127 */
    /* JADX WARN: Type inference failed for: r4v128 */
    /* JADX WARN: Type inference failed for: r4v129 */
    /* JADX WARN: Type inference failed for: r4v130 */
    /* JADX WARN: Type inference failed for: r4v131 */
    /* JADX WARN: Type inference failed for: r4v132 */
    /* JADX WARN: Type inference failed for: r4v133 */
    /* JADX WARN: Type inference failed for: r4v134 */
    /* JADX WARN: Type inference failed for: r4v135 */
    /* JADX WARN: Type inference failed for: r4v136 */
    /* JADX WARN: Type inference failed for: r4v137 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.sigmob.sdk.base.common.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r24, java.lang.String r25, int r26) {
        /*
            Method dump skipped, instructions count: 2100
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.f.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, int):boolean");
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, boolean isForceShow, int playheadMillis) {
        return false;
    }

    public void b(BaseAdUnit adUnit, String event) {
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean b(BaseAdUnit adUnit) {
        return true;
    }
}
