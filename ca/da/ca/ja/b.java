package ca.da.ca.ja;

import com.apm.applog.IDataObserver;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* compiled from: DataObserverHolder.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements IDataObserver {
    public static volatile ConcurrentHashMap<String, b> b = new ConcurrentHashMap<>();
    public final CopyOnWriteArraySet<IDataObserver> a = new CopyOnWriteArraySet<>();

    public static b a(String str) {
        b bVar = b.get(str);
        if (bVar == null) {
            synchronized (b.class) {
                bVar = new b();
                b.put(str, bVar);
            }
        }
        return bVar;
    }

    public void b(IDataObserver iDataObserver) {
        if (iDataObserver != null) {
            this.a.remove(iDataObserver);
        }
    }

    @Override // com.apm.applog.IDataObserver
    public void onAbVidsChange(String str, String str2) {
        Iterator<IDataObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onAbVidsChange(str, str2);
        }
    }

    @Override // com.apm.applog.IDataObserver
    public void onIdLoaded(String str, String str2, String str3) {
        Iterator<IDataObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onIdLoaded(str, str2, str3);
        }
    }

    @Override // com.apm.applog.IDataObserver
    public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onRemoteAbConfigGet(z, jSONObject);
        }
    }

    @Override // com.apm.applog.IDataObserver
    public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onRemoteConfigGet(z, jSONObject);
        }
    }

    @Override // com.apm.applog.IDataObserver
    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<IDataObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
        }
    }

    public void a(IDataObserver iDataObserver) {
        if (iDataObserver != null) {
            this.a.add(iDataObserver);
        }
    }
}
