package com.bytedance.idl.api;

import android.app.Application;
import com.bytedance.idl.api.serialize.FormSerializeFactory;
import com.bytedance.idl.api.serialize.JsonSerializeFactory;
import com.bytedance.idl.api.service.INetClient;
import com.bytedance.idl.api.service.IRpcService;
import com.bytedance.rpc.RpcConfig;
import com.bytedance.rpc.a;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.k;
import com.bytedance.rpc.log.LogLevel;
import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.rpc.serialize.f;
import com.bytedance.sdk.djx.proguard3.a.b;
import com.bytedance.sdk.djx.proguard3.a.d;
import com.bytedance.sdk.djx.proguard3.d.c;
import com.bytedance.sdk.djx.proguard3.d.j;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RpcServiceProxy implements IRpcService {
    private static final String DEFAULT_BASE_URL = "https://csj-sp.csjdeveloper.com";
    private static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    private static volatile RpcServiceProxy sInstance;
    private d globalLogCallback;
    private INetClient globalNetClient;
    private final ConcurrentHashMap<Class<?>, INetClient> mNetClientMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class<?>, d> mLogCallbackMap = new ConcurrentHashMap<>();
    private boolean isDebug = false;

    private RpcServiceProxy() {
    }

    public static RpcServiceProxy getInstance() {
        if (sInstance == null) {
            synchronized (RpcServiceProxy.class) {
                if (sInstance == null) {
                    sInstance = new RpcServiceProxy();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void init(Application application, boolean z) {
        AtomicBoolean atomicBoolean = sHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        this.isDebug = z;
        k.a(application, getInstance().createRpcConfigBuilder().a("https://csj-sp.csjdeveloper.com").a(false).a(new RpcConfig[0]));
        registerSerializeFactory(new FormSerializeFactory());
        registerSerializeFactory(new JsonSerializeFactory());
        setTransportFactory(new b());
        if (z) {
            getInstance().setLogLevel(LogLevel.DEBUG);
        } else {
            getInstance().setLogLevel(LogLevel.WARN);
        }
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public boolean isInitialized() {
        return k.a();
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public <T> T getProxy(Class<T> cls) {
        return (T) k.a((Class) cls);
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void setLogLevel(LogLevel logLevel) {
        k.a(logLevel);
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public RpcConfig.a createRpcConfigBuilder() {
        return k.c();
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void registerSerializeFactory(f fVar) {
        k.a(fVar);
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void removeSerializeFactory(SerializeType serializeType) {
        k.a(serializeType);
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void setTransportFactory(c cVar) {
        k.a(cVar);
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void addRpcInterceptor(RpcInterceptor rpcInterceptor, Class<?>... clsArr) {
        k.a(rpcInterceptor, clsArr);
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void addNetClient(INetClient iNetClient, Class<?>... clsArr) {
        if (iNetClient != null) {
            if (clsArr == null || clsArr.length == 0) {
                this.globalNetClient = iNetClient;
                return;
            }
            for (Class<?> cls : clsArr) {
                if (cls != null) {
                    this.mNetClientMap.put(cls, iNetClient);
                }
            }
        }
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void removeRpcInterceptor(RpcInterceptor rpcInterceptor, Class<?> cls) {
        k.b(rpcInterceptor, cls);
    }

    public INetClient getNetClient(Class<?> cls) {
        if (this.mNetClientMap.containsKey(cls)) {
            return this.mNetClientMap.get(cls);
        }
        INetClient iNetClient = this.globalNetClient;
        if (iNetClient != null) {
            return iNetClient;
        }
        if (this.isDebug || this.mNetClientMap.isEmpty()) {
            throw new RuntimeException("NetClient should not be null ");
        }
        return this.mNetClientMap.values().iterator().next();
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public com.bytedance.rpc.f getRpcInvokeContext(Object obj) {
        return k.a(obj);
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public a getRpcRequestModify() {
        return k.d();
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void addLogCallback(d dVar, Class<?>... clsArr) {
        if (dVar != null) {
            if (clsArr == null || clsArr.length == 0) {
                this.globalLogCallback = dVar;
                return;
            }
            for (Class<?> cls : clsArr) {
                if (cls != null) {
                    this.mLogCallbackMap.put(cls, dVar);
                }
            }
        }
    }

    public d getLogCallback(Class<?> cls) {
        if (this.mLogCallbackMap.containsKey(cls)) {
            return this.mLogCallbackMap.get(cls);
        }
        d dVar = this.globalLogCallback;
        if (dVar != null) {
            return dVar;
        }
        return null;
    }

    @Override // com.bytedance.idl.api.service.IRpcService
    public void addTransportResultInterceptor(j jVar) {
        k.a(jVar);
    }
}
