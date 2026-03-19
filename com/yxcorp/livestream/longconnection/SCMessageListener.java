package com.yxcorp.livestream.longconnection;

import com.google.protobuf.nano.MessageNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface SCMessageListener<T extends MessageNano> {
    void onMessageReceived(T t);
}
