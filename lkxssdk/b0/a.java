package lkxssdk.b0;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a implements View.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ b b;

    public a(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int adapterPosition = this.a.getAdapterPosition();
        if (adapterPosition == -1) {
            return;
        }
        this.b.getClass();
        b bVar = this.b;
        bVar.e.a(bVar, view, adapterPosition + 0);
    }
}
