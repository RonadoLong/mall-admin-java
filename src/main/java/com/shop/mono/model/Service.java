package com.shop.mono.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "service")
public class Service {

    @Id
    public String id;
    public String classname;
    public String userId;
    public String name;
    public String tel;
    public String state;
    public String city;
    public List<String> banner;
    public String note;
    public String email;
    public String language;
    public String type;
    public String status; // 0 未支付  1 已支付/在线  2 已过期
    public Date update_at;
    public Date create_at;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getBanner() {
        return banner;
    }

    public void setBanner(List<String> banner) {
        this.banner = banner;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}
/**
 Id           bson.ObjectId `bson:"_id,omitempty" json:"id"`
 Category     int           `json:"category"`
 UserId       string        `json:"userId"`
 Username     string        `json:"username"`
 ContactPhone string        `json:"contactPhone"`
 State        string        `json:"state"`
 City         string        `json:"city"`
 Address      string        `json:"address"`
 Area         string        `json:"area"`
 Code         string        `json:"code"`
 Location     GeoJson       `json:"location"`
 Pics         []string      `json:"pics"`
 Title        string        `json:"title"`
 Price        int           `json:"price"`
 DescStr      string        `json:"descStr"`
 Language     string        `json:"language"`
 Type         string        `json:"type"`
 Distance     float64       `bson:"distance" json:"distance"`
 Status       int           `json:"status"`
 UpdateAt     time.Time     `json:"updateAt"`
 CreateAt     time.Time     `json:"createAt"`
 LeaseType int      `json:"leaseType"`
 RoomType  []string `json:"roomType"`

 */