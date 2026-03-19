package com.yxcorp.livestream.longconnection;

import com.yxcorp.livestream.longconnection.exception.ChannelException;
import com.yxcorp.livestream.longconnection.exception.ClientException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface OnConnectionExceptionListener {
    void onChannelException(ChannelException channelException);

    void onClientException(ClientException clientException);

    void onServerException(LiveLongConnectionServerException liveLongConnectionServerException);
}
