package com.sigmob.sdk.nativead;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends Dialog {
    private final String a;

    public b(Context context, String textToShow) {
        super(context, com.sigmob.sdk.base.k.e());
        this.a = textToShow;
    }

    private void a() {
        int i;
        Window window = getWindow();
        Context context = getContext();
        if (window == null) {
            return;
        }
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        int iDipsToIntPixels = Dips.dipsToIntPixels(0.0f, context);
        int i4 = -1;
        if (i3 > i2) {
            i = -1;
            i4 = i2 - iDipsToIntPixels;
        } else {
            i = i3 - iDipsToIntPixels;
        }
        attributes.width = i4;
        attributes.height = i;
        window.setAttributes(attributes);
        int iG = com.sigmob.sdk.base.k.g();
        if (iG <= 0) {
            return;
        }
        window.setWindowAnimations(iG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getWindow() == null) {
            return;
        }
        setContentView(R.layout.sig_fullscreen_layout);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        findViewById(R.id.dialog_root).setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.nativead.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.dialog_text);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.nativead.b$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        textView.setText(this.a);
        textView.requestFocus();
        a();
    }
}
