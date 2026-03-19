package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class k implements t {
    private a.InterfaceC0551a bdK;
    private a.c bdL;
    private Queue<MessageSnapshot> bdM;
    private boolean bdN = false;

    k(a.InterfaceC0551a interfaceC0551a, a.c cVar) {
        a(interfaceC0551a, cVar);
    }

    private void a(a.InterfaceC0551a interfaceC0551a, a.c cVar) {
        this.bdK = interfaceC0551a;
        this.bdL = cVar;
        this.bdM = new LinkedBlockingQueue();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean MR() {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.bdK);
        }
        if (this.bdK == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.bdM.size()));
            return false;
        }
        this.bdL.onBegin();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.bdK);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.bdK);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.bdK);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a aVarMo = this.bdK.Mo();
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", aVarMo, Long.valueOf(aVarMo.Me()), Long.valueOf(aVarMo.Mf()));
        }
        if (aVarMo.Ma() <= 0) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.bdK);
                return;
            }
            return;
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.bdK, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            a aVarMo = this.bdK.Mo();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.bdK, Integer.valueOf(aVarMo.Mj()), Integer.valueOf(aVarMo.Mk()), aVarMo.Mi());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.bdK);
        }
        this.bdL.Mx();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            a.InterfaceC0551a interfaceC0551a = this.bdK;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0551a, interfaceC0551a.Mo().Mi());
        }
        this.bdL.Mx();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.bdK);
        }
        this.bdL.Mx();
        p(messageSnapshot);
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.bdK);
        }
        this.bdL.Mx();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0551a interfaceC0551a = this.bdK;
        if (interfaceC0551a == null) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Mg()));
            }
        } else {
            if (this.bdN || interfaceC0551a.Mo().Md() == null) {
                if ((l.isValid() || this.bdK.Mv()) && messageSnapshot.Mg() == 4) {
                    this.bdL.Mx();
                }
                de(messageSnapshot.Mg());
                return;
            }
            this.bdM.offer(messageSnapshot);
            j.MO().a(this);
        }
    }

    private void de(int i) {
        if (com.kwad.framework.filedownloader.d.d.dH(i)) {
            if (!this.bdM.isEmpty()) {
                MessageSnapshot messageSnapshotPeek = this.bdM.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshotPeek.getId()), Integer.valueOf(this.bdM.size()), Byte.valueOf(messageSnapshotPeek.Mg()));
            }
            this.bdK = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.framework.filedownloader.t
    public final void MS() {
        if (this.bdN) {
            return;
        }
        MessageSnapshot messageSnapshotPoll = this.bdM.poll();
        byte bMg = messageSnapshotPoll.Mg();
        a.InterfaceC0551a interfaceC0551a = this.bdK;
        if (interfaceC0551a == null) {
            return;
        }
        a aVarMo = interfaceC0551a.Mo();
        i iVarMd = aVarMo.Md();
        x.a aVarMp = interfaceC0551a.Mp();
        de(bMg);
        if (iVarMd == null) {
            return;
        }
        if (bMg == 4) {
            try {
                iVarMd.d(aVarMo);
                o(((com.kwad.framework.filedownloader.message.a) messageSnapshotPoll).Oh());
                return;
            } catch (Throwable th) {
                m(aVarMp.j(th));
                return;
            }
        }
        g gVar = iVarMd instanceof g ? (g) iVarMd : null;
        if (bMg == -4) {
            iVarMd.a(aVarMo);
            return;
        }
        if (bMg == -3) {
            iVarMd.b(aVarMo);
            return;
        }
        if (bMg == -2) {
            if (gVar != null) {
                messageSnapshotPoll.Om();
                messageSnapshotPoll.Ok();
                return;
            } else {
                iVarMd.c(aVarMo, messageSnapshotPoll.Oi(), messageSnapshotPoll.Oj());
                return;
            }
        }
        if (bMg == -1) {
            iVarMd.a(aVarMo, messageSnapshotPoll.On());
            return;
        }
        if (bMg == 1) {
            if (gVar != null) {
                messageSnapshotPoll.Om();
                messageSnapshotPoll.Ok();
                return;
            } else {
                iVarMd.a(aVarMo, messageSnapshotPoll.Oi(), messageSnapshotPoll.Oj());
                return;
            }
        }
        if (bMg == 2) {
            if (gVar != null) {
                messageSnapshotPoll.getEtag();
                messageSnapshotPoll.Oa();
                messageSnapshotPoll.Ok();
                return;
            }
            iVarMd.a(aVarMo, messageSnapshotPoll.getEtag(), messageSnapshotPoll.Oa(), aVarMo.getSmallFileSoFarBytes(), messageSnapshotPoll.Oj());
            return;
        }
        if (bMg == 3) {
            if (gVar != null) {
                messageSnapshotPoll.Om();
                return;
            } else {
                iVarMd.b(aVarMo, messageSnapshotPoll.Oi(), aVarMo.getSmallFileTotalBytes());
                return;
            }
        }
        if (bMg != 5) {
            if (bMg != 6) {
                return;
            }
            iVarMd.c(aVarMo);
        } else if (gVar != null) {
            messageSnapshotPoll.On();
            messageSnapshotPoll.Mk();
            messageSnapshotPoll.Om();
        } else {
            messageSnapshotPoll.On();
            messageSnapshotPoll.Mk();
            messageSnapshotPoll.Oi();
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean MT() {
        return this.bdK.Mo().Ml();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0551a interfaceC0551a, a.c cVar) {
        if (this.bdK != null) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("the messenger is working, can't re-appointment for %s", interfaceC0551a));
        }
        a(interfaceC0551a, cVar);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean MU() {
        return this.bdM.peek().Mg() == 4;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void discard() {
        this.bdN = true;
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        a.InterfaceC0551a interfaceC0551a = this.bdK;
        objArr[0] = Integer.valueOf(interfaceC0551a == null ? -1 : interfaceC0551a.Mo().getId());
        objArr[1] = super.toString();
        return com.kwad.framework.filedownloader.f.f.c("%d:%s", objArr);
    }
}
