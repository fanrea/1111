package com.kuaishou.aegon.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    /* renamed from: com.kuaishou.aegon.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0398a<T> {
        T get();
    }

    public static void a(Runnable runnable) {
        try {
            try {
                runnable.run();
            } catch (UnsatisfiedLinkError unused) {
                runnable.run();
            }
        } catch (UnsatisfiedLinkError unused2) {
            runnable.run();
        }
    }

    public static <T> T a(InterfaceC0398a<T> interfaceC0398a) {
        try {
            try {
                return interfaceC0398a.get();
            } catch (UnsatisfiedLinkError unused) {
                return interfaceC0398a.get();
            }
        } catch (UnsatisfiedLinkError unused2) {
            return interfaceC0398a.get();
        }
    }

    public static void b(Runnable runnable) {
        try {
            runnable.run();
        } catch (UnsatisfiedLinkError unused) {
        }
    }
}
