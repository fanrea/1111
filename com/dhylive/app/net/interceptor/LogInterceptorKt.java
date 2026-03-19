package com.dhylive.app.net.interceptor;

import androidx.core.location.LocationRequestCompat;
import com.blankj.utilcode.util.GsonUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* compiled from: LogInterceptor.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"dotHeaders", "", "request", "Lokhttp3/Request;", "parseParams", "printResult", "response", "Lokhttp3/Response;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class LogInterceptorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String dotHeaders(Request request) {
        HashMap map = new HashMap();
        Headers headers = request.headers();
        Iterator<Pair<? extends String, ? extends String>> it = headers.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            it.next();
            if (!Intrinsics.areEqual(headers.name(i), "Accept")) {
                HashMap map2 = map;
                String strName = headers.name(i);
                String strValue = headers.value(i);
                if (strValue.length() == 0) {
                    strValue = "";
                }
                map2.put(strName, strValue);
            }
            i = i2;
        }
        String json = GsonUtils.toJson(map);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parseParams(Request request) {
        try {
            RequestBody requestBodyBody = request.newBuilder().build().body();
            if (requestBodyBody == null) {
                return "";
            }
            Buffer buffer = new Buffer();
            requestBodyBody.writeTo(buffer);
            Charset charsetForName = Charset.forName("UTF-8");
            MediaType contentType = requestBodyBody.getContentType();
            if (contentType != null) {
                charsetForName = contentType.charset(charsetForName);
            }
            Intrinsics.checkNotNull(charsetForName);
            return buffer.readString(charsetForName);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String printResult(Response response) {
        try {
            ResponseBody responseBodyBody = response.newBuilder().build().body();
            if (responseBodyBody == null) {
                return "";
            }
            BufferedSource source = responseBodyBody.getSource();
            source.request(LocationRequestCompat.PASSIVE_INTERVAL);
            Buffer bufferClone = source.getBuffer().clone();
            Charset charsetForName = Charset.forName("UTF-8");
            MediaType mediaType = responseBodyBody.get$contentType();
            if (mediaType != null) {
                charsetForName = mediaType.charset(charsetForName);
            }
            Intrinsics.checkNotNull(charsetForName);
            return bufferClone.readString(charsetForName);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }
    }
}
