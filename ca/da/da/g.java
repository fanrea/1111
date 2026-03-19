package ca.da.da;

/* compiled from: DrUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g implements Runnable {
    public final Runnable a;

    public g(Runnable runnable, String str) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
