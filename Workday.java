package com.company;


public class Workday {
    private Date date;//07/08/2021
    private Time start;
    private Time end;

    public Workday(Date date){
          this.date=date;
          start = new Time(9,00);
          end  = new Time(17,00);
    }
    public Date getDate(){
        return date;
    }

    public Time getStart(){
        return start;
    }

    public Time getEnd(){
        return end;
    }

    public void setDate(Date b){
        this.date=b;
    }

    public void setStart(Time s){
        this.start=s;
    }

    public void setEnd(Time e){
        this.end=e;
    }
//מחשב את השעות העבודה

    public double workTime(){ Time sum = new Time(end.hour - start.hour,
               end.minute - start.minute);
       return sum.inHours();
    }
    public boolean isExtra(){
        if(workTime() >= 8){
            return true;
        }else {
            return false;
        }

    }

}
