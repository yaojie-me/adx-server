package com.unwulian.server.web.sts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StsResponse {

    private String req_id;

    private String error_code;

    private String error_msg;

    private List<Imp> ad_imps;

    @Getter
    @Setter
    public static class Imp {

        private String adslot_id;

        private String material_id;

        private long cpt_deadline;

        private AdTracking ad_tracking;

        // 素材详情

        private String video_url;

        private String video_md5;

        private String image;

        private String image_md5;

        private int width;

        private int height;

        private int duration;

        private int material_type;

        private String source;

    }

    @Getter
    @Setter
    public static class AdTracking {
        //选填    视频开始播放上报地址数组
        private List<String> start_urls;
        //选填    视频播放结束上报地址数组
        private List<String> end_urls;
    }
}
