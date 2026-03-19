package com.yxcorp.livestream.longconnection.handler;

import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.LiveInfoListener;
import com.yxcorp.livestream.longconnection.LongConnectionContext;
import com.yxcorp.livestream.longconnection.exception.ServerInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SCInfoHandler extends SCHandler<SocketMessages.SCInfo> {
    public SCInfoHandler(LongConnectionContext longConnectionContext) {
        super(longConnectionContext);
    }

    @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
    public void handleMessage(final SocketMessages.SCInfo sCInfo) {
        this.mLongConnectionContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.handler.SCInfoHandler.1
            @Override // java.lang.Runnable
            public void run() {
                LiveInfoListener infoListener = SCInfoHandler.this.mLongConnectionContext.getInfoListener();
                if (infoListener != null) {
                    infoListener.onServerInfo(new ServerInfo(sCInfo.code, sCInfo.msg));
                }
            }
        });
    }
}
