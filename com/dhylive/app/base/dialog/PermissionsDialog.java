package com.dhylive.app.base.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.AppUtils;
import com.dhylive.app.R;
import com.dhylive.app.databinding.DialogPermissionsBinding;
import com.dhylive.app.utils.ClickDelayUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionsDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/dhylive/app/base/dialog/PermissionsDialog;", "Lcom/dhylive/app/base/dialog/BaseDialog;", "Lcom/dhylive/app/databinding/DialogPermissionsBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initListener", "", "setContent", "permissions", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class PermissionsDialog extends BaseDialog<DialogPermissionsBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionsDialog(Context context) {
        super(context, 0, 0, 0, false, 0, 62, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.dhylive.app.base.dialog.BaseDialog
    public void initListener() {
        ClickDelayUtils clickDelayUtils = ClickDelayUtils.INSTANCE;
        TextView textView = getDataBinding().tvPermissionsCancel;
        Intrinsics.checkNotNullExpressionValue(textView, "tvPermissionsCancel");
        ClickDelayUtils.doClickDelay$default(clickDelayUtils, textView, 0L, new Function1<View, Unit>() { // from class: com.dhylive.app.base.dialog.PermissionsDialog.initListener.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                PermissionsDialog.this.dismiss();
            }
        }, 1, null);
        ClickDelayUtils clickDelayUtils2 = ClickDelayUtils.INSTANCE;
        TextView textView2 = getDataBinding().tvPermissionsOk;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvPermissionsOk");
        ClickDelayUtils.doClickDelay$default(clickDelayUtils2, textView2, 0L, new Function1<View, Unit>() { // from class: com.dhylive.app.base.dialog.PermissionsDialog.initListener.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + AppUtils.getAppPackageName()));
                intent.setComponent(null);
                intent.setSelector(null);
                PermissionsDialog.this.getContext().startActivity(intent);
                PermissionsDialog.this.dismiss();
            }
        }, 1, null);
    }

    public final PermissionsDialog setContent(String permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        getDataBinding().tvPermissionsContent.setText(getContext().getString(R.string.dialog_permissions_content, permissions.toString()));
        return this;
    }
}
