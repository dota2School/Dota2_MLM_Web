package org.dota2school.mlm.web.domain;



import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author xujq
 * @time 2017-7-11
 */
@Entity(name = "view_signstudent_user")
@Table(name = "view_signstudent_user")
@IdClass(SignStudentPK.class)
public class SignStudentUser {

    @Id
    @Column(name = "sign_id")
    private int signId;

    @Id
    @Column(name = "open_id")
    private String openId;

    @Column(name = "status")
    private String status;

    @Column(name = "evaluate")
    private String evaluate;

    @Column(name = "updatetime")
    private Date date;

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



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSignId() {
        return signId;
    }

    public void setSignId(int signId) {
        this.signId = signId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
