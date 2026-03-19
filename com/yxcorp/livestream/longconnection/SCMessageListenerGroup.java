package com.yxcorp.livestream.longconnection;

import com.google.protobuf.nano.MessageNano;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCMessageListenerGroup<T extends MessageNano> {
    public final Class<T> mClazz;
    private List<SCMessageListener<T>> mListeners = new ArrayList();

    public SCMessageListenerGroup(Class<T> cls) {
        this.mClazz = cls;
    }

    public final void onMessageReceived(T t) {
        Iterator<SCMessageListener<T>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onMessageReceived(t);
        }
    }

    public final void add(SCMessageListener<T> sCMessageListener) {
        this.mListeners.add(sCMessageListener);
    }

    public final void remove(SCMessageListener<T> sCMessageListener) {
        this.mListeners.remove(sCMessageListener);
    }
}
