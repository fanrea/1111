package lkxssdk.u;

import android.media.MediaFormat;
import com.coremedia.iso.boxes.AbstractMediaHeaderBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.AudioSpecificConfig;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import com.kwai.video.player.misc.IMediaFormat;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import com.pandora.common.Constants;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class g {
    public static Map<Integer, Integer> a;
    public long b;
    public long d;
    public String e;
    public AbstractMediaHeaderBox f;
    public SampleDescriptionBox g;
    public LinkedList<Integer> h;
    public int i;
    public int k;
    public int l;
    public float m;
    public ArrayList<Long> n;
    public long o;
    public boolean p;
    public ArrayList<e> c = new ArrayList<>();
    public Date j = new Date();

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(96000, 0);
        a.put(88200, 1);
        a.put(64000, 2);
        a.put(48000, 3);
        a.put(44100, 4);
        a.put(32000, 5);
        a.put(24000, 6);
        a.put(22050, 7);
        a.put(16000, 8);
        a.put(Integer.valueOf(AVMDLDataLoader.KeyIsFileKeyRule), 9);
        a.put(11025, 10);
        a.put(8000, 11);
    }

    public g(int i, MediaFormat mediaFormat, boolean z) {
        this.b = 0L;
        this.d = 0L;
        this.f = null;
        this.g = null;
        this.h = null;
        this.m = 0.0f;
        ArrayList<Long> arrayList = new ArrayList<>();
        this.n = arrayList;
        this.o = 0L;
        this.p = true;
        this.b = i;
        if (z) {
            arrayList.add(1024L);
            this.d = 1024L;
            this.m = 1.0f;
            this.i = mediaFormat.getInteger("sample-rate");
            this.e = "soun";
            this.f = new SoundMediaHeaderBox();
            this.g = new SampleDescriptionBox();
            AudioSampleEntry audioSampleEntry = new AudioSampleEntry("mp4a");
            audioSampleEntry.setChannelCount(mediaFormat.getInteger("channel-count"));
            audioSampleEntry.setSampleRate(mediaFormat.getInteger("sample-rate"));
            audioSampleEntry.setDataReferenceIndex(1);
            audioSampleEntry.setSampleSize(16);
            ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
            ESDescriptor eSDescriptor = new ESDescriptor();
            eSDescriptor.setEsId(0);
            SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
            sLConfigDescriptor.setPredefined(2);
            eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
            DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
            decoderConfigDescriptor.setObjectTypeIndication(64);
            decoderConfigDescriptor.setStreamType(5);
            decoderConfigDescriptor.setBufferSizeDB(1536);
            decoderConfigDescriptor.setMaxBitRate(96000L);
            decoderConfigDescriptor.setAvgBitRate(96000L);
            AudioSpecificConfig audioSpecificConfig = new AudioSpecificConfig();
            audioSpecificConfig.setAudioObjectType(2);
            audioSpecificConfig.setSamplingFrequencyIndex(a.get(Integer.valueOf((int) audioSampleEntry.getSampleRate())).intValue());
            audioSpecificConfig.setChannelConfiguration(audioSampleEntry.getChannelCount());
            decoderConfigDescriptor.setAudioSpecificInfo(audioSpecificConfig);
            eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
            ByteBuffer byteBufferSerialize = eSDescriptor.serialize();
            eSDescriptorBox.setEsDescriptor(eSDescriptor);
            eSDescriptorBox.setData(byteBufferSerialize);
            audioSampleEntry.addBox(eSDescriptorBox);
            this.g.addBox(audioSampleEntry);
            return;
        }
        arrayList.add(3015L);
        this.d = 3015L;
        this.l = mediaFormat.getInteger("width");
        this.k = mediaFormat.getInteger("height");
        this.i = 90000;
        this.h = new LinkedList<>();
        this.e = "vide";
        this.f = new VideoMediaHeaderBox();
        this.g = new SampleDescriptionBox();
        String string = mediaFormat.getString(IMediaFormat.KEY_MIME);
        if (!string.equals(Constants.CodecType.VIDEO_H264)) {
            if (string.equals("video/mp4v")) {
                VisualSampleEntry visualSampleEntry = new VisualSampleEntry("mp4v");
                visualSampleEntry.setDataReferenceIndex(1);
                visualSampleEntry.setDepth(24);
                visualSampleEntry.setFrameCount(1);
                visualSampleEntry.setHorizresolution(72.0d);
                visualSampleEntry.setVertresolution(72.0d);
                visualSampleEntry.setWidth(this.l);
                visualSampleEntry.setHeight(this.k);
                this.g.addBox(visualSampleEntry);
                return;
            }
            return;
        }
        VisualSampleEntry visualSampleEntry2 = new VisualSampleEntry("avc1");
        visualSampleEntry2.setDataReferenceIndex(1);
        visualSampleEntry2.setDepth(24);
        visualSampleEntry2.setFrameCount(1);
        visualSampleEntry2.setHorizresolution(72.0d);
        visualSampleEntry2.setVertresolution(72.0d);
        visualSampleEntry2.setWidth(this.l);
        visualSampleEntry2.setHeight(this.k);
        AvcConfigurationBox avcConfigurationBox = new AvcConfigurationBox();
        if (mediaFormat.getByteBuffer("csd-0") != null) {
            ArrayList arrayList2 = new ArrayList();
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
            byteBuffer.position(4);
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            arrayList2.add(bArr);
            ArrayList arrayList3 = new ArrayList();
            ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer("csd-1");
            byteBuffer2.position(4);
            byte[] bArr2 = new byte[byteBuffer2.remaining()];
            byteBuffer2.get(bArr2);
            arrayList3.add(bArr2);
            avcConfigurationBox.setSequenceParameterSets(arrayList2);
            avcConfigurationBox.setPictureParameterSets(arrayList3);
        }
        avcConfigurationBox.setAvcLevelIndication(13);
        avcConfigurationBox.setAvcProfileIndication(100);
        avcConfigurationBox.setBitDepthLumaMinus8(-1);
        avcConfigurationBox.setBitDepthChromaMinus8(-1);
        avcConfigurationBox.setChromaFormat(-1);
        avcConfigurationBox.setConfigurationVersion(1);
        avcConfigurationBox.setLengthSizeMinusOne(3);
        avcConfigurationBox.setProfileCompatibility(0);
        visualSampleEntry2.addBox(avcConfigurationBox);
        this.g.addBox(visualSampleEntry2);
    }
}
