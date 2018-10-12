package com.hzitxx.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 
 * </p>
 *
 * @author xianyaoji
 * @since 2018-10-08
 */
public class SCity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 城市编号
     */
    private Integer cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 邮编
     */
    private String zipCode;
    /**
     * 所属省份
     */
    private Integer provinceId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
 
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
 
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
 
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
 


    @Override
    public String toString() {
        return "SCity{" +
        "cityId=" + cityId +
        ", cityName=" + cityName +
        ", zipCode=" + zipCode +
        ", provinceId=" + provinceId +
        "}";
    }
}