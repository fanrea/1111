package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.rg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lr extends t4 {
    @Override // com.qq.e.comm.plugin.cl
    public boolean d() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void f() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void n() {
    }

    @Override // com.qq.e.comm.plugin.t4
    public boolean p() {
        return false;
    }

    public lr(Context context, bl blVar, fr frVar, VideoOption videoOption, rg.d dVar, ah ahVar, com.qq.e.comm.plugin.nativeadunified.c cVar, View.OnTouchListener onTouchListener, MediaView mediaView, JSONObject jSONObject) throws JSONException {
        super(context, frVar, blVar, videoOption, dVar, ahVar, cVar, onTouchListener, mediaView, jSONObject);
        this.g.f(0);
        r();
    }

    private void r() throws JSONException {
        this.e = q();
        try {
            mh mhVar = new mh(this.c.getApplicationContext(), e2.NATIVEUNIFIEDAD);
            this.d = mhVar;
            a(mhVar);
        } catch (Exception e) {
            f5 f5VarA = f5.a(this.g);
            ja jaVar = new ja();
            jaVar.a("msg", Log.getStackTraceString(e));
            b10.a(1060030, f5VarA, 0, 0, jaVar);
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rg rgVar = lr.this.e;
            if (rgVar != null) {
                rgVar.j();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.t4
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        this.f.addView(view, layoutParams);
    }

    @Override // com.qq.e.comm.plugin.t4, com.qq.e.comm.plugin.cl
    public void a(MediaView mediaView) throws JSONException {
        super.a(mediaView);
        b50.a(this.e);
        b50.a(this.d.r());
        this.f.addView(this.d.r());
        this.f.addView(this.e);
        c4.a(this.f, this.g.c0(), this.d);
        hp.a(false);
        this.f.setOnClickListener(this.m);
        View.OnTouchListener onTouchListener = this.n;
        if (onTouchListener != null) {
            this.f.setOnTouchListener(onTouchListener);
        }
        this.f.post(new a());
        a((FrameLayout) this.f);
    }
}
