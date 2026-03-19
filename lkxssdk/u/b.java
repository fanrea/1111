package lkxssdk.u;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.Matrix;
import com.kwai.video.player.KsMediaMeta;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b {
    public a a = null;
    public c b = null;
    public FileOutputStream c = null;
    public FileChannel d = null;
    public long e = 0;
    public long f = 0;
    public boolean g = true;
    public HashMap<g, long[]> h = new HashMap<>();
    public ByteBuffer i = null;

    public class a implements Box {
        public Container a;
        public long b = 1073741824;
        public long c = 0;

        public a(b bVar) {
        }

        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            long size = getSize();
            long j = 8 + size;
            if (j < KsMediaMeta.AV_CH_WIDE_RIGHT) {
                IsoTypeWriter.writeUInt32(byteBufferAllocate, size);
            } else {
                IsoTypeWriter.writeUInt32(byteBufferAllocate, 1L);
            }
            byteBufferAllocate.put(IsoFile.fourCCtoBytes("mdat"));
            if (j < KsMediaMeta.AV_CH_WIDE_RIGHT) {
                byteBufferAllocate.put(new byte[8]);
            } else {
                IsoTypeWriter.writeUInt64(byteBufferAllocate, size);
            }
            byteBufferAllocate.rewind();
            writableByteChannel.write(byteBufferAllocate);
        }

        public long getOffset() {
            return this.c;
        }

        public Container getParent() {
            return this.a;
        }

        public long getSize() {
            return this.b + 16;
        }

        public String getType() {
            return "mdat";
        }

        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) {
        }

        public void setParent(Container container) {
            this.a = container;
        }
    }

    public static long a(long j, long j2) {
        return j2 == 0 ? j : a(j2, j % j2);
    }

    public int a(MediaFormat mediaFormat, boolean z) {
        c cVar = this.b;
        cVar.b.add(new g(cVar.b.size(), mediaFormat, z));
        return cVar.b.size() - 1;
    }

    public final void b() throws IOException {
        long jPosition = this.d.position();
        this.d.position(this.a.c);
        this.a.getBox(this.d);
        this.d.position(jPosition);
        a aVar = this.a;
        aVar.c = 0L;
        aVar.b = 0L;
        this.c.flush();
    }

    public b a(c cVar) {
        this.b = cVar;
        FileOutputStream fileOutputStream = new FileOutputStream(cVar.c);
        this.c = fileOutputStream;
        this.d = fileOutputStream.getChannel();
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("3gp4");
        FileTypeBox fileTypeBox = new FileTypeBox("isom", 0L, linkedList);
        fileTypeBox.getBox(this.d);
        long size = this.e + fileTypeBox.getSize();
        this.e = size;
        this.f += size;
        this.a = new a(this);
        this.i = ByteBuffer.allocateDirect(4);
        return this;
    }

    public long b(c cVar) {
        long jA = !cVar.b.isEmpty() ? cVar.b.iterator().next().i : 0L;
        Iterator<g> it = cVar.b.iterator();
        while (it.hasNext()) {
            long j = it.next().i;
            jA = jA == 0 ? j : a(jA, j % jA);
        }
        return jA;
    }

    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public void a() throws IOException {
        int i;
        long[] jArr;
        int i2;
        Iterator<Long> it;
        long j;
        long j2 = 0;
        if (this.a.b != 0) {
            b();
        }
        Iterator<g> it2 = this.b.b.iterator();
        while (true) {
            i = 0;
            if (!it2.hasNext()) {
                break;
            }
            g next = it2.next();
            ArrayList<e> arrayList = next.c;
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            while (i < size) {
                jArr2[i] = arrayList.get(i).b;
                i++;
            }
            this.h.put(next, jArr2);
        }
        c cVar = this.b;
        MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setCreationTime(new Date());
        movieHeaderBox.setModificationTime(new Date());
        movieHeaderBox.setMatrix(Matrix.ROTATE_0);
        long jB = b(cVar);
        Iterator<g> it3 = cVar.b.iterator();
        while (it3.hasNext()) {
            long j3 = (it3.next().d * jB) / r10.i;
            if (j3 > j2) {
                j2 = j3;
            }
        }
        movieHeaderBox.setDuration(j2);
        movieHeaderBox.setTimescale(jB);
        ?? r4 = 1;
        movieHeaderBox.setNextTrackId(cVar.b.size() + 1);
        movieBox.addBox(movieHeaderBox);
        Iterator<g> it4 = cVar.b.iterator();
        while (it4.hasNext()) {
            g next2 = it4.next();
            TrackBox trackBox = new TrackBox();
            TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
            trackHeaderBox.setEnabled((boolean) r4);
            trackHeaderBox.setInMovie((boolean) r4);
            trackHeaderBox.setInPreview((boolean) r4);
            next2.getClass();
            trackHeaderBox.setMatrix(cVar.a);
            trackHeaderBox.setAlternateGroup(i);
            trackHeaderBox.setCreationTime(next2.j);
            trackHeaderBox.setDuration((next2.d * b(cVar)) / next2.i);
            trackHeaderBox.setHeight(next2.k);
            trackHeaderBox.setWidth(next2.l);
            trackHeaderBox.setLayer(i);
            trackHeaderBox.setModificationTime(new Date());
            trackHeaderBox.setTrackId(next2.b + 1);
            trackHeaderBox.setVolume(next2.m);
            trackBox.addBox(trackHeaderBox);
            MediaBox mediaBox = new MediaBox();
            trackBox.addBox(mediaBox);
            MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
            mediaHeaderBox.setCreationTime(next2.j);
            mediaHeaderBox.setDuration(next2.d);
            mediaHeaderBox.setTimescale(next2.i);
            mediaHeaderBox.setLanguage("eng");
            mediaBox.addBox(mediaHeaderBox);
            HandlerBox handlerBox = new HandlerBox();
            handlerBox.setName("VideoHandle");
            handlerBox.setHandlerType(next2.e);
            mediaBox.addBox(handlerBox);
            MediaInformationBox mediaInformationBox = new MediaInformationBox();
            mediaInformationBox.addBox(next2.f);
            DataInformationBox dataInformationBox = new DataInformationBox();
            DataReferenceBox dataReferenceBox = new DataReferenceBox();
            dataInformationBox.addBox(dataReferenceBox);
            DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
            dataEntryUrlBox.setFlags((int) r4);
            dataReferenceBox.addBox(dataEntryUrlBox);
            mediaInformationBox.addBox(dataInformationBox);
            SampleTableBox sampleTableBox = new SampleTableBox();
            sampleTableBox.addBox(next2.g);
            ArrayList arrayList2 = new ArrayList();
            Iterator<Long> it5 = next2.n.iterator();
            TimeToSampleBox.Entry entry = null;
            while (it5.hasNext()) {
                long jLongValue = it5.next().longValue();
                if (entry == null || entry.getDelta() != jLongValue) {
                    it = it5;
                    j = 1;
                    entry = new TimeToSampleBox.Entry(1L, jLongValue);
                    arrayList2.add(entry);
                } else {
                    it = it5;
                    j = 1;
                    entry.setCount(entry.getCount() + 1);
                }
                it5 = it;
            }
            TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
            timeToSampleBox.setEntries(arrayList2);
            sampleTableBox.addBox(timeToSampleBox);
            LinkedList<Integer> linkedList = next2.h;
            if (linkedList == null || linkedList.isEmpty()) {
                jArr = null;
            } else {
                jArr = new long[next2.h.size()];
                for (int i3 = 0; i3 < next2.h.size(); i3++) {
                    jArr[i3] = next2.h.get(i3).intValue();
                }
            }
            if (jArr != null && jArr.length > 0) {
                SyncSampleBox syncSampleBox = new SyncSampleBox();
                syncSampleBox.setSampleNumber(jArr);
                sampleTableBox.addBox(syncSampleBox);
            }
            SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
            sampleToChunkBox.setEntries(new LinkedList());
            int i4 = -1;
            int size2 = next2.c.size();
            int i5 = r4;
            int i6 = 0;
            int i7 = 0;
            while (i6 < size2) {
                e eVar = next2.c.get(i6);
                c cVar2 = cVar;
                MovieBox movieBox2 = movieBox;
                Iterator<g> it6 = it4;
                i7++;
                if (i6 == size2 + (-1) || eVar.a + eVar.b != next2.c.get(i6 + 1).a) {
                    if (i4 != i7) {
                        i2 = size2;
                        sampleToChunkBox.getEntries().add(new SampleToChunkBox.Entry(i5, i7, 1L));
                        i4 = i7;
                    } else {
                        i2 = size2;
                    }
                    i5++;
                    i7 = 0;
                } else {
                    i2 = size2;
                }
                i6++;
                cVar = cVar2;
                movieBox = movieBox2;
                it4 = it6;
                size2 = i2;
            }
            c cVar3 = cVar;
            MovieBox movieBox3 = movieBox;
            Iterator<g> it7 = it4;
            sampleTableBox.addBox(sampleToChunkBox);
            SampleSizeBox sampleSizeBox = new SampleSizeBox();
            sampleSizeBox.setSampleSizes(this.h.get(next2));
            sampleTableBox.addBox(sampleSizeBox);
            ArrayList arrayList3 = new ArrayList();
            Iterator<e> it8 = next2.c.iterator();
            long j4 = -1;
            while (it8.hasNext()) {
                e next3 = it8.next();
                long j5 = next3.a;
                if (j4 != -1 && j4 != j5) {
                    j4 = -1;
                }
                if (j4 == -1) {
                    arrayList3.add(Long.valueOf(j5));
                }
                j4 = next3.b + j5;
            }
            long[] jArr3 = new long[arrayList3.size()];
            for (int i8 = 0; i8 < arrayList3.size(); i8++) {
                jArr3[i8] = ((Long) arrayList3.get(i8)).longValue();
            }
            StaticChunkOffsetBox staticChunkOffsetBox = new StaticChunkOffsetBox();
            staticChunkOffsetBox.setChunkOffsets(jArr3);
            sampleTableBox.addBox(staticChunkOffsetBox);
            mediaInformationBox.addBox(sampleTableBox);
            mediaBox.addBox(mediaInformationBox);
            movieBox3.addBox(trackBox);
            movieBox = movieBox3;
            cVar = cVar3;
            it4 = it7;
            r4 = 1;
            i = 0;
        }
        movieBox.getBox(this.d);
        this.c.flush();
        this.d.close();
        this.c.close();
    }

    public boolean a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) throws IOException {
        boolean z2;
        if (this.g) {
            a aVar = this.a;
            aVar.b = 0L;
            aVar.getBox(this.d);
            a aVar2 = this.a;
            long j = this.e;
            aVar2.c = j;
            this.e = j + 16;
            this.f += 16;
            this.g = false;
        }
        a aVar3 = this.a;
        long j2 = aVar3.b;
        long j3 = bufferInfo.size;
        aVar3.b = j2 + j3;
        long j4 = this.f + j3;
        this.f = j4;
        if (j4 >= 32768) {
            b();
            this.g = true;
            this.f -= 32768;
            z2 = true;
        } else {
            z2 = false;
        }
        c cVar = this.b;
        long j5 = this.e;
        cVar.getClass();
        if (i >= 0 && i < cVar.b.size()) {
            g gVar = cVar.b.get(i);
            gVar.getClass();
            boolean z3 = (bufferInfo.flags & 1) != 0;
            gVar.c.add(new e(j5, bufferInfo.size));
            LinkedList<Integer> linkedList = gVar.h;
            if (linkedList != null && z3) {
                linkedList.add(Integer.valueOf(gVar.c.size()));
            }
            long j6 = bufferInfo.presentationTimeUs;
            long j7 = j6 - gVar.o;
            gVar.o = j6;
            long j8 = ((j7 * gVar.i) + 500000) / 1000000;
            if (!gVar.p) {
                ArrayList<Long> arrayList = gVar.n;
                arrayList.add(arrayList.size() - 1, Long.valueOf(j8));
                gVar.d += j8;
            }
            gVar.p = false;
        }
        byteBuffer.position(bufferInfo.offset + (z ? 0 : 4));
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        if (!z) {
            this.i.position(0);
            this.i.putInt(bufferInfo.size - 4);
            this.i.position(0);
            this.d.write(this.i);
        }
        this.d.write(byteBuffer);
        this.e += bufferInfo.size;
        if (z2) {
            this.c.flush();
        }
        return z2;
    }
}
