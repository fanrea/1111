package com.kwad.components.ct.detail.photo.comment;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.home.PhotoComment;
import com.kwad.sdk.utils.bq;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends RecyclerView.Adapter<j> {
    private long arQ;
    protected Context mContext;
    protected List<PhotoComment> arP = new ArrayList();
    private List<b> arR = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return zK();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.arP.size();
    }

    private void u(List<PhotoComment> list) {
        if (list != null) {
            this.arP.clear();
            this.arP.addAll(list);
            notifyDataSetChanged();
        }
    }

    public d(Context context, e eVar) {
        this.mContext = context;
        u(eVar.zT());
        if (eVar.zT() != null) {
            for (int i = 0; i < eVar.zU(); i++) {
                PhotoComment photoComment = eVar.zT().get(i);
                b bVar = new b();
                bVar.arB = photoComment;
                bVar.arC = eVar.zR();
                bVar.arD = eVar.getPosition();
                bVar.arF = i;
                bVar.content = bq.iK(photoComment.content);
                this.arR.add(bVar);
            }
        }
    }

    private j zK() {
        return new j(new com.kwad.components.ct.detail.photo.newui.a.a(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(j jVar, int i) {
        jVar.a(this.arR.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        bE(i);
        return 0;
    }

    public final long zL() {
        return this.arQ;
    }

    private void bE(int i) {
        long j = i;
        if (j > this.arQ) {
            this.arQ = j;
        }
    }
}
