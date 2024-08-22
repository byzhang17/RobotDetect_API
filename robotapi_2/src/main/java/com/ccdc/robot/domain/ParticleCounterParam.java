package com.ccdc.robot.domain;

public class ParticleCounterParam {
    private String name;
    private int collDuration; //采集时长
    private int collCycles; //循环次数
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCollDuration() {
        return collDuration;
    }
    public void setCollDuration(int collDuration) {
        this.collDuration = collDuration;
    }
    public int getCollCycles() {
        return collCycles;
    }
    public void setCollCycles(int collCycles) {
        this.collCycles = collCycles;
    }
}
