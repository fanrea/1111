package com.baidu.mobads.container.components.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.container.components.a.o;
import com.baidu.mobads.container.components.e.b;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p implements Runnable {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o.a aVarA;
        com.baidu.mobads.container.components.command.j jVarA;
        try {
            SharedPreferences sharedPreferences = this.a.e.getSharedPreferences(com.baidu.mobads.container.util.j.d, 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ((value instanceof String) && (aVarA = o.a.a((String) value)) != null && aVarA.b() && (jVarA = com.baidu.mobads.container.components.command.j.a(this.a.e, aVarA.e)) != null) {
                    aVarA.a(jVarA);
                    this.a.a(aVarA);
                    key = "";
                }
                if (!TextUtils.isEmpty(key)) {
                    editorEdit.remove(key).apply();
                }
            }
            if (this.a.d.isEmpty()) {
                com.baidu.mobads.container.components.command.j jVar = null;
                for (com.baidu.mobads.container.components.command.j jVar2 : com.baidu.mobads.container.components.command.j.a(this.a.e)) {
                    if ((b.a.DOWNLOADING == jVar2.X || b.a.PAUSED == jVar2.X) && (jVar == null || jVar.ap < jVar2.ap)) {
                        jVar = jVar2;
                    }
                }
                if (jVar != null) {
                    o.a aVar = new o.a(jVar.d(), 203, jVar.ap, 5000L);
                    if (aVar.b()) {
                        aVar.a(jVar);
                        aVar.a(this.a.e);
                        this.a.a(aVar);
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
        }
    }
}
