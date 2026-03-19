package ca.da.ca.ab;

import ca.da.ca.ab.b;

/* compiled from: UserProfileReporter.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ e b;

    public c(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.b.d;
        if (aVar != null) {
            ((b.a) aVar).a(this.a);
        }
    }
}
