package com.kwad.framework.filedownloader.message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface a {
    MessageSnapshot Oh();

    /* renamed from: com.kwad.framework.filedownloader.message.a$a, reason: collision with other inner class name */
    public static class C0558a extends MessageSnapshot implements a {
        private final MessageSnapshot bgi;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) 4;
        }

        public C0558a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.Mg() != -3) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Mg())));
            }
            this.bgi = messageSnapshot;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot Oh() {
            return this.bgi;
        }
    }
}
