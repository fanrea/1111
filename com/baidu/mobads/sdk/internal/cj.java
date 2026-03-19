package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.x;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class cj implements Observer {
    private static final String a = "APKParser";
    private static final String g = "__xadsdk_downloaded__version__";
    private static final String h = "version";
    private Context b;
    private URL c;
    private String d;
    private final by e;
    private a f;
    private SharedPreferences i;
    private SharedPreferences.OnSharedPreferenceChangeListener j;

    public interface a {
        void a(by byVar);

        void b(by byVar);
    }

    public cj(Context context, URL url, by byVar, a aVar) {
        this.c = null;
        this.d = null;
        this.j = new ck(this);
        this.c = url;
        this.e = byVar;
        a(context, aVar);
    }

    public cj(Context context, String str, by byVar, a aVar) {
        this.c = null;
        this.d = null;
        this.j = new ck(this);
        this.d = str;
        this.e = byVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.b = context;
        this.f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(g, 0);
        this.i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.j);
    }

    public void a(String str, String str2) {
        am amVar = new am(this.b, this.d != null ? new URL(this.d) : this.c, str, str2, false);
        amVar.addObserver(this);
        amVar.a();
        SharedPreferences.Editor editorEdit = this.i.edit();
        editorEdit.putString("version", this.e.toString());
        editorEdit.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        x xVar = (x) observable;
        if (xVar.l() == x.a.COMPLETED) {
            this.f.a(new by(this.e, xVar.g(), true));
        }
        if (xVar.l() == x.a.ERROR) {
            this.f.b(new by(this.e, xVar.g(), false));
        }
    }
}
