package com.company;

import java.util.ArrayList;

public class Company {
private String  name;
ArrayList<Worker> allWorkers;  //רשימת עובדים
ArrayList<Integer> sales;//רשימת מכירות והכנסות

public Company(String name){
    this.name=name;
    allWorkers = new ArrayList<Worker>();
    sales = new ArrayList<Integer>();
}

public int totalPayments(){
    int allPayments = 0;
    for (int i = 0;i<allWorkers.size();i++){
         allPayments +=allWorkers.get(i).Salary();
    }
        return allPayments;
}
public int totalEarnings(){
    int allEarnings = 0 ;
    for (int i = 0;i < sales.size();i++){
        allEarnings+= sales.get(i);
    }
    return allEarnings;
}
public Worker workedMost(){
       Worker max = allWorkers.get(0);
    for(int i = 1;i < allWorkers.size();i++) {
        max = allWorkers.get(i).diligent(max);
    }
    return max;
}
public void  addWorker(Worker w){
    allWorkers.add(w);
}

public void Crisis(){

    double sum = 0.25*allWorkers.size();

    for (int j = 0; j < sum;j++) {
        int indexH  = 0;
        int indexP = 0;
        for (int i = 0; i < allWorkers.size(); i++) {

                if ((allWorkers.get(i).isActive() != "Hour") && (allWorkers.get(i).moreH() > allWorkers.get(indexH).moreH())) {
                    indexH = i;
                }
                if ((allWorkers.get(i).isActive() != "Pay") && (allWorkers.get(i).getPay() > allWorkers.get(indexP).getPay())) {
                    indexP = i;
                }
        }

        allWorkers.get(indexH).setActive("Hour");
        allWorkers.get(indexP).setActive("Pay");
    }

    // delete worker
    for (int i = 0; i < allWorkers.size(); i++) {
        if (allWorkers.get(i).isActive() == "Hour" || allWorkers.get(i).isActive() == "pay") {
            allWorkers.remove(i);
        }
    }
    }
}

