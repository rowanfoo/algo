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
                case 6:   arr.add( "consequtive fall ");break;
                case 7:   arr.add( " large fall");break;
                case 9:   arr.add( " fall 4% ");break;
                case 11:  arr.add( " reversal ");break;
                case 24:  arr.add( " rsi ");break;

            }



        });
        return arr;

    }




}



