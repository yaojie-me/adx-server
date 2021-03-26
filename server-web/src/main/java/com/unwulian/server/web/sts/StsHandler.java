package com.unwulian.server.web.sts;

import com.unwulian.server.dispatcher.model.DispatcherRequest;
import com.unwulian.server.dispatcher.model.DispatcherResponse;
import com.unwulian.server.web.handler.IHandler;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * STS 协议处理器
 *
 * @author yaojie
 */
@Component
public class StsHandler implements IHandler<StsRequest, StsResponse> {


    @Override
    public StsResponse convertResponse(DispatcherResponse response) {
        StsResponse stsResponse = new StsResponse();
        stsResponse.setError_code(response.getError_code());
        return stsResponse;
    }


    @Override
    public DispatcherRequest convertRequest(StsRequest request) {
        DispatcherRequest dr = new DispatcherRequest();
        dr.setReq_id(request.getReq_id());
        dr.setImps(request.getImps().stream().map(e -> {
            DispatcherRequest.Imp imp = new DispatcherRequest.Imp();
            imp.setAdslot_id(e.getAdslot_id());
            return imp;
        }).collect(Collectors.toList()));
        DispatcherRequest.Device device = new DispatcherRequest.Device();
        device.setEquipment_id(request.getDevice().getEquipment_id());
        dr.setDevice(device);
        DispatcherRequest.App app = new DispatcherRequest.App();
        app.setApp_id(request.getApp().getApp_id());
        dr.setApp(app);
        return dr;
    }
}
