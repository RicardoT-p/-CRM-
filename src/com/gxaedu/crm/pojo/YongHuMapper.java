package com.gxaedu.crm.pojo;

import java.util.Map;

public interface YongHuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yonghu
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yonghu
     *
     * @mbg.generated
     */
    int insert(YongHu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yonghu
     *
     * @mbg.generated
     */
    int insertSelective(YongHu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yonghu
     *
     * @mbg.generated
     */
    YongHu selectByPrimaryKey(Map<String, String> map);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yonghu
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(YongHu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yonghu
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(YongHu record);

    YongHu selectByYongHu(String yonghuming);
}