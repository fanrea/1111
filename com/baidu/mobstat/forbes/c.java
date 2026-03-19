package com.baidu.mobstat.forbes;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    public static String a;
    public static String b;
    public static String c;
    public static String d;

    static {
        String name = Build.class.getName();
        String strReplace = name.substring(0, name.lastIndexOf(46)).replace(".", Config.replace);
        a = strReplace + "_mtj_vizParser.js";
        b = strReplace + "_mtj_autoTracker.js";
        c = strReplace + "_mtj_auto.config";
        d = strReplace + "_trace_circle.data";
    }
}
