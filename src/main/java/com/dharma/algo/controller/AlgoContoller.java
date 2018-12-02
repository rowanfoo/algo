package com.dharma.algo.controller;

import com.dharma.algo.data.entity.QTechTechstr;
import com.dharma.algo.data.entity.TechTechstr;
import com.dharma.algo.data.repo.TechStrRepo;
import com.dharma.algo.service.ModeService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AlgoContoller {
@Autowired
    TechStrRepo techStrRepo;

@GetMapping("/algo")
    public List<TechTechstr>  getalgo(){
        return Lists.newArrayList(
            techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.now()))
         );

    }



    @GetMapping("/fallfour")
    public List<TechTechstr>  getfallgreaterfour(String date ){
        List<TechTechstr> arr=  Lists.newArrayList(
                techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.parse(date) )
                .and(QTechTechstr.techTechstr.mode.eq(9l )    )
                )
        );

        arr.forEach((a)->{
            System.out.println("---------cc--------" + a);
        });
    return arr;
    }
    @GetMapping("/rsi")
    public List<TechTechstr>  getrsifall(String date){
        return Lists.newArrayList(
                techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.parse(date))
                        .and(QTechTechstr.techTechstr.mode.eq(24l )    )
                )
        );
    }
    @GetMapping("/conseqfall")
    public List<TechTechstr>  getconsedfall(String date){
        return Lists.newArrayList(
                techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.parse(date))
                        .and(QTechTechstr.techTechstr.mode.eq(6l )    )
                )
        );
    }
    @GetMapping("/vol")
    public List<TechTechstr>  getvol(String date){
        return Lists.newArrayList(
                techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.parse(date))
                        .and(QTechTechstr.techTechstr.mode.eq(3l )    )
                )
        );
    }

    @GetMapping("/largefall")
    public List<TechTechstr>  getlargefall(String date){
        return Lists.newArrayList(
                techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.parse(date))
                        .and(QTechTechstr.techTechstr.mode.eq(7l )    )
                )
        );
    }

    @GetMapping("/reversal")
    public List<TechTechstr>  getreversal(String date){
        return Lists.newArrayList(
                techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.parse(date))
                        .and(QTechTechstr.techTechstr.mode.eq(11l )    )
                )
        );
    }


    @GetMapping("/code")
    public List<TechTechstr>  getcode(String code){
        return Lists.newArrayList(
                techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.now())
                        .and(QTechTechstr.techTechstr.code.eq(code )    )
                )
        );
    }
@Autowired
    ModeService modeService;

    @GetMapping("/codetech")
    public List<String>  getcodetech(String code){
        List<String> str = new ArrayList<>();
        str.add("");


        Iterable<TechTechstr> itr =techStrRepo.findAll(QTechTechstr.techTechstr.date.eq(LocalDate.now())
                .and(QTechTechstr.techTechstr.code.eq(code )    ) ) ;
        if(itr==null)return str;
        else{
            List<TechTechstr>   arr = Lists.newArrayList(itr) ;
            return  modeService.getModes(arr );

        }

    }







}
