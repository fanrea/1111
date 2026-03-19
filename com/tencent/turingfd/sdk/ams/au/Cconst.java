package com.tencent.turingfd.sdk.ams.au;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.ams.au.Betelnut;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.const, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cconst extends Handler {
    public final Nucleus a;
    public final List<Pegasus> b;

    public Cconst(Looper looper, Nucleus nucleus) {
        super(looper);
        this.b = new ArrayList();
        this.a = nucleus;
    }

    public final void a() {
        for (Pegasus pegasus : this.b) {
            pegasus.getClass();
            synchronized (Pegasus.i) {
                int i = Pegasus.j;
                if (i < 200) {
                    Pegasus.j = i + 1;
                    pegasus.a = Pegasus.k;
                    Pegasus.k = pegasus;
                }
            }
        }
        this.b.clear();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        Fig fig = null;
        if (i == 1) {
            Object obj = message.obj;
            if (obj instanceof String) {
                ((Betelnut.Cdo) this.a).a(new Cfinal((String) obj, 3, null));
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        Object obj2 = message.obj;
        if (obj2 instanceof Pegasus) {
            Pegasus pegasus = (Pegasus) obj2;
            String str = pegasus.b;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!this.b.isEmpty() && !this.b.get(0).b.equals(pegasus.b)) {
                a();
            }
            int i2 = pegasus.c;
            if (i2 == 0) {
                a();
                this.b.add(pegasus);
                return;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    this.b.isEmpty();
                    this.b.add(pegasus);
                    return;
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    a();
                    return;
                }
            }
            if (this.b.isEmpty()) {
                return;
            }
            this.b.add(pegasus);
            List<Pegasus> list = this.b;
            ArrayList arrayList = new ArrayList();
            if (list.size() <= 8) {
                arrayList.addAll(list);
            } else {
                Pegasus pegasus2 = list.get(0);
                Pegasus pegasus3 = list.get(list.size() - 1);
                list.remove(pegasus2);
                list.remove(pegasus3);
                int iCeil = (int) Math.ceil(list.size() / 6);
                arrayList.add(pegasus2);
                for (int i3 = 1; i3 < list.size(); i3 += iCeil) {
                    arrayList.add(list.get(i3));
                }
                arrayList.add(pegasus3);
            }
            if (!arrayList.isEmpty()) {
                Pegasus pegasus4 = (Pegasus) arrayList.get(0);
                Fig fig2 = new Fig();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = pegasus4.h;
                fig2.b = (int) (jCurrentTimeMillis - j);
                fig2.a = j;
                ArrayList<Filbert> arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Pegasus pegasus5 = (Pegasus) it.next();
                    Filbert filbert = new Filbert();
                    int i4 = pegasus5.c;
                    if (i4 == 0) {
                        filbert.a = 1;
                    } else if (i4 == 1) {
                        filbert.a = 3;
                    } else if (i4 == 2) {
                        filbert.a = 2;
                    } else if (i4 != 3) {
                        filbert.a = 0;
                    } else {
                        filbert.a = 4;
                    }
                    filbert.d = pegasus5.f;
                    filbert.e = pegasus5.g;
                    arrayList2.add(filbert);
                }
                fig2.c = arrayList2;
                fig = fig2;
            }
            if (fig == null) {
                return;
            }
            if (pegasus.d <= 0) {
                fig.d |= 1;
            }
            if (pegasus.e == 0) {
                fig.d |= 2;
            }
            if (fig.d != 0) {
                ((Betelnut.Cdo) this.a).a(new Cfinal(str, 2, fig));
            } else {
                ((Betelnut.Cdo) this.a).a(new Cfinal(str, 1, fig));
            }
            a();
        }
    }
}
