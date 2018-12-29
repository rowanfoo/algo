package com.dharma.algo.service;

import com.dharma.algo.data.T;
import com.dharma.algo.data.entity.QTechTechstr;
import com.dharma.algo.data.entity.TechTechstr;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ModeService {


    public ArrayList<String>  getModes(Iterable <TechTechstr> list){
        ArrayList<String> arr = new ArrayList<>();
        list.forEach((a)->{
            int mode =(int) a.getMode();


            switch (mode) {
                case 3:  arr.add( "large volume "); break;
                case 5:   arr.add( "20% from 50MA");break;
                case 6:   arr.add( "consequtive fall ");break;
                case 7:   arr.add( " large fall  , small vol");break;
                case 9:   arr.add( " fall 4% ");break;
                case 11:  arr.add( " reversal ");break;
                case 13:  arr.add( " 6 month low ");break;
                case 14:  arr.add( " 6 month low high ");break;
                case 24:  arr.add( " rsi ");break;

            }



        });
        return arr;

    }



    public String  getMode(int mode){

            switch (mode) {
                case 3:  return "large volume ";
                case 5:  return "20% from 50MA";
                case 6:  return  "consequtive fall ";
                case 7:  return  " large fall  , small vol";
                case 9:  return  " fall 4% ";
                case 11: return  " reversal ";
                case 13: return " 6 month low ";
                case 14: return " 6 month low high ";
                case 24: return " rsi ";
                default: return "";
            }




    }





}



