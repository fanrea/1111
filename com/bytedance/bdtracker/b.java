package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IAppLogInstance;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b {
    public static e a = new a();
    public static e b = new C0184b();
    public static e c = new c();

    public static class a implements e {
        @Override // com.bytedance.bdtracker.b.e
        public boolean a(com.bytedance.bdtracker.d dVar) {
            return dVar.isH5CollectEnable();
        }
    }

    /* renamed from: com.bytedance.bdtracker.b$b, reason: collision with other inner class name */
    public static class C0184b implements e {
        @Override // com.bytedance.bdtracker.b.e
        public boolean a(com.bytedance.bdtracker.d dVar) {
            return dVar.getInitConfig() != null && dVar.getInitConfig().isHandleLifeCycle();
        }
    }

    public static class c implements e {
        @Override // com.bytedance.bdtracker.b.e
        public boolean a(com.bytedance.bdtracker.d dVar) {
            return !(dVar.getInitConfig() != null && dVar.getInitConfig().isPageMetaAnnotationEnable());
        }
    }

    public interface d {
        void a(com.bytedance.bdtracker.d dVar);
    }

    public interface e {
        boolean a(com.bytedance.bdtracker.d dVar);
    }

    public interface f {
        t3 a();
    }

    public static com.bytedance.bdtracker.d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.bytedance.bdtracker.d dVar : com.bytedance.bdtracker.d.J) {
            if (str.equals(dVar.m)) {
                return dVar;
            }
        }
        return null;
    }

    public static boolean b(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            Iterator<com.bytedance.bdtracker.d> it = com.bytedance.bdtracker.d.J.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (str.equals(it.next().m)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static String a(IAppLogInstance iAppLogInstance, String str) {
        return AppLog.getInstance() == iAppLogInstance ? str : str + Config.replace + iAppLogInstance.getAppId();
    }

    public static void a(d dVar) {
        Iterator<com.bytedance.bdtracker.d> it = com.bytedance.bdtracker.d.J.iterator();
        while (it.hasNext()) {
            dVar.a(it.next());
        }
    }

    public static boolean a(e eVar) {
        Iterator<com.bytedance.bdtracker.d> it = com.bytedance.bdtracker.d.J.iterator();
        while (it.hasNext()) {
            if (eVar.a(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void a(String[] strArr) {
        Iterator<com.bytedance.bdtracker.d> it = com.bytedance.bdtracker.d.J.iterator();
        while (it.hasNext()) {
            it.next().receive((String[]) strArr.clone());
        }
    }

    public static void a(f fVar, e eVar) {
        t3 t3VarA = null;
        for (com.bytedance.bdtracker.d dVar : com.bytedance.bdtracker.d.J) {
            if (eVar.a(dVar)) {
                if (t3VarA == null) {
                    t3VarA = fVar.a();
                }
                dVar.receive(t3VarA.m347clone());
            }
        }
    }

    public static void a(t3 t3Var, e eVar) {
        for (com.bytedance.bdtracker.d dVar : com.bytedance.bdtracker.d.J) {
            if (eVar.a(dVar)) {
                dVar.receive(t3Var.m347clone());
            }
        }
    }
}
