package ca.da.ca.ja;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* compiled from: EventObserverHolder.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h implements ca.da.ca.b {
    public static volatile h b;
    public final CopyOnWriteArraySet<ca.da.ca.b> a = new CopyOnWriteArraySet<>();

    public static h a() {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h();
                }
            }
        }
        return b;
    }

    public void b(ca.da.ca.b bVar) {
        if (bVar != null) {
            this.a.remove(bVar);
        }
    }

    public void a(String str, String str2, String str3, long j, long j2, String str4) {
        Iterator<ca.da.ca.b> it = this.a.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(str, str2, str3, j, j2, str4);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        Iterator<ca.da.ca.b> it = this.a.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(str, jSONObject);
        }
    }

    public void a(ca.da.ca.b bVar) {
        if (bVar != null) {
            this.a.add(bVar);
        }
    }
}
