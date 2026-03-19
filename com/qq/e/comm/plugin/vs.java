package com.qq.e.comm.plugin;

import android.content.Context;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vs extends q0<com.qq.e.comm.plugin.va.m.p> {
    private Context u;
    private String v;
    private String[] w;
    private Constructor<com.qq.e.comm.plugin.va.m.p> x;

    /* compiled from: A */
    private static final class b {
        private static vs a = new vs();
    }

    public static vs l() {
        return b.a;
    }

    private static boolean n() {
        return false;
    }

    public com.qq.e.comm.plugin.va.m.p a(com.qq.e.comm.plugin.va.m.q qVar) {
        return (com.qq.e.comm.plugin.va.m.p) pro.getobjresult(463, 0, this, qVar);
    }

    @Override // com.qq.e.comm.plugin.q0
    protected kc d() {
        return kc.EXO_PLAYER;
    }

    @Override // com.qq.e.comm.plugin.q0
    protected boolean e() throws Throwable {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_HEIGHT, 0, this);
    }

    @Override // com.qq.e.comm.plugin.q0
    protected boolean i() {
        return true;
    }

    public boolean o() {
        if (n()) {
            return true;
        }
        return (c() == null || this.m == null) ? false : true;
    }

    private void m() {
        this.h = this.u.getDir(this.v, 0);
        this.e = "com.qq.e.exop.ExoPlayerView";
        this.d = "exop_test";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.q0
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public com.qq.e.comm.plugin.va.m.p k() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return a(new Object[]{new c()});
    }

    /* compiled from: A */
    private class c implements com.qq.e.comm.plugin.va.m.q {
        @Override // com.qq.e.comm.plugin.va.m.q
        public void onAva() {
        }

        @Override // com.qq.e.comm.plugin.va.m.q
        public void onC() {
        }

        @Override // com.qq.e.comm.plugin.va.m.q
        public void onCha(int i, int i2) {
        }

        @Override // com.qq.e.comm.plugin.va.m.q
        public void onDes() {
        }

        @Override // com.qq.e.comm.plugin.va.m.q
        public void onE(int i, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.va.m.q
        public void onEnd() {
        }

        @Override // com.qq.e.comm.plugin.va.m.q
        public void onP() {
        }

        @Override // com.qq.e.comm.plugin.va.m.q
        public void onPre(int i, int i2) {
        }

        @Override // com.qq.e.comm.plugin.va.m.q
        public void onStar() {
        }

        private c() {
        }
    }

    private com.qq.e.comm.plugin.va.m.p a(Object[] objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        if (this.x == null) {
            this.x = this.m.getConstructor(Object[].class, Object[].class);
        }
        return this.x.newInstance(b(), objArr);
    }

    public void a(Context context) throws JSONException {
        this.u = context;
        this.v = "e_qq_com_onlp";
        super.a(context, "e_qq_com_onlp");
    }

    @Override // com.qq.e.comm.plugin.q0
    protected ClassLoader a(String str, String str2) {
        return new us(this.i.getAbsolutePath(), str2, str, getClass().getClassLoader(), this.w);
    }

    @Override // com.qq.e.comm.plugin.q0
    protected boolean a(File file, boolean z) {
        if (n()) {
            return true;
        }
        return super.a(file, z);
    }
}
