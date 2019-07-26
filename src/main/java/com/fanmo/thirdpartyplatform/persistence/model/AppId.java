package com.fanmo.thirdpartyplatform.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@ApiModel(value = "Appid" ,description="用户第三方平台账户信息")
@Entity
@Table(name = "appid")
public class AppId {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;


    @ApiModelProperty(value="B端药师账号")
    @Column(name = "b_username")
    private String bUsername;

    @ApiModelProperty(value="C端用户账号，由B端药师设置")
    private String username;

    @ApiModelProperty(value="C端用户密码，由B端药师设置")
    private String password;

    @ApiModelProperty(value="微信公众平台名称", example = "智联药师")
    @Column(name = "platform_name")
    private String platformName;

    @ApiModelProperty(value="微信公众平台appid", example = "wx2d4a7f1d91e9f4a9")
    @Column(name = "platform_appid")
    private String platformAppid;

    @ApiModelProperty(value="微信公众平台appsecret", example = "wx2d4a7f1d91e9f4a9")
    @Column(name = "platform_secret")
    private String platformSecret;

    @ApiModelProperty(value="小程序名称", example = "愉康大药房")
    @Column(name = "minipro_name")
    private String miniproName;

    @ApiModelProperty(value="小程序appid", example = "wxd2e723b25ce857f3")
    @Column(name = "minipro_appid")
    private String miniproAppid;

    @ApiModelProperty(value="小程序秘钥", example = "0502761920c56be33ee188fdf93f97d4")
    @Column(name = "minipro_secret")
    private String miniproSecret;

    @ApiModelProperty(value="商户号", example = "1494356602")
    @Column(name = "merchant_no")
    private String merchantNo;

    @ApiModelProperty(value="商户API秘钥", example = "YKDYF1331688011913316880119YKDYF")
    @Column(name = "merchant_secret")
    private String merchantSecret;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getbUsername() {
        return bUsername;
    }

    public void setbUsername(String bUsername) {
        this.bUsername = bUsername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformAppid() {
        return platformAppid;
    }

    public String getPlatformSecret() {
        return platformSecret;
    }

    public void setPlatformSecret(String platformSecret) {
        this.platformSecret = platformSecret;
    }


    public void setPlatformAppid(String platformAppid) {
        this.platformAppid = platformAppid;
    }

    public String getMiniproName() {
        return miniproName;
    }

    public void setMiniproName(String miniproName) {
        this.miniproName = miniproName;
    }

    public String getMiniproAppid() {
        return miniproAppid;
    }

    public void setMiniproAppid(String miniproAppid) {
        this.miniproAppid = miniproAppid;
    }

    public String getMiniproSecret() {
        return miniproSecret;
    }

    public void setMiniproSecret(String miniproSecret) {
        this.miniproSecret = miniproSecret;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantSecret() {
        return merchantSecret;
    }

    public void setMerchantSecret(String merchantSecret) {
        this.merchantSecret = merchantSecret;
    }
}
