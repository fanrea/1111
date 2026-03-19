package ca.da.ca.ja;

/* compiled from: DeprecatedFileCleaner.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d implements Runnable {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.a.a.size(); i++) {
            try {
                String[] strArr = {"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", com.baidu.mobads.upgrade.remote.gray.c.l};
                for (int i2 = 0; i2 < 6; i2++) {
                    String str = strArr[i2];
                    try {
                        e eVar = this.a;
                        eVar.a(eVar.a.get(i), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }
}
