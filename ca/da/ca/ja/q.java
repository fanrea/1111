package ca.da.ca.ja;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* compiled from: SessionObserverHolder.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class q implements ca.da.ca.h {
    public static volatile q b;
    public final CopyOnWriteArraySet<ca.da.ca.h> a = new CopyOnWriteArraySet<>();

    public static q a() {
        if (b == null) {
            synchronized (q.class) {
                b = new q();
            }
        }
        return b;
    }

    public void b(ca.da.ca.h hVar) {
        if (hVar != null) {
            this.a.remove(hVar);
        }
    }

    public void a(long j, String str) {
        Iterator<ca.da.ca.h> it = this.a.iterator();
        while (it.hasNext()) {
            ((q) it.next()).a(j, str);
        }
    }

    public void a(long j, String str, JSONObject jSONObject) {
        Iterator<ca.da.ca.h> it = this.a.iterator();
        while (it.hasNext()) {
            ((q) it.next()).a(j, str, jSONObject);
        }
    }

    public void a(ca.da.ca.h hVar) {
        if (hVar != null) {
            this.a.add(hVar);
        }
    }
}
