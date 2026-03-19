package lkxssdk.h;

import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c {
    public a a;
    public BaseActivity b;

    public c(BaseActivity baseActivity) {
        this.b = baseActivity;
    }

    public void a() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void a(int i, b bVar) {
        BaseActivity baseActivity = this.b;
        e eVarA = e.a();
        a aVar = new a(baseActivity, eVarA.b.getResources().getIdentifier("LKXSDialogStyle", "style", eVarA.c), i, bVar);
        this.a = aVar;
        aVar.setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams attributes = this.a.getWindow().getAttributes();
        attributes.width = (int) (lkxssdk.b.a.a * 0.7733d);
        this.a.getWindow().setAttributes(attributes);
    }

    public void a(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setCanceledOnTouchOutside(z);
        }
    }

    public void b() {
        if (this.a == null || this.b.isFinishing()) {
            return;
        }
        try {
            this.a.show();
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }

    public void b(String str) {
        a aVar = this.a;
        if (aVar != null) {
            e eVarA = e.a();
            ((TextView) aVar.findViewById(eVarA.b.getResources().getIdentifier("dialog_btn_left", "id", eVarA.c))).setText(str);
        }
    }

    public void c(String str) {
        a aVar = this.a;
        if (aVar != null) {
            e eVarA = e.a();
            ((TextView) aVar.findViewById(eVarA.b.getResources().getIdentifier("dialog_btn_right", "id", eVarA.c))).setText(str);
        }
    }

    public void d(String str) {
        a aVar = this.a;
        if (aVar != null) {
            e eVarA = e.a();
            TextView textView = (TextView) aVar.findViewById(eVarA.b.getResources().getIdentifier("dialog_title", "id", eVarA.c));
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
            } else {
                textView.setText(str);
            }
        }
    }

    public void a(String str) {
        a aVar;
        a aVar2 = this.a;
        if (aVar2 != null) {
            e eVarA = e.a();
            TextView textView = (TextView) aVar2.findViewById(eVarA.b.getResources().getIdentifier("dialog_content", "id", eVarA.c));
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
            if (str.length() <= 150 || (aVar = this.a) == null) {
                return;
            }
            e eVarA2 = e.a();
            TextView textView2 = (TextView) aVar.findViewById(eVarA2.b.getResources().getIdentifier("dialog_content", "id", eVarA2.c));
            int i = lkxssdk.b.a.b;
            if (i > 0) {
                textView2.setMaxHeight(i - lkxssdk.a.a.a(200.0f));
            }
            textView2.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}
