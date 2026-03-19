package com.lingku.xuanshang.silicompressorr.videocompression;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import lkxssdk.u.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MediaController {
    public static File a;
    public static Context b;
    public static volatile MediaController c;
    public String d;
    public boolean e = true;

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.media.MediaCodecInfo r5, java.lang.String r6) {
        /*
            android.media.MediaCodecInfo$CodecCapabilities r6 = r5.getCapabilitiesForType(r6)
            r0 = 0
            r1 = r0
            r2 = r1
        L7:
            int[] r3 = r6.colorFormats
            int r4 = r3.length
            if (r1 >= r4) goto L36
            r3 = r3[r1]
            r4 = 39
            if (r3 == r4) goto L1c
            r4 = 2130706688(0x7f000100, float:1.7014638E38)
            if (r3 == r4) goto L1c
            switch(r3) {
                case 19: goto L1c;
                case 20: goto L1c;
                case 21: goto L1c;
                default: goto L1a;
            }
        L1a:
            r4 = r0
            goto L1d
        L1c:
            r4 = 1
        L1d:
            if (r4 == 0) goto L33
            java.lang.String r2 = r5.getName()
            java.lang.String r4 = "OMX.SEC.AVC.Encoder"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L32
            r2 = 19
            if (r3 == r2) goto L30
            goto L32
        L30:
            r2 = r3
            goto L33
        L32:
            return r3
        L33:
            int r1 = r1 + 1
            goto L7
        L36:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.silicompressorr.videocompression.MediaController.a(android.media.MediaCodecInfo, java.lang.String):int");
    }

    public static MediaCodecInfo a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        if (!codecInfoAt.getName().equals("OMX.SEC.avc.enc") || codecInfoAt.getName().equals("OMX.SEC.AVC.Encoder")) {
                            return codecInfoAt;
                        }
                        mediaCodecInfo = codecInfoAt;
                    }
                }
            }
        }
        return mediaCodecInfo;
    }

    public static native int convertVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3, int i4, int i5);

    public final int a(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString(IMediaFormat.KEY_MIME);
            if (z) {
                if (string.startsWith("audio/")) {
                    return i;
                }
            } else if (string.startsWith("video/")) {
                return i;
            }
        }
        return -5;
    }

    public final long a(MediaExtractor mediaExtractor, b bVar, MediaCodec.BufferInfo bufferInfo, long j, long j2, boolean z) throws IOException {
        long j3;
        boolean z2;
        int iA = a(mediaExtractor, z);
        if (iA < 0) {
            return -1L;
        }
        mediaExtractor.selectTrack(iA);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iA);
        int iA2 = bVar.a(trackFormat, z);
        int integer = trackFormat.getInteger("max-input-size");
        long j4 = 0;
        if (j > 0) {
            mediaExtractor.seekTo(j, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(integer);
        long j5 = -1;
        boolean z3 = false;
        while (!z3) {
            int sampleTrackIndex = mediaExtractor.getSampleTrackIndex();
            if (sampleTrackIndex == iA) {
                int sampleData = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                bufferInfo.size = sampleData;
                if (sampleData < 0) {
                    bufferInfo.size = 0;
                    j3 = j4;
                } else {
                    long sampleTime = mediaExtractor.getSampleTime();
                    bufferInfo.presentationTimeUs = sampleTime;
                    if (j > 0 && j5 == -1) {
                        j5 = sampleTime;
                    }
                    j3 = 0;
                    if (j2 < 0 || sampleTime < j2) {
                        bufferInfo.offset = 0;
                        bufferInfo.flags = mediaExtractor.getSampleFlags();
                        bVar.a(iA2, byteBufferAllocateDirect, bufferInfo, z);
                        mediaExtractor.advance();
                    }
                }
            } else {
                j3 = j4;
                z2 = sampleTrackIndex == -1;
            }
            j4 = j3;
            if (z2) {
                z3 = true;
            }
        }
        mediaExtractor.unselectTrack(iA);
        return j5;
    }

    public String a(File file) throws IOException {
        if (Build.VERSION.SDK_INT < 29) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath() + "/VIDEO_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".mp4";
        }
        File file2 = new File(b.getExternalFilesDir(Environment.DIRECTORY_MOVIES), new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".mp4");
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!file2.mkdirs()) {
            Log.e("Sili", "Directory not created");
        }
        return file2.getPath();
    }

    public final void a() {
        if (this.e) {
            this.e = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0221 A[Catch: all -> 0x0203, Exception -> 0x020b, PHI: r30
  0x0221: PHI (r30v3 java.lang.String) = (r30v2 java.lang.String), (r30v21 java.lang.String) binds: [B:102:0x01e3, B:121:0x021f] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #15 {Exception -> 0x020b, blocks: (B:125:0x0231, B:130:0x024f, B:134:0x0266, B:135:0x0272, B:122:0x0221, B:108:0x01f0, B:110:0x01fc, B:120:0x0219), top: B:503:0x01dd }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02d1 A[Catch: all -> 0x0203, Exception -> 0x0638, TRY_ENTER, TryCatch #31 {Exception -> 0x0638, blocks: (B:156:0x02bd, B:159:0x02d1, B:161:0x02dd), top: B:523:0x02bd }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x034d A[Catch: all -> 0x0203, Exception -> 0x0367, TryCatch #9 {Exception -> 0x0367, blocks: (B:171:0x02fe, B:173:0x0304, B:175:0x030a, B:177:0x0310, B:179:0x0317, B:181:0x031e, B:188:0x034d, B:190:0x0356, B:182:0x0330, B:178:0x0313, B:201:0x0387, B:207:0x039d, B:209:0x03a3, B:212:0x03ab, B:214:0x03b2, B:220:0x03cc, B:223:0x03d2, B:227:0x03db, B:230:0x03e2, B:234:0x03e9, B:236:0x03ef, B:240:0x03f7, B:248:0x0416, B:250:0x041a, B:252:0x0420, B:254:0x0426, B:225:0x03d5), top: B:495:0x02fe }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0373 A[ADDED_TO_REGION, EDGE_INSN: B:197:0x0373->B:564:0x0376 BREAK  A[LOOP:1: B:196:0x0371->B:567:0x0371]] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x05b9 A[PHI: r10 r15 r30 r35
  0x05b9: PHI (r10v76 java.lang.String) = (r10v78 java.lang.String), (r10v80 java.lang.String), (r10v80 java.lang.String) binds: [B:280:0x049e, B:333:0x0588, B:291:0x04da] A[DONT_GENERATE, DONT_INLINE]
  0x05b9: PHI (r15v65 java.lang.String) = (r15v66 java.lang.String), (r15v68 java.lang.String), (r15v70 java.lang.String) binds: [B:280:0x049e, B:333:0x0588, B:291:0x04da] A[DONT_GENERATE, DONT_INLINE]
  0x05b9: PHI (r30v12 boolean) = (r30v13 boolean), (r30v17 boolean), (r30v20 boolean) binds: [B:280:0x049e, B:333:0x0588, B:291:0x04da] A[DONT_GENERATE, DONT_INLINE]
  0x05b9: PHI (r35v9 lkxssdk.u.a) = (r35v7 lkxssdk.u.a), (r35v16 lkxssdk.u.a), (r35v7 lkxssdk.u.a) binds: [B:280:0x049e, B:333:0x0588, B:291:0x04da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097 A[Catch: FileNotFoundException -> 0x0832, TRY_ENTER, TryCatch #21 {FileNotFoundException -> 0x0832, blocks: (B:38:0x0097, B:39:0x00a6, B:41:0x00b3, B:40:0x00ab), top: B:513:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x069c A[Catch: all -> 0x06b5, Exception -> 0x06b7, TryCatch #48 {Exception -> 0x06b7, all -> 0x06b5, blocks: (B:392:0x0697, B:394:0x069c, B:396:0x06a1, B:398:0x06a6, B:400:0x06ae), top: B:551:0x0697 }] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x06a1 A[Catch: all -> 0x06b5, Exception -> 0x06b7, TryCatch #48 {Exception -> 0x06b7, all -> 0x06b5, blocks: (B:392:0x0697, B:394:0x069c, B:396:0x06a1, B:398:0x06a6, B:400:0x06ae), top: B:551:0x0697 }] */
    /* JADX WARN: Removed duplicated region for block: B:398:0x06a6 A[Catch: all -> 0x06b5, Exception -> 0x06b7, TryCatch #48 {Exception -> 0x06b7, all -> 0x06b5, blocks: (B:392:0x0697, B:394:0x069c, B:396:0x06a1, B:398:0x06a6, B:400:0x06ae), top: B:551:0x0697 }] */
    /* JADX WARN: Removed duplicated region for block: B:400:0x06ae A[Catch: all -> 0x06b5, Exception -> 0x06b7, TRY_LEAVE, TryCatch #48 {Exception -> 0x06b7, all -> 0x06b5, blocks: (B:392:0x0697, B:394:0x069c, B:396:0x06a1, B:398:0x06a6, B:400:0x06ae), top: B:551:0x0697 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab A[Catch: FileNotFoundException -> 0x0832, TryCatch #21 {FileNotFoundException -> 0x0832, blocks: (B:38:0x0097, B:39:0x00a6, B:41:0x00b3, B:40:0x00ab), top: B:513:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0789  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x07ff  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x04a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:507:0x078e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0804 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:519:0x058a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:560:0x0632 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:565:0x049d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.content.Context r41, android.net.Uri r42, java.lang.String r43, java.io.File r44, int r45, int r46, int r47) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2108
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.silicompressorr.videocompression.MediaController.a(android.content.Context, android.net.Uri, java.lang.String, java.io.File, int, int, int):boolean");
    }
}
