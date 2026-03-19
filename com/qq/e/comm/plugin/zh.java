package com.qq.e.comm.plugin;

import com.ss.ttm.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class zh implements oj {
    private boolean a = false;

    private void a(l6 l6Var, int i) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_ERR_NO_VIDEO, 0, this, l6Var, Integer.valueOf(i));
    }

    private String b(l6 l6Var) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RATE, 0, this, l6Var);
    }

    private void b(l6 l6Var, qs qsVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_NETWORK_CONNECT_COUNT, 0, this, l6Var, qsVar);
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var) {
        return pro.getZresult(470, 0, this, l6Var);
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var, qs qsVar) {
        return pro.getZresult(471, 0, this, l6Var, qsVar);
    }

    zh() {
    }
}
