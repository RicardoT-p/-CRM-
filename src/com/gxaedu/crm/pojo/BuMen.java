package com.gxaedu.crm.pojo;

import java.util.Date;

public class BuMen {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bumen.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bumen.bumenmingcheng
     *
     * @mbg.generated
     */
    private String bumenmingcheng;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bumen.chenglishijian
     *
     * @mbg.generated
     */
    private Date chenglishijian;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bumen.bumenmiaoshu
     *
     * @mbg.generated
     */
    private String bumenmiaoshu;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bumen.id
     *
     * @return the value of bumen.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bumen.id
     *
     * @param id the value for bumen.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bumen.bumenmingcheng
     *
     * @return the value of bumen.bumenmingcheng
     *
     * @mbg.generated
     */
    public String getBumenmingcheng() {
        return bumenmingcheng;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bumen.bumenmingcheng
     *
     * @param bumenmingcheng the value for bumen.bumenmingcheng
     *
     * @mbg.generated
     */
    public void setBumenmingcheng(String bumenmingcheng) {
        this.bumenmingcheng = bumenmingcheng == null ? null : bumenmingcheng.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bumen.chenglishijian
     *
     * @return the value of bumen.chenglishijian
     *
     * @mbg.generated
     */
    public Date getChenglishijian() {
        return chenglishijian;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bumen.chenglishijian
     *
     * @param chenglishijian the value for bumen.chenglishijian
     *
     * @mbg.generated
     */
    public void setChenglishijian(Date chenglishijian) {
        this.chenglishijian = chenglishijian;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bumen.bumenmiaoshu
     *
     * @return the value of bumen.bumenmiaoshu
     *
     * @mbg.generated
     */
    public String getBumenmiaoshu() {
        return bumenmiaoshu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bumen.bumenmiaoshu
     *
     * @param bumenmiaoshu the value for bumen.bumenmiaoshu
     *
     * @mbg.generated
     */
    public void setBumenmiaoshu(String bumenmiaoshu) {
        this.bumenmiaoshu = bumenmiaoshu == null ? null : bumenmiaoshu.trim();
    }
}