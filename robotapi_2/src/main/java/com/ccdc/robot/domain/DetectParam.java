package com.ccdc.robot.domain;

import java.util.ArrayList;
import java.util.List;

public class DetectParam {
    private int LoacationID;
    public int getLoacationID() {
        return LoacationID;
    }
    public void setLoacationID(int loacationID) {
        LoacationID = loacationID;
    }
    public int getItemID() {
        return itemID;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public List<Set_ItemParam> getParams() {
        return params;
    }
    public void setParams(List<Set_ItemParam> params) {
        this.params = params;
    }
    private int itemID;
    private List<Set_ItemParam> params;
}
