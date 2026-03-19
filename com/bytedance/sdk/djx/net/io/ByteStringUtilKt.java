package com.bytedance.sdk.djx.net.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteStringUtil.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"encodeUtf8", "Lcom/bytedance/sdk/djx/net/io/ByteString;", "", "toLongOrDefault", "", "defaultValue", "net_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ByteStringUtilKt {
    public static final ByteString encodeUtf8(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(str);
        Intrinsics.checkNotNullExpressionValue(byteStringEncodeUtf8, "encodeUtf8(this)");
        return byteStringEncodeUtf8;
    }

    public static final long toLongOrDefault(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }
}
