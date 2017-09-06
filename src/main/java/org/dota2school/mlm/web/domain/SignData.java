package org.dota2school.mlm.web.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author xujq
 * @time 2017-7-26
 */
@Entity(name = "view_sign_user")
public class SignData {
    @Id
    @Column(name = "sign_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sign_id; //打卡id

    @Column(name="open_id")
    private String openId; //老师open_id

    @Column(name = "teach_time")
    private String teachTime; //老师教学时常

    @Column(name="teach_date")
    private Date teachDate; //老师教学日期

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

    @Column(name = "nick_name_p")
    private String nickNameP;


    @OneToMany(fetch = FetchType.LAZY,targetEntity = SignStudentUser.class)
    @JoinColumn(name = "sign_id", referencedColumnName = "sign_id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<SignStudentUser> signStudents;


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

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getNickNameP() {
        return nickNameP;
    }

    public void setNickNameP(String nickNameP) {
        this.nickNameP = nickNameP;
    }

    public List<SignStudentUser> getSignStudents() {
        return signStudents;
    }

    public void setSignStudents(List<SignStudentUser> signStudents) {
        this.signStudents = signStudents;
    }
}
