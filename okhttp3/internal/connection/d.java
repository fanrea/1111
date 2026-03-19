package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d {
    private final Set<Route> AL = new LinkedHashSet();

    public final synchronized void a(Route route) {
        this.AL.add(route);
    }

    public final synchronized void b(Route route) {
        this.AL.remove(route);
    }

    public final synchronized boolean c(Route route) {
        return this.AL.contains(route);
    }
}
