package org.dota2school.mlm.web.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author xujq
 * @time 2017-7-30
 */
@Entity(name="view_s_sign_count")
public class StudentCount {

    @Id
    @Column(name="s_open_id")
    private String sOpenId;

    @Column(name="updatetime")
    private Date updatetime;

    @Column(name="t_teach_time")
    private Date teachTime;

    @Column(name="s_nick_name")
    private String sNickName;

    @Column(name="s_nick_name_p")
    private String sNickNameP;

    @Column(name="s_avatar_url")
    private String sAvatarUrl;

    @Column(name="t_open_id")
    private String tOpenId;

    @Column(name="s_sign_long")
    private double sSignLong;

    @Column(name="sign_times")
    private int signTimes;

    @Column(name = "s_class_type")
    private String sClassType;

    @Column(name="s_class_name")
    private String sClassName;






    @OneToMany(fetch = FetchType.LAZY,targetEntity = AllSign.class)
    @JoinColumn(name = "s_open_id", referencedColumnName = "s_open_id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<AllSign> signData;

    public String getsClassType() {
        return sClassType;
    }

    public void setsClassType(String sClassType) {
        this.sClassType = sClassType;
    }

    public String getsClassName() {
        return sClassName;
    }

    public void setsClassName(String sClassName) {
        this.sClassName = sClassName;
    }

    public String getsOpenId() {
        return sOpenId;
    }

    public void setsOpenId(String sOpenId) {
        this.sOpenId = sOpenId;
    }

    public String getsNickName() {
        return sNickName;
    }

    public void setsNickName(String sNickName) {
        this.sNickName = sNickName;
    }

    public String getsNickNameP() {
        return sNickNameP;
    }

    public void setsNickNameP(String sNickNameP) {
        this.sNickNameP = sNickNameP;
    }

    public String getsAvatarUrl() {
        return sAvatarUrl;
    }

    public void setsAvatarUrl(String sAvatarUrl) {
        this.sAvatarUrl = sAvatarUrl;
    }

    public String gettOpenId() {
        return tOpenId;
    }

    public void settOpenId(String tOpenId) {
        this.tOpenId = tOpenId;
    }

    public double getsSignLong() {
        return sSignLong;
    }

    public void setsSignLong(double sSignLong) {
        this.sSignLong = sSignLong;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getSignTimes() {
        return signTimes;
    }

    public void setSignTimes(int signTimes) {
        this.signTimes = signTimes;
    }

    public List<AllSign> getSignData() {
        return signData;
    }

    public void setSignData(List<AllSign> signData) {
        this.signData = signData;
    }

    public Date getTeachTime() {
        return teachTime;
    }

    public void setTeachTime(Date teachTime) {
        this.teachTime = teachTime;
    }
}
