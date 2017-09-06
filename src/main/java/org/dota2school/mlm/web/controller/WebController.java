package org.dota2school.mlm.web.controller;


import org.dota2school.mlm.web.domain.*;
import org.dota2school.mlm.web.model.QuerySignResult;
import org.dota2school.mlm.web.model.QueryStudentCountResponse;
import org.dota2school.mlm.web.model.QueryUserResult;
import org.dota2school.mlm.web.model.TeacherCountResult;
import org.dota2school.mlm.web.respository.*;
import org.dota2school.mlm.web.util.G;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xujq
 * @time 2017-7-26
 */
@RestController
@RequestMapping("/api/web")
public class WebController {
    public static final Logger LOG = LoggerFactory.getLogger(WebController.class);

    public static final ThreadLocal<DateFormat> formate =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    @Autowired
    private UserRespository userRespository;


    @Autowired
    private SignStudentRespository signStudentRespository;

    @Autowired
    private SignDataRespository signDataRespository;

    @Autowired
    private ViewAllRespository viewAllRespository;

    @Autowired
    private TeacherCountRespository teacherCountRespository;

    @Autowired
    private StudentCountRespository studentCountRespository;

    @RequestMapping(value = "/user",method = {RequestMethod.GET,RequestMethod.POST})
    public String user(
            @RequestParam(name = "start_update_time", required = false) String startUpdateTime,
            @RequestParam(name = "end_update_time", required = false) String endUpdateTime,
            @RequestParam(name = "open_id", required = false) String openId,
            @RequestParam(name = "nick_name_p", required = false) String pNickName, //微信昵称
            @RequestParam(name = "nick_name", required = false) String nickName,
            @RequestParam(name = "type", required = false) String type, //类型
            @RequestParam(name = "class_type", required = false) String classType, // 班级类型
            @RequestParam(name = "class_name", required = false) String className,
            @RequestParam(name = "page_size", required = false) String pageSize,
            @RequestParam(name = "page_num", required = false) String pageNum) {

        QueryUserResult queryUserResult = new QueryUserResult();
        try {
            Specification<User> specification = (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicateList = new ArrayList<>();
                if (startUpdateTime != null && !startUpdateTime.isEmpty()) {
                   try{
                       Date start = formate.get().parse(startUpdateTime);
                       predicateList.add(criteriaBuilder
                               .greaterThan(root.get("updateTime").as(Date.class), start));
                   }catch (ParseException ex){
                       LOG.warn("Failed parse date");
                   }
                }
                if (endUpdateTime != null && !endUpdateTime.isEmpty()) {
                    try{
                        Date end = formate.get().parse(endUpdateTime);
                        predicateList.add(criteriaBuilder
                                .lessThan(root.get("updateTime").as(Date.class), end));
                    }catch (Exception ex){
                        LOG.warn("Failed parse!");
                    }
                }
                if (openId != null && !openId.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("openId").as(String.class), openId));
                }
                if (pNickName != null && !pNickName.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("nickNameP").as(String.class), pNickName));
                }
                if (nickName != null && !nickName.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("nickName").as(String.class), nickName));
                }
                if (type != null && !type.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("type").as(Integer.class), Integer.parseInt(type)));
                }
                if (classType != null && !classType.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("classType").as(String.class), classType));
                }

                if (className != null && !className.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("className").as(String.class), className));
                }
                if (!predicateList.isEmpty()) {
                    Predicate[] predicates = new Predicate[predicateList.size()];
                    criteriaQuery.where(predicateList.toArray(predicates));
                }
                return criteriaQuery.getRestriction();
            };
            Sort sort = new Sort(Sort.Direction.DESC, "updateTime");
            Pageable pageable = new PageRequest(Integer.parseInt(pageNum == null ? "0" : pageNum), Integer.parseInt(pageSize == null ? "25" : pageSize), sort);
            Page<User> page = userRespository.findAll(specification, pageable);
            queryUserResult.setTotal((int) page.getTotalElements());
            queryUserResult.setRows(page.getContent());
            queryUserResult.setSucess(1);
        } catch (Exception ex) {
            queryUserResult.setSucess(-1);
        }
        return G.gson.toJson(queryUserResult);
    }


    @RequestMapping(value="/sign",method = {RequestMethod.GET,RequestMethod.POST})
    public String sign(
            @RequestParam(name = "start_sign_time", required = false) String startSignTime,
            @RequestParam(name = "end_sign_time", required = false) String endSignTime,
            @RequestParam(name = "open_id", required = false) String openId,
            @RequestParam(name = "nick_name_p", required = false) String pNickName,
            @RequestParam(name = "nick_name", required = false) String nickName,
            @RequestParam(name = "class_type", required = false) String classType,
            @RequestParam(name = "class_name", required = false) String className,
            @RequestParam(name = "page_size", required = false) String pageSize,
            @RequestParam(name = "page_num", required = false) String pageNum) {
        QuerySignResult querySignResult = new QuerySignResult();
        try {
            Specification<AllSign> specification = (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicateList = new ArrayList<>();
                if (startSignTime != null && !startSignTime.isEmpty()) {
                   try{
                       Date start = formate.get().parse(startSignTime);
                       predicateList.add(criteriaBuilder
                               .greaterThan(root.get("tUpdateTime").as(Date.class), start));
                   }catch (ParseException ex){
                       LOG.warn("Failed parse time ");
                   }
                }
                if (endSignTime != null && !endSignTime.isEmpty()) {
                    try{
                        Date end = formate.get().parse(endSignTime);
                        predicateList.add(criteriaBuilder
                                .lessThan(root.get("tUpdateTime").as(Date.class), end));
                    }catch (ParseException ex){
                        LOG.warn("Failed parse time");
                    }
                }
                if (openId != null && !openId.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tOpenId").as(String.class), openId));
                }
                if (pNickName != null && !pNickName.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tNickNameP").as(String.class), pNickName));
                }
                if (nickName != null && !nickName.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tNickName").as(String.class), nickName));
                }
                if (classType != null && !classType.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tClassType").as(String.class), classType));
                }
                if (className != null && !className.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tClassName").as(String.class), className));
                }
                predicateList.add(criteriaBuilder.isNotNull(root.get("sOpenId")));
                if (!predicateList.isEmpty()) {
                    Predicate[] predicates = new Predicate[predicateList.size()];
                    criteriaQuery.where(predicateList.toArray(predicates));
                }
                return criteriaQuery.getRestriction();
            };
            Sort sort = new Sort(Sort.Direction.DESC, "tUpdateTime");
            Pageable pageable = new PageRequest(Integer.parseInt(pageNum == null ? "0" : pageNum), Integer.parseInt(pageSize == null ? "25" : pageSize), sort);
            Page<AllSign> page = viewAllRespository.findAll(specification, pageable);
            querySignResult.setTotal((int) page.getTotalElements());
            querySignResult.setRows(page.getContent());
            querySignResult.setSucess(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            querySignResult.setSucess(-1);
        }
        return G.gson.toJson(querySignResult);
    }


    @RequestMapping(value="/teacher/count",method = {RequestMethod.GET,RequestMethod.POST})
    public String teacherSignRanking(
            @RequestParam(name = "start_time",required = false) String startTime,
            @RequestParam(name = "end_time",required = false) String endTime,
            @RequestParam(name = "nick_name_p", required = false) String pNickName,
            @RequestParam(name = "nick_name", required = false) String nickName,
            @RequestParam(name = "class_type", required = false) String classType,
            @RequestParam(name = "class_name", required = false) String className,
            @RequestParam(name="order",required = false)String order,
            @RequestParam(name="orderType",required = false)String orderType,
            @RequestParam(name="pageNum",required = false)String pageNum) {
        TeacherCountResult teacherCount  = new TeacherCountResult();

        try{
            Specification<TeacherCount> specification = (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicateList = new ArrayList<>();
                if (startTime != null && !startTime.isEmpty()) {
                    try{
                        Date start = formate.get().parse(startTime);
                        predicateList.add(criteriaBuilder
                                .greaterThan(root.get("updateTime").as(Date.class), start));
                    }catch (ParseException ex){
                        LOG.warn("Failed parse time  ");
                    }
                }
                if (endTime != null && !endTime.isEmpty()) {
                    try{
                        Date end = formate.get().parse(endTime);
                        predicateList.add(criteriaBuilder
                                .lessThan(root.get("updateTime").as(Date.class), end));
                    }catch (ParseException ex){
                        LOG.warn("Failed parse time ");
                    }
                }
                if (pNickName != null && !pNickName.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tNickNameP").as(String.class), pNickName));
                }
                if (nickName != null && !nickName.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tNickName").as(String.class), nickName));
                }
                if (classType != null && !classType.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("classType").as(String.class), classType));
                }
                if (className != null && !className.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("className").as(String.class), className));
                }
                if (!predicateList.isEmpty()) {
                    Predicate[] predicates = new Predicate[predicateList.size()];
                    criteriaQuery.where(predicateList.toArray(predicates));
                }
                return criteriaQuery.getRestriction();
            };
            if(order == null || order.isEmpty()){
                order = "signTimes";
            }
            Sort.Direction direction;
            if(orderType == null || orderType.isEmpty()|| orderType.equals("asc")){
                direction  = Sort.Direction.ASC;
            }else{
                direction = Sort.Direction.DESC;
            }
            Sort sort = new Sort(direction, order);
            Pageable pageable = new PageRequest(Integer.parseInt(pageNum == null ? "0" : pageNum), 25, sort);
            Page<TeacherCount> page = teacherCountRespository.findAll(specification, pageable);
            teacherCount.setSucess(1);
            teacherCount.setTotal((int)page.getTotalElements());
            teacherCount.setRows(page.getContent());
        }catch (Exception ex){
            ex.printStackTrace();
            teacherCount.setSucess(-1);
            teacherCount.setErrorMessage(ex.getMessage());
        }
        return G.gson.toJson(teacherCount);
    }


    @RequestMapping("/student/count")
    public String studentSignRanking(@RequestParam(name = "startTime",required = false) String startTime,
                                     @RequestParam(name = "endTime",required = false) String endTime,
                                     @RequestParam(name = "nick_name_p", required = false) String pNickName,
                                     @RequestParam(name = "nick_name", required = false) String nickName,
                                     @RequestParam(name = "class_type", required = false) String classType,
                                     @RequestParam(name = "class_name", required = false) String className,
                                     @RequestParam(name = "pageSize",required = false)String pageSize,
                                     @RequestParam(name = "pageNum",required = false)String pageNum,
                                     @RequestParam(name = "order",required = false)String order,
                                     @RequestParam(name="orderType",required = false)String orderType) {

        QueryStudentCountResponse response = new QueryStudentCountResponse();

        try{
            Specification<StudentCount> specification = (root, criteriaQuery, criteriaBuilder) ->{
                List<Predicate> predicateList = new ArrayList<>();
                if (startTime != null && !startTime.isEmpty()) {
                    try{
                        Date start = formate.get().parse(startTime);
                        predicateList.add(criteriaBuilder
                                .greaterThan(root.get("updatetime").as(Date.class), start));
                    }catch (ParseException ex){
                        LOG.warn("Failed parse  time  ");
                    }
                }
                if (endTime != null && !endTime.isEmpty()) {
                    try{
                        Date end = formate.get().parse(endTime);
                        predicateList.add(criteriaBuilder
                                .lessThan(root.get("updatetime").as(Date.class), end));
                    }catch (ParseException ex){
                        LOG.warn("Failed  parse time ");
                    }
                }
                if (pNickName != null && !pNickName.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tNickNameP").as(String.class), pNickName));
                }
                if (nickName != null && !nickName.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("tNickName").as(String.class), nickName));
                }
                if (classType != null && !classType.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("sClassType").as(String.class), classType));
                }
                if (className != null && !className.isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("sClassName").as(String.class), className));
                }
                if (!predicateList.isEmpty()) {
                    Predicate[] predicates = new Predicate[predicateList.size()];
                    criteriaQuery.where(predicateList.toArray(predicates));
                }
                return criteriaQuery.getRestriction();
            };

            Sort.Direction direction;
            if(orderType == null || orderType.isEmpty()|| orderType.equals("asc")){
                direction  = Sort.Direction.ASC;
            }else{
                direction = Sort.Direction.DESC;
            }
            if(order == null || order.isEmpty()){
                order = "signTimes";
            }
            Sort sort = new Sort(direction, order);
            Pageable pageable = new PageRequest(Integer.parseInt(pageNum == null ? "0" : pageNum), 25, sort);
            Page<StudentCount> page = studentCountRespository.findAll(specification, pageable);
            response.setTotal(page.getTotalElements());
            response.setSucess(1);
            response.setRows(page.getContent());
        }catch (Exception ex){
            response.setSucess(-1);
            response.setErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
        return G.gson.toJson(response);
    }


}
