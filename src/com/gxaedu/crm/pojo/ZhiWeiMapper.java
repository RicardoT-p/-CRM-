package com.gxaedu.crm.pojo;

public interface ZhiWeiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zhiwei
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zhiwei
     *
     * @mbg.generated
     */
    int insert(ZhiWei record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zhiwei
     *
     * @mbg.generated
     */
    int insertSelective(ZhiWei record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zhiwei
     *
     * @mbg.generated
     */
    ZhiWei selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zhiwei
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ZhiWei record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zhiwei
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ZhiWei record);
}