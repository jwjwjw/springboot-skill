package com.jw.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

@Validated
@Component
@ConfigurationProperties(prefix="config.person")
public class Person {

    private Map<String, String> maps;
    private List<String> list;
    private String name;
    @Email
    private String email;

    public Map<String, String> getMaps(){
        return maps;
    }
    public void setMaps(Map<String, String> maps){
        this.maps = maps;
    }
    public List<String> getList(){
        return this.list;
    }
    public void setList(List<String> list){
        this.list = list;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getMail(){
        return email;
    }
    public void setMail(String mail){
        this.email = mail;
    }

}
