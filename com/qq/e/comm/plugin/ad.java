package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.kuaishou.socket.nano.SocketMessages;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ad {
    private static final Pattern a = Pattern.compile(".*[?&]viewid=([^&]*).*");
    private static final Set<String> b = new HashSet();

    /* compiled from: A */
    public interface a {
    }

    private static String a() {
        return (String) pro.getobjresult(632, 1, new Object[0]);
    }

    private static String a(String str) {
        return (String) pro.getobjresult(633, 1, str);
    }

    public static void a(int i, int i2, int i3, int i4, int i5, int i6, h4 h4Var, int i7, a aVar) {
        pro.getVresult(SocketMessages.PayloadType.SC_THEATER_EPISODE_SWITCH_TOAST, 1, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), h4Var, Integer.valueOf(i7), aVar);
    }

    public static void a(int i, int i2, int i3, int i4, int i5, int i6, h4 h4Var, a aVar) {
        pro.getVresult(635, 1, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), h4Var, aVar);
    }

    private static void a(h4 h4Var, f5 f5Var) {
        pro.getVresult(636, 1, h4Var, f5Var);
    }

    private static void a(String str, h4 h4Var, a aVar, f5 f5Var) {
        pro.getVresult(637, 1, str, h4Var, aVar, f5Var);
    }

    public static void a(String str, h4 h4Var, String str2, int i, a aVar) {
        pro.getVresult(638, 1, str, h4Var, str2, Integer.valueOf(i), aVar);
    }

    private static void a(String str, String str2, h4 h4Var, String str3, int i, a aVar, f5 f5Var) {
        pro.getVresult(639, 1, str, str2, h4Var, str3, Integer.valueOf(i), aVar, f5Var);
    }

    private static boolean a(h4 h4Var) {
        return pro.getZresult(640, 1, h4Var);
    }

    /* compiled from: A */
    private static class b implements qr {
        private final h4 a;

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, Exception exc) {
        }

        b(h4 h4Var, a aVar) {
            this.a = h4Var;
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            int iA = hwVar == null ? 0 : hwVar.a();
            if ((iA == 200 || iA == 204) && !TextUtils.isEmpty(this.a.F())) {
                zt.a(this.a.F());
            }
        }
    }
}
