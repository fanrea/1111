package com.bytedance.rpc;

import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RpcException extends RuntimeException implements Serializable {
    private static final List<b> mConverters = new ArrayList();
    private int mCode;
    private long mErrorTime;
    private boolean mHttpProtocolError;
    private int mRequestId;
    private String mSource;
    private Map<Class<?>, Object> mTags;

    public interface b {
        void a(Throwable th, a aVar);
    }

    public static void addConverter(b bVar) {
        mConverters.add(bVar);
    }

    public static boolean removeConverter(b bVar) {
        return mConverters.remove(bVar);
    }

    private RpcException(String str, Throwable th) {
        super(str, th);
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public Object getTag(Class<?> cls) {
        Map<Class<?>, Object> map = this.mTags;
        if (map == null) {
            return null;
        }
        return map.get(cls);
    }

    public int getCode() {
        return this.mCode;
    }

    public long getErrorTime() {
        return this.mErrorTime;
    }

    public String getResource() {
        return this.mSource;
    }

    public boolean isTimeout() {
        int i = this.mCode;
        if (i == 987654324) {
            return true;
        }
        if (i != 987654321) {
            return false;
        }
        Throwable lastCause = getLastCause();
        return lastCause != null && ((lastCause instanceof TimeoutException) || (lastCause instanceof SocketTimeoutException));
    }

    public final Throwable getLastCause() {
        return getFinalCause(getCause());
    }

    public static final Throwable getFinalCause(Throwable th) {
        return com.bytedance.rpc.log.a.a(th);
    }

    public boolean isCanceled() {
        return this.mCode == 987654323;
    }

    public boolean isHttpError() {
        return this.mHttpProtocolError;
    }

    public boolean isIgnored() {
        return this.mCode == 987654322;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RpcException{code=" + this.mCode + ", reason=" + getMessage() + ", httpProtocolError=" + this.mHttpProtocolError + ", requestId=" + this.mRequestId + ", errorTime=" + this.mErrorTime + ", source='" + this.mSource + "', cause=" + getLastCause() + ", tags=" + this.mTags + '}';
    }

    public a toBuilder() {
        return new a();
    }

    public static a from(Throwable th) {
        return new a(th);
    }

    public static a fromHttp(int i, String str) {
        return new a(i, str, true);
    }

    public static a fromNew(int i, String str) {
        return new a(i, str, false);
    }

    public static RpcException ignore(String str, int i) {
        return fromNew(987654322, str).a(i).a();
    }

    public static class a {
        private boolean a;
        private int b;
        private String c;
        private int d;
        private Throwable e;
        private long f;
        private String g;
        private Map<Class<?>, Object> h;

        private a b() {
            return this;
        }

        private a(RpcException rpcException) {
            this((Throwable) rpcException);
        }

        private a(Throwable th) {
            this.e = th;
            this.b = 987654321;
            if (th instanceof RpcException) {
                RpcException rpcException = (RpcException) th;
                this.a = rpcException.mHttpProtocolError;
                this.b = rpcException.mCode;
                this.c = rpcException.getMessage();
                this.d = rpcException.mRequestId;
                this.e = rpcException.getCause();
                this.f = rpcException.mErrorTime;
                this.h = rpcException.mTags;
                this.g = rpcException.mSource;
                return;
            }
            this.h = new HashMap(2);
            Iterator it = RpcException.mConverters.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(th, this);
            }
        }

        private a(int i, String str, boolean z) {
            this.b = i;
            this.c = str;
            this.a = z;
            this.h = new HashMap(2);
        }

        public a a(Class<?> cls, Object obj) {
            this.h.put(cls, obj);
            return b();
        }

        public a a(String str) {
            this.g = str;
            return b();
        }

        public a a(int i) {
            this.d = i;
            return b();
        }

        public a b(int i) {
            this.b = i;
            return b();
        }

        public a a(int i, String str) {
            this.b = i;
            this.c = str;
            return b();
        }

        public RpcException a() {
            String message;
            if (com.bytedance.sdk.djx.proguard3.c.d.c(this.c)) {
                Throwable th = this.e;
                message = th == null ? "" : th.getMessage();
            } else {
                message = this.c;
            }
            RpcException rpcException = new RpcException(message, this.e);
            rpcException.mCode = this.b;
            rpcException.mRequestId = this.d;
            rpcException.mHttpProtocolError = this.a;
            if (rpcException.mErrorTime = this.f == 0) {
                rpcException.mErrorTime = System.currentTimeMillis();
            }
            rpcException.mTags = this.h;
            rpcException.mSource = this.g;
            return rpcException;
        }

        public RpcException a(RpcException rpcException) {
            if (rpcException != null) {
                rpcException.mCode = this.b;
                rpcException.mRequestId = this.d;
                rpcException.mTags = this.h;
                rpcException.mSource = this.g;
                return rpcException;
            }
            return a();
        }
    }
}
