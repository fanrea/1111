package com.kuaishou.common.netty.client.handler;

import com.google.protobuf.nano.MessageNano;
import com.kuaishou.common.netty.handler.NanoPayloadHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ClientNanoPayloadHandlers {
    private Map<Integer, NanoPayloadHandler<MessageNano>> handlers = new HashMap();

    public <T extends MessageNano> void addHandler(int i, NanoPayloadHandler<T> nanoPayloadHandler) {
        this.handlers.put(Integer.valueOf(i), nanoPayloadHandler);
    }

    public void clearHandlers() {
        this.handlers.clear();
    }

    public NanoPayloadHandler<MessageNano> getHandler(Integer num) {
        if (num == null) {
            return null;
        }
        return this.handlers.get(num);
    }
}
