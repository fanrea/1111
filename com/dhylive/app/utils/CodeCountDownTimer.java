package com.dhylive.app.utils;

import android.os.CountDownTimer;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeCountDownTimer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/dhylive/app/utils/CodeCountDownTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "mButton", "Landroid/widget/TextView;", "(JJLandroid/widget/TextView;)V", "onFinish", "", "onTick", "l", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CodeCountDownTimer extends CountDownTimer {
    private final long countDownInterval;
    private final TextView mButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeCountDownTimer(long j, long j2, TextView textView) {
        super(j, j2);
        Intrinsics.checkNotNullParameter(textView, "mButton");
        this.countDownInterval = j2;
        this.mButton = textView;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long l) {
        this.mButton.setClickable(false);
        this.mButton.setText((l / this.countDownInterval) + "s后重试");
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.mButton.setClickable(true);
        this.mButton.setText("重新获取验证码");
    }
}
