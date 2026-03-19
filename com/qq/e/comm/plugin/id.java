package com.qq.e.comm.plugin;

import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class id {
    private static final Map<String, Integer> a = new HashMap();

    static void a(f5 f5Var) {
        b10.a(1401000, f5Var);
    }

    static void b(f5 f5Var) {
        b10.a(1401002, f5Var);
    }

    static void b(f5 f5Var, int i) {
        b10.b(1401001, f5Var, Integer.valueOf(i));
    }

    static void c(f5 f5Var) {
        b10.a(1210022, f5Var);
    }

    static void a(int i, f5 f5Var) {
        if (i == 200) {
            b10.a(1210014, f5Var);
            return;
        }
        b10.a(1210015, f5Var);
        switch (i) {
            case 202:
                b10.a(1210016, f5Var);
                break;
            case 203:
                b10.a(1210017, f5Var);
                break;
            case 204:
                b10.a(1210018, f5Var);
                break;
            case 205:
                b10.a(1210019, f5Var);
                break;
            case 206:
                b10.a(1210020, f5Var);
                break;
        }
    }

    static void b(f5 f5Var, long j) {
        x6.c(f5Var, j);
    }

    static void b(f5 f5Var, int i, long j, long j2) {
        b10.a(1130112, f5Var, null, null, new ja().a("progress", Integer.valueOf(i)).a("finished", Long.valueOf(j)).a(Config.EXCEPTION_MEMORY_TOTAL, Long.valueOf(j2)));
    }

    public static void c(f5 f5Var, long j) {
        x6.d(f5Var, j);
    }

    public static void a(f5 f5Var, int i, int i2) {
        b10.a(1401006, f5Var, Integer.valueOf(i), Integer.valueOf(i2), null);
    }

    public static void a(f5 f5Var, int i) {
        b10.a(1404000, f5Var, Integer.valueOf(i));
    }

    public static void a(f5 f5Var, long j) {
        x6.b(f5Var, j);
    }

    public static void a(f5 f5Var, long j, long j2) {
        x6.a(f5Var, j, j2);
    }

    static void a(f5 f5Var, int i, long j, long j2) {
        b10.a(1130113, f5Var, null, null, new ja().a("progress", Integer.valueOf(i)).a("finished", Long.valueOf(j)).a(Config.EXCEPTION_MEMORY_TOTAL, Long.valueOf(j2)));
    }
}
