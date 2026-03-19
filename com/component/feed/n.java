package com.component.feed;

import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements Handler.Callback {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case -2:
                bq.a().a(m.a, "handleMessage: 视频失去焦点");
                this.a.d(m.W);
                break;
            case -1:
            default:
                bq.a().a(m.a, "handleMessage: 区域不对");
                this.a.d(m.V);
                break;
            case 0:
                bq.a().a(m.a, "handleMessage:屏幕上不可见");
                this.a.d(m.U);
                break;
            case 1:
                bq.a().a(m.a, "handleMessage: 广告处于播放区域");
                k.a().a(this.a, m.ac);
                break;
            case 2:
                bq.a().a(m.a, "handleMessage: 内容处于播放区域");
                k.a().a(this.a, m.ad);
                break;
        }
        return false;
    }
}
