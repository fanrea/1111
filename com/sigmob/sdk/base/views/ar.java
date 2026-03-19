package com.sigmob.sdk.base.views;

import aegon.chrome.net.impl.JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.czhj.sdk.logger.SigmobLog;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ar {
    private static ar c;
    private static final AtomicReference<ar> d = new AtomicReference<>();
    private static int e = 2;
    private Queue<g> a;
    private Object b = new Object();

    private ar() {
        if (e > 0) {
            this.a = new LinkedBlockingQueue(e);
        }
    }

    public static ar a() {
        AtomicReference<ar> atomicReference;
        do {
            ar arVar = c;
            if (arVar != null) {
                return arVar;
            }
            atomicReference = d;
        } while (!JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, new ar()));
        ar arVar2 = atomicReference.get();
        c = arVar2;
        return arVar2;
    }

    private g b(Context activity) {
        g gVar;
        Queue<g> queue = this.a;
        g gVarPoll = queue != null ? queue.poll() : null;
        SigmobLog.i("acquireWebViewInternal  webview:" + gVarPoll);
        if (gVarPoll != null) {
            ((MutableContextWrapper) gVarPoll.getContext()).setBaseContext(activity);
            return gVarPoll;
        }
        synchronized (this.b) {
            gVar = new g(new MutableContextWrapper(activity));
        }
        return gVar;
    }

    private void b(g webView) {
        try {
            if (webView.getContext() instanceof MutableContextWrapper) {
                MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) webView.getContext();
                mutableContextWrapper.setBaseContext(mutableContextWrapper.getApplicationContext());
                SigmobLog.i("enqueue  webview:" + webView);
                if (e <= 0 || this.a == null) {
                    webView.destroy();
                } else {
                    webView.b();
                    this.a.offer(webView);
                }
            }
            if (webView.getContext() instanceof Activity) {
                SigmobLog.i("Abandon this webview  ， It will cause leak if enqueue !");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public g a(Context context) {
        return b(context);
    }

    public void a(g webView) {
        b(webView);
    }
}
