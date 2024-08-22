package com.ccdc.robot.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TaskResult {
    private Long taskId;
    private Long pointId;
    private Long itemId;
    private Date taskStartTime;
    private Date taskEndTime;
    private Date recordStartTime;
    private Date recordEndTime;
    private Integer code;
    private String msg;
    private Boolean isOver;
    private int rgb_download_id;
    private int heat_download_id;
    private byte[] detectResultRGB;
    private Boolean isDataCall;
    private Boolean CircleCounts;
    
    public Boolean getCircleCounts() {
        return CircleCounts;
    }
    public void setCircleCounts(Boolean circleCounts) {
        CircleCounts = circleCounts;
    }
    public Boolean getIsDataCall() {
        return isDataCall;
    }
    public void setIsDataCall(Boolean isDataCall) {
        this.isDataCall = isDataCall;
    }
    public Map<String, Object> getDetectResultHeat() {
        return detectResultHeat;
    }
    public void setDetectResultHeat(Map<String, Object> detectResultHeat) {
        this.detectResultHeat = detectResultHeat;
    }
    private Map<String, Object> detectResultHeat;
    private List<Integer> ParticleCounter_result;
    public List<Integer> getParticleCounter_result() {
        return ParticleCounter_result;
    }
    public void setParticleCounter_result(List<Integer> particleCounter_result) {
        ParticleCounter_result = particleCounter_result;
    }
    public byte[] getDetectResultRGB() {
        return detectResultRGB;
    }
    public void setDetectResultRGB(byte[] detectResultRGB) {
        this.detectResultRGB = detectResultRGB;
    }
    public int getRgb_download_id() {
        return rgb_download_id;
    }
    public void setRgb_download_id(int rgb_download_id) {
        this.rgb_download_id = rgb_download_id;
    }
    public int getHeat_download_id() {
        return heat_download_id;
    }
    public void setHeat_download_id(int heat_download_id) {
        this.heat_download_id = heat_download_id;
    }
    public double getMaxTemp() {
        return maxTemp;
    }
    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }
    public double getHSV_v() {
        return HSV_v;
    }
    public void setHSV_v(double hSV_v) {
        HSV_v = hSV_v;
    }
    public List<Double[]> getFre() {
        return fre;
    }
    public void setFre(List<Double[]> fre) {
        this.fre = fre;
    }
    public List<Double[]> getWave() {
        return wave;
    }
    public void setWave(List<Double[]> wave) {
        this.wave = wave;
    }
    private double maxTemp;
    private double HSV_v;
    private List<Double[]> fre;
    private List<Double[]> wave; 

    public Boolean getIsOver() {
        return isOver;
    }
    public void setIsOver(Boolean isOver) {
        this.isOver = isOver;
    }
    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public Long getPointId() {
        return pointId;
    }
    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    public Date getTaskStartTime() {
        return taskStartTime;
    }
    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }
    public Date getTaskEndTime() {
        return taskEndTime;
    }
    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
    public Date getRecordStartTime() {
        return recordStartTime;
    }
    public void setRecordStartTime(Date recordStartTime) {
        this.recordStartTime = recordStartTime;
    }
    public Date getRecordEndTime() {
        return recordEndTime;
    }
    public void setRecordEndTime(Date recordEndTime) {
        this.recordEndTime = recordEndTime;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }


}
