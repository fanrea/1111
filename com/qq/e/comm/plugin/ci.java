package com.qq.e.comm.plugin;

import android.util.Pair;
import com.ss.ttm.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ci implements oj, rs {
    private l6 a;
    private JSONArray b;

    private Pair<String, String> a(int i, h4 h4Var) {
        return (Pair) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SWITCH_ACTION, 0, this, Integer.valueOf(i), h4Var);
    }

    static /* synthetic */ l6 a(ci ciVar) {
        return (l6) pro.getobjresult(546, 1, ciVar);
    }

    private void a(int i) {
        pro.getVresult(547, 0, this, Integer.valueOf(i));
    }

    private void a(int i, int i2) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CLOSE_IO_IMMEDIATELY, 0, this, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private boolean a(h4 h4Var, String str) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_CLOSE_IO_COST, 0, this, h4Var, str);
    }

    private boolean a(String str) {
        return pro.getZresult(550, 0, this, str);
    }

    private boolean b() {
        return pro.getZresult(551, 0, this);
    }

    private void c(boolean z) {
        pro.getVresult(552, 0, this, Boolean.valueOf(z));
    }

    @Override // com.qq.e.comm.plugin.rs
    public void a(boolean z) {
        pro.getVresult(553, 0, this, Boolean.valueOf(z));
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var) {
        return pro.getZresult(554, 0, this, l6Var);
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var, qs qsVar) {
        return pro.getZresult(555, 0, this, l6Var, qsVar);
    }

    @Override // com.qq.e.comm.plugin.rs
    public boolean a(JSONObject jSONObject) {
        return pro.getZresult(556, 0, this, jSONObject);
    }

    @Override // com.qq.e.comm.plugin.rs
    public void b(boolean z) {
        pro.getVresult(557, 0, this, Boolean.valueOf(z));
    }

    @Override // com.qq.e.comm.plugin.rs
    public void onCancel() {
        pro.getVresult(558, 0, this);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = ci.a(ci.this).a().b;
            int iA = yw.a(ci.a(ci.this).B);
            h.b(str, iA);
            if (this.a) {
                h.a(str, iA);
            }
        }
    }
}
