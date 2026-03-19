package com.baidu.mobstat.forbes;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class PrefOperate {
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:23:0x007a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static void loadMetaDataConfig(android.content.Context r7) {
        /*
            java.lang.String r0 = "true"
            java.lang.String r1 = ""
            com.baidu.mobstat.forbes.SendStrategyEnum r2 = com.baidu.mobstat.forbes.SendStrategyEnum.APP_START
            r3 = 0
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L1c
            if (r4 != 0) goto L1b
            boolean r4 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
            if (r4 == 0) goto L1b
            com.baidu.mobstat.forbes.ExceptionAnalysis r4 = com.baidu.mobstat.forbes.ExceptionAnalysis.getInstance()     // Catch: java.lang.Exception -> L1c
            r4.openExceptionAnalysis(r7, r3)     // Catch: java.lang.Exception -> L1c
        L1b:
            goto L1d
        L1c:
            r4 = move-exception
        L1d:
            r4 = 24
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L7a
            if (r5 != 0) goto L79
            com.baidu.mobstat.forbes.SendStrategyEnum r5 = com.baidu.mobstat.forbes.SendStrategyEnum.APP_START     // Catch: java.lang.Exception -> L7a
            java.lang.String r5 = r5.name()     // Catch: java.lang.Exception -> L7a
            boolean r5 = r1.equals(r5)     // Catch: java.lang.Exception -> L7a
            if (r5 == 0) goto L3f
            com.baidu.mobstat.forbes.SendStrategyEnum r2 = com.baidu.mobstat.forbes.SendStrategyEnum.APP_START     // Catch: java.lang.Exception -> L7a
            com.baidu.mobstat.forbes.al r5 = com.baidu.mobstat.forbes.al.a()     // Catch: java.lang.Exception -> L7a
            int r6 = r2.ordinal()     // Catch: java.lang.Exception -> L7a
            r5.a(r7, r6)     // Catch: java.lang.Exception -> L7a
            goto L79
        L3f:
            com.baidu.mobstat.forbes.SendStrategyEnum r5 = com.baidu.mobstat.forbes.SendStrategyEnum.ONCE_A_DAY     // Catch: java.lang.Exception -> L7a
            java.lang.String r5 = r5.name()     // Catch: java.lang.Exception -> L7a
            boolean r5 = r1.equals(r5)     // Catch: java.lang.Exception -> L7a
            if (r5 == 0) goto L60
            com.baidu.mobstat.forbes.SendStrategyEnum r2 = com.baidu.mobstat.forbes.SendStrategyEnum.ONCE_A_DAY     // Catch: java.lang.Exception -> L7a
            com.baidu.mobstat.forbes.al r5 = com.baidu.mobstat.forbes.al.a()     // Catch: java.lang.Exception -> L7a
            int r6 = r2.ordinal()     // Catch: java.lang.Exception -> L7a
            r5.a(r7, r6)     // Catch: java.lang.Exception -> L7a
            com.baidu.mobstat.forbes.al r5 = com.baidu.mobstat.forbes.al.a()     // Catch: java.lang.Exception -> L7a
            r5.b(r7, r4)     // Catch: java.lang.Exception -> L7a
            goto L79
        L60:
            com.baidu.mobstat.forbes.SendStrategyEnum r5 = com.baidu.mobstat.forbes.SendStrategyEnum.SET_TIME_INTERVAL     // Catch: java.lang.Exception -> L7a
            java.lang.String r5 = r5.name()     // Catch: java.lang.Exception -> L7a
            boolean r5 = r1.equals(r5)     // Catch: java.lang.Exception -> L7a
            if (r5 == 0) goto L79
            com.baidu.mobstat.forbes.SendStrategyEnum r2 = com.baidu.mobstat.forbes.SendStrategyEnum.SET_TIME_INTERVAL     // Catch: java.lang.Exception -> L7a
            com.baidu.mobstat.forbes.al r5 = com.baidu.mobstat.forbes.al.a()     // Catch: java.lang.Exception -> L7a
            int r6 = r2.ordinal()     // Catch: java.lang.Exception -> L7a
            r5.a(r7, r6)     // Catch: java.lang.Exception -> L7a
        L79:
            goto L7b
        L7a:
            r5 = move-exception
        L7b:
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L9e
            if (r5 != 0) goto L9d
            int r5 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L9e
            int r2 = r2.ordinal()     // Catch: java.lang.Exception -> L9e
            com.baidu.mobstat.forbes.SendStrategyEnum r6 = com.baidu.mobstat.forbes.SendStrategyEnum.SET_TIME_INTERVAL     // Catch: java.lang.Exception -> L9e
            int r6 = r6.ordinal()     // Catch: java.lang.Exception -> L9e
            if (r2 != r6) goto L9d
            if (r5 <= 0) goto L9d
            if (r5 > r4) goto L9d
            com.baidu.mobstat.forbes.al r2 = com.baidu.mobstat.forbes.al.a()     // Catch: java.lang.Exception -> L9e
            r2.b(r7, r5)     // Catch: java.lang.Exception -> L9e
        L9d:
            goto L9f
        L9e:
            r2 = move-exception
        L9f:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Lc5
            if (r2 != 0) goto Lc4
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Lc5
            if (r0 == 0) goto Lb5
            com.baidu.mobstat.forbes.al r0 = com.baidu.mobstat.forbes.al.a()     // Catch: java.lang.Exception -> Lc5
            r1 = 1
            r0.a(r7, r1)     // Catch: java.lang.Exception -> Lc5
            goto Lc4
        Lb5:
            java.lang.String r0 = "false"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Lc5
            if (r0 == 0) goto Lc4
            com.baidu.mobstat.forbes.al r0 = com.baidu.mobstat.forbes.al.a()     // Catch: java.lang.Exception -> Lc5
            r0.a(r7, r3)     // Catch: java.lang.Exception -> Lc5
        Lc4:
            goto Lc6
        Lc5:
            r7 = move-exception
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.PrefOperate.loadMetaDataConfig(android.content.Context):void");
    }

    public static void setAppKey(String str) {
        CooperService.instance().getHeadObject().e = str;
    }

    public static String getAppKey(Context context) {
        return CooperService.instance().getAppKey(context);
    }

    public static void setAppChannel(String str) {
        if (str == null || str.equals("")) {
            v.c().c("[WARNING] The channel you have set is empty");
        }
        CooperService.instance().getHeadObject().l = str;
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        if (str == null || str.equals("")) {
            v.c().c("[WARNING] The channel you have set is empty");
        }
        CooperService.instance().getHeadObject().l = str;
        if (z && str != null && !str.equals("")) {
            al.a().b(context, str);
            al.a().b(context, true);
        }
        if (!z) {
            al.a().b(context, "");
            al.a().b(context, false);
        }
    }
}
