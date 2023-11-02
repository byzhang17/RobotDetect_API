package com.ccdc.robot.domain;

public class TaskItemParam {
    private Long itemId;
    //偏航角
    private Float pan;
    // 倾斜角
    private Float tilt;
    // 光学变焦倍数
    private Float zoom;
    // 停留时间 单位秒
    private Integer residenceTime;
    // 是否拍照 true:拍照  false:不拍照
    private Boolean shotState;
    // 摄像时长 单位秒
    private Integer recordingTime;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Float getPan() {
        return pan;
    }

    public void setPan(Float pan) {
        this.pan = pan;
    }

    public Float getTilt() {
        return tilt;
    }

    public void setTilt(Float tilt) {
        this.tilt = tilt;
    }

    public Float getZoom() {
        return zoom;
    }

    public void setZoom(Float zoom) {
        this.zoom = zoom;
    }

    public Integer getResidenceTime() {
        return residenceTime;
    }

    public void setResidenceTime(Integer residenceTime) {
        this.residenceTime = residenceTime;
    }

    public Boolean getShotState() {
        return shotState;
    }

    public void setShotState(Boolean shotState) {
        this.shotState = shotState;
    }

    public Integer getRecordingTime() {
        return recordingTime;
    }

    public void setRecordingTime(Integer recordingTime) {
        this.recordingTime = recordingTime;
    }
}
