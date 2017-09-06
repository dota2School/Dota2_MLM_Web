package org.dota2school.mlm.web.domain;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author xujq
 * @time 2017-7-13
 */
@Entity(name = "view_sign_user")
public class SignUser {

    @Id
    @Column(name = "sign_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sign_id;


    @Column(name="open_id")
    private String openId;

    @Column(name = "teach_time")
    private String teachTime;

    @Column(name="teach_date")
    private Date teachDate;

    @Column(name = "teach_time_int")
    private double teachTimeInt;

    @Column(name = "updatetime")
    private Date updateTime;

    @Column(name="avatar_url")
    private String avatarUrl;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name="type")
    private int type;

    @Column(name = "grede")
    private int grede;

    @Column(name="stream_id")
    private String streamId;

    @Column(name = "motton")
    private String motton;

    @Column(name = "rank_score")
    private String rankScore;

    @Column(name = "class_content")
    private String classContent;

    @Column(name = "class_type")
    private String classType;

    @Column(name="class_name")
    private String className;

    @Column(name = "nick_name_p")
    private String nickNameP;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSign_id() {
        return sign_id;
    }

    public void setSign_id(int sign_id) {
        this.sign_id = sign_id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTeachTime() {
        return teachTime;
    }

    public void setTeachTime(String teachTime) {
        this.teachTime = teachTime;
    }

    public Date getTeachDate() {
        return teachDate;
    }

    public void setTeachDate(Date teachDate) {
        this.teachDate = teachDate;
    }

    public double getTeachTimeInt() {
        return teachTimeInt;
    }

    public void setTeachTimeInt(double teachTimeInt) {
        this.teachTimeInt = teachTimeInt;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
