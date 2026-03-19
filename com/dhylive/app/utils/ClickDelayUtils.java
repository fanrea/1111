package com.dhylive.app.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickDelayUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/dhylive/app/utils/ClickDelayUtils;", "", "()V", "hash", "", "lastClickTime", "", "doClickDelay", "", "Landroid/view/View;", "time", "clickAction", "Lkotlin/Function1;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ClickDelayUtils {
    public static final ClickDelayUtils INSTANCE = new ClickDelayUtils();
    private static int hash;
    private static long lastClickTime;

    private ClickDelayUtils() {
    }

    public static /* synthetic */ void doClickDelay$default(ClickDelayUtils clickDelayUtils, View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        clickDelayUtils.doClickDelay(view, j, function1);
    }

    public final void doClickDelay(final View view, final long j, final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "clickAction");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.dhylive.app.utils.ClickDelayUtils$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickDelayUtils.doClickDelay$lambda$0(view, function1, j, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doClickDelay$lambda$0(View view, Function1 function1, long j, View view2) {
        Intrinsics.checkNotNullParameter(view, "$this_doClickDelay");
        Intrinsics.checkNotNullParameter(function1, "$clickAction");
        if (view.hashCode() != hash) {
            hash = view.hashCode();
            lastClickTime = System.currentTimeMillis();
            Intrinsics.checkNotNull(view2);
            function1.invoke(view2);
            return;
        }
        if (System.currentTimeMillis() - lastClickTime > j) {
            lastClickTime = System.currentTimeMillis();
            Intrinsics.checkNotNull(view2);
            function1.invoke(view2);
        }
    }
}
