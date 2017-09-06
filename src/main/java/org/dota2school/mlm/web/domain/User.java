package org.dota2school.mlm.web.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author xujq
 * @time 2017-7-10
 */
@Entity(name = "USER")
public class User {

    @Id
    @Column(name = "open_id")
    private String openId;

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

    @Column(name="update_time")
    private Date updateTime;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNickNameP() {
        return nickNameP;
    }

    public void setNickNameP(String nickNameP) {
        this.nickNameP = nickNameP;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getRankScore() {
        return rankScore;
    }

    public void setRankScore(String rankScore) {
        this.rankScore = rankScore;
    }

    public String getClassContent() {
        return classContent;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGrede() {
        return grede;
    }

    public void setGrede(int grede) {
        this.grede = grede;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getMotton() {
        return motton;
    }

    public void setMotton(String motton) {
        this.motton = motton;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "openId='" + openId + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", type=" + type +
                ", grede=" + grede +
                ", streamId='" + streamId + '\'' +
                ", motton='" + motton + '\'' +
                ", updateTime=" + updateTime +
                ", rankScore='" + rankScore + '\'' +
                ", classContent='" + classContent + '\'' +
                ", classType='" + classType + '\'' +
                '}';
    }
}
