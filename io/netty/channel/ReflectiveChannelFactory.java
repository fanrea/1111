package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.util.internal.StringUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ReflectiveChannelFactory<T extends Channel> implements ChannelFactory<T> {
    private final Class<? extends T> clazz;

    public ReflectiveChannelFactory(Class<? extends T> cls) {
        if (cls == null) {
            throw new NullPointerException("clazz");
        }
        this.clazz = cls;
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public T newChannel() {
        try {
            return this.clazz.newInstance();
        } catch (Throwable th) {
            throw new ChannelException("Unable to create Channel from class " + this.clazz, th);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) this.clazz) + ".class";
    }
}
