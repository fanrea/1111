package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ah {
    static final int a = 1;
    private static final String b = "LocalBroadcastManager";
    private static final boolean c = false;
    private static final Object d = new Object();
    private static ah e;
    private final Context f;
    private final HashMap<BroadcastReceiver, ArrayList<b>> g = new HashMap<>();
    private final HashMap<String, ArrayList<b>> h = new HashMap<>();
    private final ArrayList<a> i = new ArrayList<>();
    private final Handler j = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.base.common.ah.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                ah.this.a();
            } else {
                super.handleMessage(msg);
            }
        }
    };

    private static final class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent _intent, ArrayList<b> _receivers) {
            this.a = _intent;
            this.b = _receivers;
        }
    }

    private static final class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        b(IntentFilter _filter, BroadcastReceiver _receiver) {
            this.a = _filter;
            this.b = _receiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append(com.alipay.sdk.m.u.i.d);
            return sb.toString();
        }
    }

    private ah(Context context) {
        this.f = context;
    }

    public static ah a(Context context) {
        ah ahVar;
        synchronized (d) {
            if (e == null) {
                e = new ah(context.getApplicationContext());
            }
            ahVar = e;
        }
        return ahVar;
    }

    void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.g) {
                size = this.i.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.i.toArray(aVarArr);
                this.i.clear();
            }
            for (int i = 0; i < size; i++) {
                a aVar = aVarArr[i];
                int size2 = aVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = aVar.b.get(i2);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.f, aVar.a);
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver receiver) {
        synchronized (this.g) {
            ArrayList<b> arrayListRemove = this.g.remove(receiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                b bVar = arrayListRemove.get(size);
                bVar.d = true;
                for (int i = 0; i < bVar.a.countActions(); i++) {
                    String action = bVar.a.getAction(i);
                    ArrayList<b> arrayList = this.h.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.b == receiver) {
                                bVar2.d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.h.remove(action);
                        }
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver receiver, IntentFilter filter) {
        synchronized (this.g) {
            b bVar = new b(filter, receiver);
            ArrayList<b> arrayList = this.g.get(receiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.g.put(receiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < filter.countActions(); i++) {
                String action = filter.getAction(i);
                ArrayList<b> arrayList2 = this.h.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.h.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public boolean a(Intent intent) {
        return a(intent, 0);
    }

    public boolean a(Intent intent, int delay) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        Uri uri;
        synchronized (this.g) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v(b, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.h.get(intent.getAction());
            if (arrayList3 == null) {
                return false;
            }
            if (z) {
                Log.v(b, "Action list: " + arrayList3);
            }
            ArrayList arrayList4 = null;
            int i2 = 0;
            while (i2 < arrayList3.size()) {
                b bVar = arrayList3.get(i2);
                if (z) {
                    Log.v(b, "Matching against filter " + bVar.a);
                }
                if (bVar.c) {
                    if (z) {
                        Log.v(b, "  Filter's target already added");
                    }
                    i = i2;
                    arrayList2 = arrayList3;
                    str = action;
                    str2 = strResolveTypeIfNeeded;
                    uri = data;
                    arrayList = arrayList4;
                } else {
                    i = i2;
                    str = action;
                    arrayList = arrayList4;
                    arrayList2 = arrayList3;
                    str2 = strResolveTypeIfNeeded;
                    uri = data;
                    int iMatch = bVar.a.match(action, strResolveTypeIfNeeded, scheme, data, categories, b);
                    if (iMatch >= 0) {
                        if (z) {
                            Log.v(b, "  Filter matched! match=0x" + Integer.toHexString(iMatch));
                        }
                        arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList4.add(bVar);
                        bVar.c = true;
                        i2 = i + 1;
                        data = uri;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    } else if (z) {
                        Log.v(b, "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                    }
                }
                arrayList4 = arrayList;
                i2 = i + 1;
                data = uri;
                action = str;
                arrayList3 = arrayList2;
                strResolveTypeIfNeeded = str2;
            }
            ArrayList arrayList5 = arrayList4;
            if (arrayList5 == null) {
                return false;
            }
            for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                ((b) arrayList5.get(i3)).c = false;
            }
            this.i.add(new a(intent, arrayList5));
            if (!this.j.hasMessages(1)) {
                if (delay > 0) {
                    this.j.sendEmptyMessageDelayed(1, delay);
                } else {
                    this.j.sendEmptyMessage(1);
                }
            }
            return true;
        }
    }

    public void b(Intent intent) {
        if (a(intent)) {
            a();
        }
    }
}
