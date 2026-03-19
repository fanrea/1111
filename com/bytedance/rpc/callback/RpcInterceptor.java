package com.bytedance.rpc.callback;

import com.bytedance.rpc.RpcException;
import com.bytedance.rpc.RpcRequestModifier;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface RpcInterceptor {
    void exceptionHandle(Class cls, Method method, RpcException rpcException, String str);

    boolean postHandle(Class cls, Method method, Object obj, ThreadLocal threadLocal, Map<String, String> map, String str) throws Exception;

    boolean preHandle(Class cls, Method method, Object[] objArr, RpcRequestModifier rpcRequestModifier, String str) throws Exception;
}
