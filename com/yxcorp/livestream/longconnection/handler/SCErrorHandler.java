package com.yxcorp.livestream.longconnection.handler;

import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.LiveLongConnectionServerException;
import com.yxcorp.livestream.longconnection.LongConnectionContext;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SCErrorHandler extends SCHandler<SocketMessages.SCError> {
    public static boolean isAuthError(int i) {
        return i == 60;
    }

    public static boolean isLiveEndError(int i) {
        if (i == 607) {
            return true;
        }
        switch (i) {
            case 601:
            case 602:
            case 603:
                return true;
            default:
                return false;
        }
    }

    public SCErrorHandler(LongConnectionContext longConnectionContext) {
        super(longConnectionContext);
    }

    @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
    public void handleMessage(final SocketMessages.SCError sCError) {
        this.mLongConnectionContext.setLastErrorCode(sCError.code);
        this.mLongConnectionContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.handler.SCErrorHandler.1
            @Override // java.lang.Runnable
            public void run() {
                OnConnectionExceptionListener exceptionListener = SCErrorHandler.this.mLongConnectionContext.getExceptionListener();
                if (exceptionListener != null) {
                    exceptionListener.onServerException(new LiveLongConnectionServerException(sCError.code, sCError.subCode, sCError.msg, sCError.minDelayMs, sCError.maxDelayMs));
                }
            }
        });
    }
}
