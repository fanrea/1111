package com.alliance.ssp.ad.p0;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.video.e;

/* compiled from: VideoDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends Handler {
    public final /* synthetic */ e a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, Looper looper) {
        super(looper);
        this.a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            e eVar = this.a;
            if (eVar.e == null) {
                int i = l.a;
                return;
            }
            MediaPlayer mediaPlayer = eVar.b;
            if (mediaPlayer == null) {
                int i2 = l.a;
                return;
            }
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                this.a.d.sendEmptyMessageDelayed(0, 1000L);
                return;
            }
            int duration = (int) ((this.a.b.getDuration() - this.a.b.getCurrentPosition()) * 0.001d);
            int i3 = l.a;
            if (duration <= 0) {
                this.a.e.setText("00:00");
                this.a.d.sendEmptyMessageDelayed(0, 1000L);
                return;
            }
            int i4 = duration / 60;
            int i5 = duration % 60;
            this.a.e.setText((i4 < 10 ? new StringBuilder().append("0") : new StringBuilder().append("")).append(i4).toString() + ":" + (i5 < 10 ? new StringBuilder().append("0") : new StringBuilder().append("")).append(i5).toString());
            this.a.d.sendEmptyMessageDelayed(0, 1000L);
        } catch (Exception e) {
            e.getMessage();
            int i6 = l.a;
        }
    }
}
