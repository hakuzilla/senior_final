package com.example.seniorfinal;

import java.io.Serializable;

//model of result table
public class ResultTable implements Serializable {

    //todo read up on serializable
    private String ID;
    private String name;
    private String jpName;
    private String color;
    private int level;
    private int cost;
    private String soul;
    private String effect1;
    private String effect2;
    private String effect3;
    private int power;
    private String rarity;
    private String trigger;
    private String series_name;
    private String series_jpname;
    private String attribute;
    private String type;

    public ResultTable(String id, String name, String jpName, String color, int level,
                       int cost, String soul, String effect1, String effect2, String effect3,
                       int power, String rarity, String trigger, String series_name, String series_jpname,
                       String attribute, String type) {
        this.ID = id;
        this.name = name;
        this.jpName = jpName;
        this.color = color;
        this.level = level;
        this.cost = cost;
        this.soul = soul;
        this.effect1 = effect1;
        this.effect2 = effect2;
        this.effect3 = effect3;
        this.power = power;
        this.rarity = rarity;
        this.trigger = trigger;
        this.series_name = series_name;
        this.series_jpname = series_jpname;
        this.attribute = attribute;
        this.type = type;
    }

    /*
    public ResultTable(String id, String name, String jpName) {
        this.ID = id;
        this.name = name;
        this.jpName = jpName;

    }
    */


    //sanity check message
    public ResultTable(){
    }

    //tostring
    /*
    public String toString() {
        return "resultTable{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", jpName='" + jpName + '\'' +
                '}';
    }
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getJpName() {
        return jpName;
    }

    public void setJpName(String jpName) {
        this.jpName = jpName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getSoul() {
        return soul;
    }

    public void setSoul(String soul) {
        this.soul = soul;
    }

    public String getEffect1() {
        return effect1;
    }

    public void setEffect1(String effect1) {
        this.effect1 = effect1;
    }

    public String getEffect2() {
        return effect2;
    }

    public void setEffect2(String effect2) {
        this.effect2 = effect2;
    }

    public String getEffect3() {
        return effect3;
    }

    public void setEffect3(String effect3) {
        this.effect3 = effect3;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }

    public String getSeries_jpname() {
        return series_jpname;
    }

    public void setSeries_jpname(String series_jpname) {
        this.series_jpname = series_jpname;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

