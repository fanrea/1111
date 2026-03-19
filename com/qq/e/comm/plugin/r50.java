package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class r50 {
    private final int a;
    private final Map<String, Queue<oh>> b;

    /* compiled from: A */
    private static final class b {
        private static final r50 a = new r50(null);
    }

    private r50() {
        this.b = new ConcurrentHashMap();
        this.a = r1.d().f().a("wvmcc", 2);
    }

    /* synthetic */ r50(a aVar) {
        this();
    }

    public oh a(Context context, String str) {
        Queue<oh> queue = this.b.get(str);
        oh ohVarPoll = (queue == null || queue.isEmpty()) ? null : queue.poll();
        if (ohVarPoll == null) {
            return a(context);
        }
        ((MutableContextWrapper) ohVarPoll.getContext()).setBaseContext(context);
        return ohVarPoll;
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ WebView a;

        a(WebView webView) {
            this.a = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r50.this.b.isEmpty()) {
                return;
            }
            Iterator it = r50.this.b.entrySet().iterator();
            while (it.hasNext()) {
                Queue<oh> queue = (Queue) ((Map.Entry) it.next()).getValue();
                if (queue != null && !queue.isEmpty()) {
                    for (oh ohVar : queue) {
                        WebView webView = this.a;
                        if ((webView == null && ohVar != null) || (webView != null && ohVar == webView)) {
                            ohVar.destroy();
                        }
                    }
                }
            }
            if (this.a == null) {
                r50.this.b.clear();
            }
        }
    }

    public void a(oh ohVar, String str) {
        if (ohVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && (ohVar.getContext() instanceof MutableContextWrapper) && ohVar.g()) {
            Queue<oh> linkedList = this.b.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.b.put(str, linkedList);
            }
            if (linkedList.contains(ohVar)) {
                return;
            }
            if (linkedList.size() < this.a) {
                MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) ohVar.getContext();
                mutableContextWrapper.setBaseContext(mutableContextWrapper.getApplicationContext());
                ohVar.g(true);
                ohVar.k();
                linkedList.offer(ohVar);
            } else {
                ohVar.destroy();
            }
            b50.a(ohVar);
            return;
        }
        ohVar.destroy();
        b50.a(ohVar);
    }

    public static r50 a() {
        return b.a;
    }

    private oh a(Context context) {
        try {
            return new oh(new MutableContextWrapper(context));
        } catch (Resources.NotFoundException unused) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 21 && i < 23) {
                return new oh(new MutableContextWrapper(context.createConfigurationContext(new Configuration())));
            }
            return new oh(new MutableContextWrapper(context.getApplicationContext()));
        }
    }

    public void a(WebView webView) {
        xo.a((Runnable) new a(webView));
    }
}
