package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface b {
        void a(int i);

        void a(EnumSet<EnumC0399a> enumSet, String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    /* renamed from: com.kuaishou.aegon.netcheck.a$a, reason: collision with other inner class name */
    public enum EnumC0399a {
        RESULT_WEAK_SIGNAL(1),
        RESULT_BAD_WIFI_GATEWAY(2),
        RESULT_NOT_CONNECTED(3),
        RESULT_SLOW_INTERNET(4),
        RESULT_BAD_CELLULAR_GATEWAY(5);

        private int f;

        EnumC0399a(int i) {
            this.f = i;
        }

        public final int a() {
            return this.f;
        }
    }
}
