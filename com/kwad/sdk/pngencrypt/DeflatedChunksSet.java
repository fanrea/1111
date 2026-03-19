package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DeflatedChunksSet {
    protected final boolean cgT;
    protected byte[] chj;
    private int chk;
    private int chl;
    private int chm;
    State chn;
    private final boolean cho;
    private d chp;
    private long chq = 0;
    private long chr = 0;
    int chs = -1;
    int cht = -1;
    public final String chu;
    private Inflater inf;

    protected void amv() {
    }

    enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }

        public final boolean isClosed() {
            return this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) throws DataFormatException {
        this.chn = State.WAITING_FOR_INPUT;
        this.chu = str;
        this.cgT = z;
        this.chl = i;
        if (i <= 0 || i2 < i) {
            throw new PngjException("bad inital row len " + i);
        }
        if (inflater != null) {
            this.inf = inflater;
            this.cho = false;
        } else {
            this.inf = new Inflater();
            this.cho = true;
        }
        this.chj = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.chm = -1;
        this.chn = State.WAITING_FOR_INPUT;
        try {
            gU(i);
        } catch (RuntimeException e) {
            close();
            throw e;
        }
    }

    protected final void a(d dVar) {
        if (!this.chu.equals(dVar.amh().id)) {
            new PngjException("Bad chunk inside IdatSet, id:" + dVar.amh().id + ", expected:" + this.chu);
        }
        this.chp = dVar;
        int i = this.chs + 1;
        this.chs = i;
        int i2 = this.cht;
        if (i2 >= 0) {
            dVar.gT(i + i2);
        }
    }

    protected final void c(byte[] bArr, int i, int i2) throws DataFormatException {
        this.chq += i2;
        if (i2 <= 0 || this.chn.isDone()) {
            return;
        }
        if (this.chn == State.ROW_READY) {
            new PngjException("this should only be called if waitingForMoreInput");
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i, i2);
        if (this.cgT) {
            while (amu()) {
                gU(amw());
                isDone();
            }
            return;
        }
        amu();
    }

    private boolean amu() throws DataFormatException {
        State state;
        int iInflate;
        try {
            if (this.chn == State.ROW_READY) {
                new PngjException("invalid state");
            }
            if (this.chn.isDone()) {
                return false;
            }
            byte[] bArr = this.chj;
            if (bArr == null || bArr.length < this.chl) {
                this.chj = new byte[this.chl];
            }
            if (this.chk < this.chl && !this.inf.finished()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr2 = this.chj;
                    int i = this.chk;
                    iInflate = inflater.inflate(bArr2, i, this.chl - i);
                } catch (DataFormatException e) {
                    new PngjException("error decompressing zlib stream ", e);
                    iInflate = 0;
                }
                this.chk += iInflate;
                this.chr += iInflate;
            }
            if (this.chk == this.chl) {
                state = State.ROW_READY;
            } else if (!this.inf.finished()) {
                state = State.WAITING_FOR_INPUT;
            } else if (this.chk > 0) {
                state = State.ROW_READY;
            } else {
                state = State.DONE;
            }
            this.chn = state;
            if (state != State.ROW_READY) {
                return false;
            }
            amv();
            return true;
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    protected int amw() {
        throw new PngjException("not implemented");
    }

    public final void gU(int i) throws DataFormatException {
        this.chk = 0;
        this.chm++;
        if (i <= 0) {
            this.chl = 0;
            amx();
        } else {
            if (this.inf.finished()) {
                this.chl = 0;
                amx();
                return;
            }
            this.chn = State.WAITING_FOR_INPUT;
            this.chl = i;
            if (this.cgT) {
                return;
            }
            amu();
        }
    }

    public final boolean isDone() {
        return this.chn.isDone();
    }

    public final boolean isClosed() {
        return this.chn.isClosed();
    }

    public final boolean hU(String str) {
        if (this.chn.isClosed()) {
            return false;
        }
        if (str.equals(this.chu)) {
            return true;
        }
        if (this.chn.isDone()) {
            if (!this.chn.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.chu + " set is not done");
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.chn.isClosed()) {
                this.chn = State.CLOSED;
            }
            if (!this.cho || (inflater = this.inf) == null) {
                return;
            }
            inflater.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final void amx() {
        if (isDone()) {
            return;
        }
        this.chn = State.DONE;
    }

    public final int amy() {
        return this.chm;
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.chp.amh().id + " state=" + this.chn + " rows=" + this.chm + " bytes=" + this.chq + "/" + this.chr).toString();
    }
}
