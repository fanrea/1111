package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.dj;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ki extends dd {
    @Override // com.qq.e.comm.plugin.dd
    protected dj a(Context context, ed edVar, VideoOption videoOption, dj.a aVar, f5 f5Var) {
        return new li(context, edVar, videoOption, new a(aVar), f5Var);
    }

    public ki(Context context, ed edVar) {
        super(context, edVar);
    }

    /* compiled from: A */
    class a implements dj.a {
        final /* synthetic */ dj.a a;

        a(dj.a aVar) {
            this.a = aVar;
        }

        @Override // com.qq.e.comm.plugin.dj.a
        public void a(int i) {
            dj.a aVar = this.a;
            if (aVar != null) {
                aVar.a(i);
            }
        }

        @Override // com.qq.e.comm.plugin.dj.a
        public void a(ik ikVar) {
            dj.a aVar = this.a;
            if (aVar != null) {
                aVar.a(ikVar);
            }
        }
    }

    /* compiled from: A */
    class b implements ADListener {
        final /* synthetic */ ADListener a;

        b(ADListener aDListener) {
            this.a = aDListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            ADListener aDListener = this.a;
            if (aDListener != null) {
                aDListener.onADEvent(aDEvent);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.dd, com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(ADListener aDListener) {
        super.setAdListener(new b(aDListener));
    }
}
