package com.baidu.mobads.container.components.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f implements a {
    private final CopyOnWriteArrayList<e> a = new CopyOnWriteArrayList<>();
    private String b = "";
    private boolean c = false;
    private int d = 0;

    public boolean a(e eVar) {
        return this.a.add(eVar);
    }

    public boolean b(e eVar) {
        return this.a.remove(eVar);
    }

    public boolean a() {
        return this.a.isEmpty();
    }

    public boolean b() {
        return this.c;
    }

    @Override // com.baidu.mobads.container.components.b.a
    public void a(Activity activity, Bundle bundle) {
    }

    @Override // com.baidu.mobads.container.components.b.a
    public void a(Activity activity) {
        if (this.d < 0) {
            this.d = 0;
        }
        this.d++;
        this.b = g(activity);
        if (this.d == 1 && !this.c) {
            h(activity);
        }
        this.c = true;
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(activity);
        }
    }

    @Override // com.baidu.mobads.container.components.b.a
    public void b(Activity activity) {
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(activity);
        }
    }

    @Override // com.baidu.mobads.container.components.b.a
    public void c(Activity activity) {
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(activity);
        }
    }

    @Override // com.baidu.mobads.container.components.b.a
    public void d(Activity activity) {
        if (this.d < 1) {
            this.b = f(activity);
            this.d = a(activity, this.b) ? 2 : 1;
            this.c = true;
        } else if (this.d == 1 && a(activity, this.b)) {
            this.d = 2;
        }
        this.b = "";
        this.d--;
        if (this.d == 0 && this.c) {
            this.c = false;
            i(activity);
        }
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f(activity);
        }
    }

    @Override // com.baidu.mobads.container.components.b.a
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // com.baidu.mobads.container.components.b.a
    public void e(Activity activity) {
    }

    private String f(Activity activity) {
        ComponentName componentName;
        try {
            List<ActivityManager.RunningTaskInfo> listB = new com.component.c.a(activity).b(1);
            if (listB != null && !listB.isEmpty() && (componentName = listB.get(0).topActivity) != null) {
                return componentName.getClassName();
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private boolean a(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && activity != null) {
            return !TextUtils.equals(str, g(activity));
        }
        return false;
    }

    private String g(Activity activity) {
        if (activity != null) {
            return activity.getClass().getName();
        }
        return "";
    }

    private void h(Activity activity) {
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(activity);
        }
    }

    private void i(Activity activity) {
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(activity);
        }
    }
}
