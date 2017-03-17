package com.vinc.domain.redis;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 12:09 2017/3/17
 */
public class Slot {

    private String adId;

    private int materialId;

    private int slotId;

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
}
