package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Worker {
    private String name;
    private ArrayList<Workday> workdays;
    private int pay;
    private String isActive;



    public Worker(String name, int pay){
        this.name = name;
        this.pay = pay;
        workdays = new ArrayList<Workday>();
        this.isActive = "";
    }
    public String getName(){
        return name;
    }
    public int getPay(){
        return pay;
    }
    public ArrayList<Workday>  getWorkdays(){
        return workdays;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setPay(int p){
        this.pay = p;
    }
    public void setWorkdays(ArrayList<Workday> workdays) {
        this.workdays = workdays;
    }
    public String isActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }

    public int workingDays(){
       return workdays.size();
    }

    public int Salary(){
        int sum = 0;
        double more8 = 0;
        double less8 = 0;
        for (int i = 0;i<workdays.size();i++) {
            if (workdays.get(i).workTime() > 8) {
                more8 = workdays.get(i).workTime() - 8;
                less8 = 8;
            }
            else {
                more8 = 0;
                less8 = workdays.get(i).workTime();
            }

            sum += less8 * getPay();
            sum += more8 * getPay() * 1.25;
        }
             return  sum;
    }
        public Worker diligent(Worker other){
        double name1 = 0;
        double name2 = 0;
        for (int i = 0;i < this.workdays.size();i++) {
            name1 += this.workdays.get(i).workTime();
        }
        for (int i = 0;i<other.workdays.size();i++) {
            name2 += other.workdays.get(i).workTime();
        }
            if (name1 > name2) {
                return this;
            }else {
                return other;
            }
        }

        public double moreH(){
         double more8 = 0;
            for (int i = 0;i<workdays.size();i++) {
                if (workdays.get(i).workTime() > 8) {
                    more8 += workdays.get(i).workTime() - 8;

                }
            }
            return  more8;
        }

    }


