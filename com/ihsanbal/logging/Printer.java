package com.ihsanbal.logging;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.sdk.internal.bu;
import com.component.a.a.b;
import com.ihsanbal.logging.I;
import com.ihsanbal.logging.LoggingInterceptor;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Printer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/ihsanbal/logging/Printer;", "", "()V", "Companion", "lib"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class Printer {
    private static final String BODY_TAG = "Body:";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_LINE = "│ ";
    private static final String DOUBLE_SEPARATOR;
    private static final String END_LINE = "└───────────────────────────────────────────────────────────────────────────────────────";
    private static final String HEADERS_TAG = "Headers:";
    private static final int JSON_INDENT = 3;
    private static final String LINE_SEPARATOR;
    private static final String METHOD_TAG = "Method: @";
    private static final String N = "\n";
    private static final String OOM_OMITTED;
    private static final String RECEIVED_TAG = "Received in: ";
    private static final String REQUEST_UP_LINE = "┌────── Request ────────────────────────────────────────────────────────────────────────";
    private static final String RESPONSE_UP_LINE = "┌────── Response ───────────────────────────────────────────────────────────────────────";
    private static final String STATUS_CODE_TAG = "Status Code: ";
    private static final String T = "\t";
    private static final String URL_TAG = "URL: ";

    /* compiled from: Printer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J+\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010%JQ\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040,2\u0006\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0004H\u0002JE\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00042\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040!2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u0002052\u0006\u00107\u001a\u00020\u00042\u0006\u0010?\u001a\u00020@J0\u0010A\u001a\u0002052\u0006\u0010?\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u00010\u001c2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0004JT\u0010E\u001a\u0002052\u0006\u0010?\u001a\u00020@2\u0006\u0010F\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u0002012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040,2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0004J\u0016\u0010H\u001a\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/ihsanbal/logging/Printer$Companion;", "", "()V", "BODY_TAG", "", "DEFAULT_LINE", "DOUBLE_SEPARATOR", "END_LINE", "HEADERS_TAG", "JSON_INDENT", "", "LINE_SEPARATOR", "kotlin.jvm.PlatformType", "METHOD_TAG", "N", "OOM_OMITTED", "RECEIVED_TAG", "REQUEST_UP_LINE", "RESPONSE_UP_LINE", "STATUS_CODE_TAG", ExifInterface.GPS_DIRECTION_TRUE, "URL_TAG", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "bodyToString", "requestBody", "Lokhttp3/RequestBody;", "dotHeaders", "getJsonString", "msg", "getRequest", "", "level", "Lcom/ihsanbal/logging/Level;", e.s, "(Lcom/ihsanbal/logging/Level;Lokhttp3/Headers;Ljava/lang/String;)[Ljava/lang/String;", "getResponse", "tookMs", "", "code", "isSuccessful", "segments", "", cm.V, "(Lokhttp3/Headers;JIZLcom/ihsanbal/logging/Level;Ljava/util/List;Ljava/lang/String;)[Ljava/lang/String;", "getResponseBody", "response", "Lokhttp3/Response;", "isEmpty", "line", "logLines", "", "type", "tag", b.e.k, bu.a, "Lcom/ihsanbal/logging/Logger;", "withLineSize", "useLogHack", "(ILjava/lang/String;[Ljava/lang/String;Lcom/ihsanbal/logging/Logger;ZZ)V", "printFailed", "builder", "Lcom/ihsanbal/logging/LoggingInterceptor$Builder;", "printJsonRequest", "body", "url", "header", "printJsonResponse", "chainMs", "responseUrl", "slashSegments", "lib"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isEmpty(String line) {
            String str = line;
            if (!(str.length() == 0) && !Intrinsics.areEqual("\n", line) && !Intrinsics.areEqual(Printer.T, line)) {
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = str.charAt(!z ? i : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                if (!(str.subSequence(i, length + 1).toString().length() == 0)) {
                    return false;
                }
            }
            return true;
        }

        public final void printJsonRequest(LoggingInterceptor.Builder builder, RequestBody body, String url, Headers header, String method) {
            String str;
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(header, "header");
            Intrinsics.checkParameterIsNotNull(method, e.s);
            if (body == null || (str = Printer.LINE_SEPARATOR + Printer.BODY_TAG + Printer.LINE_SEPARATOR + Printer.INSTANCE.bodyToString(body, header)) == null) {
                str = "";
            }
            String str2 = str;
            String tag = builder.getTag(true);
            if (builder.getLogger() == null) {
                I.INSTANCE.log(builder.getType(), tag, Printer.REQUEST_UP_LINE, builder.getIsLogHackEnable());
            }
            logLines(builder.getType(), tag, new String[]{Printer.URL_TAG + url}, builder.getLogger(), false, builder.getIsLogHackEnable());
            logLines(builder.getType(), tag, getRequest(builder.getLevel(), header, method), builder.getLogger(), true, builder.getIsLogHackEnable());
            if (builder.getLevel() == Level.BASIC || builder.getLevel() == Level.BODY) {
                int type = builder.getType();
                String str3 = Printer.LINE_SEPARATOR;
                Intrinsics.checkExpressionValueIsNotNull(str3, "LINE_SEPARATOR");
                Object[] array = StringsKt.split$default((CharSequence) str2, new String[]{str3}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    logLines(type, tag, (String[]) array, builder.getLogger(), true, builder.getIsLogHackEnable());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            if (builder.getLogger() == null) {
                I.INSTANCE.log(builder.getType(), tag, Printer.END_LINE, builder.getIsLogHackEnable());
            }
        }

        public final void printJsonResponse(LoggingInterceptor.Builder builder, long chainMs, boolean isSuccessful, int code, Headers headers, Response response, List<String> segments, String message, String responseUrl) {
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            Intrinsics.checkParameterIsNotNull(headers, "headers");
            Intrinsics.checkParameterIsNotNull(response, "response");
            Intrinsics.checkParameterIsNotNull(segments, "segments");
            Intrinsics.checkParameterIsNotNull(message, cm.V);
            Intrinsics.checkParameterIsNotNull(responseUrl, "responseUrl");
            String str = Printer.LINE_SEPARATOR + Printer.BODY_TAG + Printer.LINE_SEPARATOR + getResponseBody(response);
            String tag = builder.getTag(false);
            String[] strArr = {Printer.URL_TAG + responseUrl, "\n"};
            String[] response2 = getResponse(headers, chainMs, code, isSuccessful, builder.getLevel(), segments, message);
            if (builder.getLogger() == null) {
                I.INSTANCE.log(builder.getType(), tag, Printer.RESPONSE_UP_LINE, builder.getIsLogHackEnable());
            }
            logLines(builder.getType(), tag, strArr, builder.getLogger(), true, builder.getIsLogHackEnable());
            logLines(builder.getType(), tag, response2, builder.getLogger(), true, builder.getIsLogHackEnable());
            if (builder.getLevel() == Level.BASIC || builder.getLevel() == Level.BODY) {
                int type = builder.getType();
                String str2 = Printer.LINE_SEPARATOR;
                Intrinsics.checkExpressionValueIsNotNull(str2, "LINE_SEPARATOR");
                Object[] array = StringsKt.split$default((CharSequence) str, new String[]{str2}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    logLines(type, tag, (String[]) array, builder.getLogger(), true, builder.getIsLogHackEnable());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            if (builder.getLogger() == null) {
                I.INSTANCE.log(builder.getType(), tag, Printer.END_LINE, builder.getIsLogHackEnable());
            }
        }

        private final String getResponseBody(Response response) throws IOException {
            Charset charset;
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                Intrinsics.throwNpe();
            }
            Headers headers = response.headers();
            long contentLength = responseBodyBody.getContentLength();
            if (!HttpHeaders.promisesBody(response)) {
                return "End request - Promises Body";
            }
            if (bodyHasUnknownEncoding(response.headers())) {
                return "encoded body omitted";
            }
            BufferedSource bodySource = responseBodyBody.getBodySource();
            bodySource.request(LocationRequestCompat.PASSIVE_INTERVAL);
            Buffer buffer = bodySource.getBuffer();
            Long l = null;
            if (StringsKt.equals("gzip", headers.get("Content-Encoding"), true)) {
                Long lValueOf = Long.valueOf(buffer.size());
                GzipSource gzipSource = new GzipSource(buffer.clone());
                try {
                    Buffer buffer2 = new Buffer();
                    buffer2.writeAll(gzipSource);
                    CloseableKt.closeFinally(gzipSource, (Throwable) null);
                    l = lValueOf;
                    buffer = buffer2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(gzipSource, th);
                        throw th2;
                    }
                }
            }
            MediaType mediaType = responseBodyBody.get$contentType();
            if (mediaType == null || (charset = mediaType.charset(StandardCharsets.UTF_8)) == null) {
                charset = StandardCharsets.UTF_8;
                Intrinsics.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
            }
            if (!PrinterKt.isProbablyUtf8(buffer)) {
                return "End request - binary " + buffer.size() + ":byte body omitted";
            }
            if (contentLength != 0) {
                return getJsonString(buffer.clone().readString(charset));
            }
            if (l != null) {
                return "End request - " + buffer.size() + ":byte, " + l + "-gzipped-byte body";
            }
            return "End request - " + buffer.size() + ":byte body";
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        private final String[] getRequest(Level level, Headers headers, String method) throws TypeCastException {
            boolean z = level == Level.HEADERS || level == Level.BASIC;
            StringBuilder sbAppend = new StringBuilder().append(Printer.METHOD_TAG).append(method).append(Printer.DOUBLE_SEPARATOR);
            String str = "";
            if (!isEmpty(String.valueOf(headers)) && z) {
                str = Printer.HEADERS_TAG + Printer.LINE_SEPARATOR + dotHeaders(headers);
            }
            String string = sbAppend.append(str).toString();
            String str2 = Printer.LINE_SEPARATOR;
            Intrinsics.checkExpressionValueIsNotNull(str2, "LINE_SEPARATOR");
            Object[] array = StringsKt.split$default((CharSequence) string, new String[]{str2}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        private final String[] getResponse(Headers headers, long tookMs, int code, boolean isSuccessful, Level level, List<String> segments, String message) throws TypeCastException {
            boolean z = level == Level.HEADERS || level == Level.BASIC;
            String strSlashSegments = slashSegments(segments);
            String str = "";
            StringBuilder sbAppend = new StringBuilder().append(strSlashSegments.length() > 0 ? strSlashSegments + " - " : "").append("[is success : ").append(isSuccessful).append("] - ").append(Printer.RECEIVED_TAG).append(tookMs).append("ms").append(Printer.DOUBLE_SEPARATOR).append(Printer.STATUS_CODE_TAG).append(code).append(" / ").append(message).append(Printer.DOUBLE_SEPARATOR);
            if (!isEmpty(String.valueOf(headers)) && z) {
                str = Printer.HEADERS_TAG + Printer.LINE_SEPARATOR + dotHeaders(headers);
            }
            String string = sbAppend.append(str).toString();
            String str2 = Printer.LINE_SEPARATOR;
            Intrinsics.checkExpressionValueIsNotNull(str2, "LINE_SEPARATOR");
            Object[] array = StringsKt.split$default((CharSequence) string, new String[]{str2}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        private final String slashSegments(List<String> segments) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = segments.iterator();
            while (it.hasNext()) {
                sb.append("/").append(it.next());
            }
            String string = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "segmentString.toString()");
            return string;
        }

        private final String dotHeaders(Headers headers) {
            StringBuilder sb = new StringBuilder();
            for (Pair<? extends String, ? extends String> pair : headers) {
                sb.append(((String) pair.getFirst()) + ": " + ((String) pair.getSecond())).append("\n");
            }
            return StringsKt.dropLast(sb, 1).toString();
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        private final void logLines(int type, String tag, String[] lines, Logger logger, boolean withLineSize, boolean useLogHack) throws TypeCastException {
            int i;
            String[] strArr = lines;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                int length2 = str.length();
                int i3 = withLineSize ? 110 : length2;
                int i4 = length2 / i3;
                if (i4 >= 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 * i3;
                        int i7 = i5 + 1;
                        int length3 = i7 * i3;
                        if (length3 > str.length()) {
                            length3 = str.length();
                        }
                        if (logger == null) {
                            I.Companion companion = I.INSTANCE;
                            i = length;
                            StringBuilder sbAppend = new StringBuilder().append(Printer.DEFAULT_LINE);
                            if (str == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                            String strSubstring = str.substring(i6, length3);
                            Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            companion.log(type, tag, sbAppend.append(strSubstring).toString(), useLogHack);
                        } else {
                            i = length;
                            if (str == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                            String strSubstring2 = str.substring(i6, length3);
                            Intrinsics.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            logger.log(type, tag, strSubstring2);
                        }
                        if (i5 != i4) {
                            i5 = i7;
                            length = i;
                        }
                    }
                } else {
                    i = length;
                }
                i2++;
                strArr = lines;
                length = i;
            }
        }

        private final String bodyToString(RequestBody requestBody, Headers headers) {
            Charset charset;
            if (requestBody == null) {
                return "";
            }
            try {
                if (Printer.INSTANCE.bodyHasUnknownEncoding(headers)) {
                    return "encoded body omitted)";
                }
                if (requestBody.isDuplex()) {
                    return "duplex request body omitted";
                }
                if (requestBody.isOneShot()) {
                    return "one-shot body omitted";
                }
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                MediaType contentType = requestBody.getContentType();
                if (contentType == null || (charset = contentType.charset(StandardCharsets.UTF_8)) == null) {
                    charset = StandardCharsets.UTF_8;
                    Intrinsics.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
                }
                if (PrinterKt.isProbablyUtf8(buffer)) {
                    return Printer.INSTANCE.getJsonString(buffer.readString(charset)) + Printer.LINE_SEPARATOR + requestBody.contentLength() + "-byte body";
                }
                return "binary " + requestBody.contentLength() + "-byte body omitted";
            } catch (IOException e) {
                return "{\"err\": \"" + e.getMessage() + "\"}";
            }
        }

        private final boolean bodyHasUnknownEncoding(Headers headers) {
            String str = headers.get("Content-Encoding");
            return (str == null || StringsKt.equals(str, "identity", true) || StringsKt.equals(str, "gzip", true)) ? false : true;
        }

        private final String getJsonString(String msg) throws JSONException {
            String string;
            try {
                if (StringsKt.startsWith$default(msg, "{", false, 2, (Object) null)) {
                    string = new JSONObject(msg).toString(3);
                    Intrinsics.checkExpressionValueIsNotNull(string, "jsonObject.toString(JSON_INDENT)");
                } else {
                    if (!StringsKt.startsWith$default(msg, "[", false, 2, (Object) null)) {
                        return msg;
                    }
                    string = new JSONArray(msg).toString(3);
                    Intrinsics.checkExpressionValueIsNotNull(string, "jsonArray.toString(JSON_INDENT)");
                }
                return string;
            } catch (OutOfMemoryError unused) {
                return Printer.OOM_OMITTED;
            } catch (JSONException unused2) {
                return msg;
            }
        }

        public final void printFailed(String tag, LoggingInterceptor.Builder builder) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            I.INSTANCE.log(builder.getType(), tag, Printer.RESPONSE_UP_LINE, builder.getIsLogHackEnable());
            I.INSTANCE.log(builder.getType(), tag, "│ Response failed", builder.getIsLogHackEnable());
            I.INSTANCE.log(builder.getType(), tag, Printer.END_LINE, builder.getIsLogHackEnable());
        }
    }

    private Printer() {
        throw new UnsupportedOperationException();
    }

    static {
        String property = System.getProperty("line.separator");
        LINE_SEPARATOR = property;
        DOUBLE_SEPARATOR = property + property;
        OOM_OMITTED = property + "Output omitted because of Object size.";
    }
}
