package com.component.lottie;

import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class be {
    private boolean a = false;
    private final Set<a> b = new ArraySet();
    private final Map<String, com.component.lottie.g.e> c = new HashMap();
    private final Comparator<Pair<String, Float>> d = new bf(this);

    public interface a {
        void a(float f);
    }

    void a(boolean z) {
        this.a = z;
    }

    public void a(String str, float f) {
        if (!this.a) {
            return;
        }
        com.component.lottie.g.e eVar = this.c.get(str);
        if (eVar == null) {
            eVar = new com.component.lottie.g.e();
            this.c.put(str, eVar);
        }
        eVar.a(f);
        if (TextUtils.equals(str, "__container")) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(f);
            }
        }
    }

    public void a(a aVar) {
        this.b.add(aVar);
    }

    public void b(a aVar) {
        this.b.remove(aVar);
    }

    public void a() {
        this.c.clear();
    }

    public void b() {
        if (!this.a) {
            return;
        }
        List<Pair<String, Float>> listC = c();
        com.baidu.mobads.container.l.g.h(c.b).c("Render times:");
        for (int i = 0; i < listC.size(); i++) {
            Pair<String, Float> pair = listC.get(i);
            com.baidu.mobads.container.l.g.h(c.b).c(String.format(Locale.CHINA, "\t\t%30s:%.2f", pair.first, pair.second));
        }
    }

    public List<Pair<String, Float>> c() {
        if (!this.a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.c.size());
        for (Map.Entry<String, com.component.lottie.g.e> entry : this.c.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().a())));
        }
        Collections.sort(arrayList, this.d);
        return arrayList;
    }
}
