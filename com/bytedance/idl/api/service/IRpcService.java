package com.bytedance.idl.api.service;

import android.app.Application;
import com.bytedance.rpc.RpcConfig;
import com.bytedance.rpc.a;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.f;
import com.bytedance.rpc.log.LogLevel;
import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.sdk.djx.proguard3.a.d;
import com.bytedance.sdk.djx.proguard3.d.c;
import com.bytedance.sdk.djx.proguard3.d.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IRpcService {
    void addLogCallback(d dVar, Class<?>... clsArr);

    void addNetClient(INetClient iNetClient, Class<?>... clsArr);

    void addRpcInterceptor(RpcInterceptor rpcInterceptor, Class<?>... clsArr);

    void addTransportResultInterceptor(j jVar);

    RpcConfig.a createRpcConfigBuilder();

    <T> T getProxy(Class<T> cls);

    f getRpcInvokeContext(Object obj);

    a getRpcRequestModify();

    void init(Application application, boolean z);

    boolean isInitialized();

    void registerSerializeFactory(com.bytedance.rpc.serialize.f fVar);

    void removeRpcInterceptor(RpcInterceptor rpcInterceptor, Class<?> cls);

    void removeSerializeFactory(SerializeType serializeType);

    void setLogLevel(LogLevel logLevel);

    void setTransportFactory(c cVar);
}
