package com.exampl.communt.mode;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.account_id
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.name
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.token
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.bio
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    private String bio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.avatar_url
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    private String avatarUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.gmt_create
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.gmt_modified
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    private Long gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.account_id
     *
     * @return the value of user_info.account_id
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.account_id
     *
     * @param accountId the value for user_info.account_id
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.name
     *
     * @return the value of user_info.name
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.name
     *
     * @param name the value for user_info.name
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.token
     *
     * @return the value of user_info.token
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.token
     *
     * @param token the value for user_info.token
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.bio
     *
     * @return the value of user_info.bio
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public String getBio() {
        return bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.bio
     *
     * @param bio the value for user_info.bio
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.avatar_url
     *
     * @return the value of user_info.avatar_url
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.avatar_url
     *
     * @param avatarUrl the value for user_info.avatar_url
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.gmt_create
     *
     * @return the value of user_info.gmt_create
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.gmt_create
     *
     * @param gmtCreate the value for user_info.gmt_create
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.gmt_modified
     *
     * @return the value of user_info.gmt_modified
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.gmt_modified
     *
     * @param gmtModified the value for user_info.gmt_modified
     *
     * @mbg.generated Wed Oct 16 13:29:26 CST 2019
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}