package lkxssdk.h;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a extends Dialog {
    public lkxssdk.h.b a;

    /* renamed from: lkxssdk.h.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0843a implements View.OnClickListener {
        public ViewOnClickListenerC0843a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            lkxssdk.h.b bVar = a.this.a;
            if (bVar != null) {
                bVar.getClass();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            lkxssdk.h.b bVar = a.this.a;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            lkxssdk.h.b bVar = a.this.a;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    public a(Context context, int i, int i2, lkxssdk.h.b bVar) {
        super(context, i);
        this.a = bVar;
        setContentView(a(i2));
        b(i2);
    }

    public final int a(int i) {
        e eVarA;
        e eVarA2 = e.a();
        String str = "lkxs_dialog_btn_no";
        int identifier = eVarA2.b.getResources().getIdentifier("lkxs_dialog_btn_no", "layout", eVarA2.c);
        if (i == 0) {
            eVarA = e.a();
        } else if (i == 1) {
            eVarA = e.a();
            str = "lkxs_dialog_btn_one";
        } else if (i == 2) {
            eVarA = e.a();
            str = "lkxs_dialog_btn_two";
        } else {
            if (i != 5) {
                return identifier;
            }
            eVarA = e.a();
            str = "lkxs_dialog_net_timeout";
        }
        return eVarA.b.getResources().getIdentifier(str, "layout", eVarA.c);
    }

    public final void b(int i) {
        if (i != 1) {
            if (i == 2) {
                c(2);
                return;
            } else if (i != 5) {
                return;
            }
        }
        c(1);
    }

    public final void c(int i) {
        if (i == 1) {
            e eVarA = e.a();
            ((TextView) findViewById(eVarA.b.getResources().getIdentifier("dialog_btn", "id", eVarA.c))).setOnClickListener(new ViewOnClickListenerC0843a());
        } else {
            if (i != 2) {
                return;
            }
            e eVarA2 = e.a();
            TextView textView = (TextView) findViewById(eVarA2.b.getResources().getIdentifier("dialog_btn_left", "id", eVarA2.c));
            e eVarA3 = e.a();
            TextView textView2 = (TextView) findViewById(eVarA3.b.getResources().getIdentifier("dialog_btn_right", "id", eVarA3.c));
            textView.setOnClickListener(new b());
            textView2.setOnClickListener(new c());
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        lkxssdk.h.b bVar = this.a;
        if (bVar == null) {
            return true;
        }
        bVar.a();
        return true;
    }
}
