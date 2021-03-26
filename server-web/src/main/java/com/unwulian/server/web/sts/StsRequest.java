package com.unwulian.server.web.sts;


import lombok.Data;

import java.util.List;

@Data
public class StsRequest {

    private String req_id;

    private List<Imp> imps;

    private Device device;

    private App app;

    @Data
    public static class Imp {
        private String adslot_id;
    }

    @Data
    public static class Device {
        private String equipment_id;
    }

    @Data
    public static class App {
        private String app_id;
    }

}
