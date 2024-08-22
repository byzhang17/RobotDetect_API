package com.ccdc.robot.domain;

import java.util.List;

public class TaskParam {
    //回调需要的巡检点ID
    private Long pointId;
    // 地图位置ID
    private Integer locationId;
    //需要执行的操作列表
    private List<TaskItemParam> itemList;

    private ParticleCounterParam ParticleCounter_Param;

    public Long getPointId() {
        return pointId;
    }

    public ParticleCounterParam getParticleCounter_Param() {
        return ParticleCounter_Param;
    }

    public void setParticleCounter_Param(ParticleCounterParam particleCounter_Param) {
        ParticleCounter_Param = particleCounter_Param;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public List<TaskItemParam> getItemList() {
        return itemList;
    }

    public void setItemList(List<TaskItemParam> itemList) {
        this.itemList = itemList;
    }
}
