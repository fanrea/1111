package com.dhylive.app.utils;

import android.text.TextUtils;
import com.alipay.sdk.m.u.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlipayResult.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/dhylive/app/utils/AlipayResult;", "", "rawResult", "", "", "(Ljava/util/Map;)V", l.b, "getMemo", "()Ljava/lang/String;", "setMemo", "(Ljava/lang/String;)V", "result", "getResult", "setResult", l.a, "getResultStatus", "setResultStatus", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class AlipayResult {
    private String memo;
    private String result;
    private String resultStatus;

    public AlipayResult(Map<String, String> map) {
        this.resultStatus = "";
        this.result = "";
        this.memo = "";
        if (map != null) {
            for (String str : map.keySet()) {
                String str2 = str;
                if (TextUtils.equals(str2, l.a)) {
                    String str3 = map.get(str);
                    this.resultStatus = str3 == null ? "" : str3;
                } else if (TextUtils.equals(str2, "result")) {
                    String str4 = map.get(str);
                    this.result = str4 == null ? "" : str4;
                } else if (TextUtils.equals(str2, l.b)) {
                    String str5 = map.get(str);
                    this.memo = str5 == null ? "" : str5;
                }
            }
        }
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final void setResultStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resultStatus = str;
    }

    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.result = str;
    }

    public final String getMemo() {
        return this.memo;
    }

    public final void setMemo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.memo = str;
    }

    public String toString() {
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + '}';
    }
}
