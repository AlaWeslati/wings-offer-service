package com.wings.wingsofferservice.DTO;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Data
public class DemandDTO {
    private String departGov;
    private String departAdr;
    private String arriGov;
    private String arriAdr;
    private String type;
    private double weight;
    private double height;
    private double length;
    private String remark;
    private long userId;
    private long RouteId;

}
