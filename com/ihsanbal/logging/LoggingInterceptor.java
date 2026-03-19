package com.ihsanbal.logging;

import com.alipay.sdk.m.p0.b;
import com.baidu.mobads.container.components.j.a;
import com.baidu.mobads.sdk.internal.bu;
import com.ihsanbal.logging.Printer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: LoggingInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ihsanbal/logging/LoggingInterceptor;", "Lokhttp3/Interceptor;", "builder", "Lcom/ihsanbal/logging/LoggingInterceptor$Builder;", "(Lcom/ihsanbal/logging/LoggingInterceptor$Builder;)V", "addQueryAndHeaders", "Lokhttp3/Request;", "request", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "printlnRequestLog", "", "printlnResponseLog", "receivedMs", "", "response", "proceedResponse", "Builder", "lib"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class LoggingInterceptor implements Interceptor {
    private final Builder builder;

    private LoggingInterceptor(Builder builder) {
        this.builder = builder;
    }

    public /* synthetic */ LoggingInterceptor(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Request requestAddQueryAndHeaders = addQueryAndHeaders(chain.request());
        if (this.builder.getLevel() == Level.NONE) {
            return chain.proceed(requestAddQueryAndHeaders);
        }
        printlnRequestLog(requestAddQueryAndHeaders);
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceedResponse = proceedResponse(chain, requestAddQueryAndHeaders);
            printlnResponseLog(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime), responseProceedResponse, requestAddQueryAndHeaders);
            return responseProceedResponse;
        } catch (Exception e) {
            Printer.INSTANCE.printFailed(this.builder.getTag(false), this.builder);
            throw e;
        }
    }

    private final void printlnResponseLog(long receivedMs, Response response, Request request) {
        Printer.INSTANCE.printJsonResponse(this.builder, receivedMs, response.isSuccessful(), response.code(), response.headers(), response, request.url().encodedPathSegments(), response.message(), request.url().getUrl());
    }

    private final void printlnRequestLog(Request request) {
        Printer.Companion companion = Printer.INSTANCE;
        Builder builder = this.builder;
        RequestBody requestBodyBody = request.body();
        String string = request.url().url().toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "request.url.toUrl().toString()");
        companion.printJsonRequest(builder, requestBodyBody, string, request.headers(), request.method());
    }

    private final Response proceedResponse(Interceptor.Chain chain, Request request) throws InterruptedException, IOException {
        if (this.builder.getIsMockEnabled() && this.builder.getListener() != null) {
            TimeUnit.MILLISECONDS.sleep(this.builder.getSleepMs());
            Response.Builder builder = new Response.Builder();
            BufferListener listener = this.builder.getListener();
            if (listener == null) {
                Intrinsics.throwNpe();
            }
            String jsonResponse = listener.getJsonResponse(request);
            return builder.body(jsonResponse != null ? ResponseBody.INSTANCE.create(jsonResponse, MediaType.INSTANCE.parse("application/json")) : null).request(chain.request()).protocol(Protocol.HTTP_2).message("Mock data from LoggingInterceptor").code(200).build();
        }
        return chain.proceed(request);
    }

    private final Request addQueryAndHeaders(Request request) {
        Request.Builder builderNewBuilder = request.newBuilder();
        Set<String> setKeySet = this.builder.getHeaders().keySet();
        Intrinsics.checkExpressionValueIsNotNull(setKeySet, "builder.headers.keys");
        for (String str : setKeySet) {
            String str2 = this.builder.getHeaders().get(str);
            if (str2 != null) {
                Intrinsics.checkExpressionValueIsNotNull(str, "key");
                Intrinsics.checkExpressionValueIsNotNull(str2, "it");
                builderNewBuilder.addHeader(str, str2);
            }
        }
        HttpUrl.Builder builderNewBuilder2 = request.url().newBuilder(request.url().getUrl());
        if (builderNewBuilder2 != null) {
            Set<String> setKeySet2 = this.builder.getHttpUrl().keySet();
            Intrinsics.checkExpressionValueIsNotNull(setKeySet2, "builder.httpUrl.keys");
            for (String str3 : setKeySet2) {
                Intrinsics.checkExpressionValueIsNotNull(str3, "key");
                builderNewBuilder2.addQueryParameter(str3, this.builder.getHttpUrl().get(str3));
            }
        }
        HttpUrl httpUrlBuild = builderNewBuilder2 != null ? builderNewBuilder2.build() : null;
        if (httpUrlBuild == null) {
            Intrinsics.throwNpe();
        }
        return builderNewBuilder.url(httpUrlBuild).build();
    }

    /* compiled from: LoggingInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 C2\u00020\u0001:\u0001CB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005J\u0016\u00100\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005J\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u000bH\u0007J \u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020$2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0012\u00108\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u000109H\u0007J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000bJ\u000e\u0010<\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)J\u0010\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u000bH\u0007J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010?\u001a\u00020\u00002\b\u0010@\u001a\u0004\u0018\u00010\u0005J\u0010\u0010A\u001a\u00020\u00002\b\u0010@\u001a\u0004\u0018\u00010\u0005J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0005R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010*\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006D"}, d2 = {"Lcom/ihsanbal/logging/LoggingInterceptor$Builder;", "", "()V", "headers", "Ljava/util/HashMap;", "", "getHeaders", "()Ljava/util/HashMap;", "httpUrl", "getHttpUrl", "isDebugAble", "", "()Z", "setDebugAble", "(Z)V", "<set-?>", "isLogHackEnable", "isMockEnabled", "setMockEnabled", "Lcom/ihsanbal/logging/Level;", "level", "getLevel", "()Lcom/ihsanbal/logging/Level;", "listener", "Lcom/ihsanbal/logging/BufferListener;", "getListener", "()Lcom/ihsanbal/logging/BufferListener;", "setListener", "(Lcom/ihsanbal/logging/BufferListener;)V", "Lcom/ihsanbal/logging/Logger;", bu.a, "getLogger", "()Lcom/ihsanbal/logging/Logger;", "requestTag", "responseTag", "sleepMs", "", "getSleepMs", "()J", "setSleepMs", "(J)V", "", "type", "getType", "()I", "addHeader", "name", b.d, "addQueryParam", "build", "Lcom/ihsanbal/logging/LoggingInterceptor;", "enableAndroidStudioV3LogsHack", "useHack", "enableMock", "useMock", "sleep", "executor", "Ljava/util/concurrent/Executor;", "getTag", "isRequest", a.b, "loggable", "isDebug", "request", "tag", "response", "setLevel", "Companion", "lib"}, k = 1, mv = {1, 1, 16})
    public static final class Builder {
        private static String TAG = "LoggingI";
        private boolean isDebugAble;
        private boolean isLogHackEnable;
        private boolean isMockEnabled;
        private BufferListener listener;
        private Logger logger;
        private String requestTag;
        private String responseTag;
        private long sleepMs;
        private final HashMap<String, String> headers = new HashMap<>();
        private final HashMap<String, String> httpUrl = new HashMap<>();
        private int type = 4;
        private Level level = Level.BASIC;

        public final HashMap<String, String> getHeaders() {
            return this.headers;
        }

        public final HashMap<String, String> getHttpUrl() {
            return this.httpUrl;
        }

        /* renamed from: isLogHackEnable, reason: from getter */
        public final boolean getIsLogHackEnable() {
            return this.isLogHackEnable;
        }

        /* renamed from: isDebugAble, reason: from getter */
        public final boolean getIsDebugAble() {
            return this.isDebugAble;
        }

        public final void setDebugAble(boolean z) {
            this.isDebugAble = z;
        }

        public final int getType() {
            return this.type;
        }

        public final Level getLevel() {
            return this.level;
        }

        public final Logger getLogger() {
            return this.logger;
        }

        /* renamed from: isMockEnabled, reason: from getter */
        public final boolean getIsMockEnabled() {
            return this.isMockEnabled;
        }

        public final void setMockEnabled(boolean z) {
            this.isMockEnabled = z;
        }

        public final long getSleepMs() {
            return this.sleepMs;
        }

        public final void setSleepMs(long j) {
            this.sleepMs = j;
        }

        public final BufferListener getListener() {
            return this.listener;
        }

        public final void setListener(BufferListener bufferListener) {
            this.listener = bufferListener;
        }

        public final Builder setLevel(Level level) {
            Intrinsics.checkParameterIsNotNull(level, "level");
            this.level = level;
            return this;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final String getTag(boolean isRequest) throws NoWhenBranchMatchedException {
            if (isRequest) {
                String str = this.requestTag;
                if (str == null || str.length() == 0) {
                    return TAG;
                }
                String str2 = this.requestTag;
                if (str2 != null) {
                    return str2;
                }
                Intrinsics.throwNpe();
                return str2;
            }
            if (isRequest) {
                throw new NoWhenBranchMatchedException();
            }
            String str3 = this.responseTag;
            if (str3 == null || str3.length() == 0) {
                return TAG;
            }
            String str4 = this.responseTag;
            if (str4 != null) {
                return str4;
            }
            Intrinsics.throwNpe();
            return str4;
        }

        public final Builder addHeader(String name, String value) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(value, b.d);
            this.headers.put(name, value);
            return this;
        }

        public final Builder addQueryParam(String name, String value) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(value, b.d);
            this.httpUrl.put(name, value);
            return this;
        }

        public final Builder tag(String tag) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            TAG = tag;
            return this;
        }

        public final Builder request(String tag) {
            this.requestTag = tag;
            return this;
        }

        public final Builder response(String tag) {
            this.responseTag = tag;
            return this;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Set level based on your requirement", replaceWith = @ReplaceWith(expression = "setLevel(Level.Basic)", imports = {}))
        public final Builder loggable(boolean isDebug) {
            this.isDebugAble = isDebug;
            return this;
        }

        public final Builder log(int type) {
            this.type = type;
            return this;
        }

        public final Builder logger(Logger logger) {
            this.logger = logger;
            return this;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Create your own Logcat filter for best result")
        public final Builder executor(Executor executor) throws Throwable {
            throw new NotImplementedError("An operation is not implemented: Deprecated");
        }

        public final Builder enableMock(boolean useMock, long sleep, BufferListener listener) {
            this.isMockEnabled = useMock;
            this.sleepMs = sleep;
            this.listener = listener;
            return this;
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Android studio has resolved problem for latest versions")
        public final Builder enableAndroidStudioV3LogsHack(boolean useHack) {
            this.isLogHackEnable = useHack;
            return this;
        }

        public final LoggingInterceptor build() {
            return new LoggingInterceptor(this, null);
        }
    }
}
