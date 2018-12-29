package com.dharma.algo.controller;

import com.dharma.algo.data.entity.QTechTechstr;
import com.dharma.algo.data.entity.TechTechstr;
import com.dharma.algo.data.repo.TechStrRepo;
import com.dharma.algo.service.ModeService;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AlgoContoller {
@Autowired
    TechStrRepo techStrRepo;

    @Autowired  ModeService nodeService;

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


    @GetMapping("/algobycodes")
    public String listalgobycodeanddate(@RequestParam  String codes , String date ) {

    //        ArrayList<String> arr = new ArrayList<>();
    //        arr.add("ptm.ax");
    //        arr.add("csr.ax");
    //
      //  String  codes = "ptm.ax , csr.ax";

        System.out.println("dates" + date);
        System.out.println("codes" + codes);

        String arr[] =codes.split(",");

        Iterable<TechTechstr> data = techStrRepo.findAll(  QTechTechstr.techTechstr.code.in(arr)
                        .and(QTechTechstr.techTechstr.date.eq (LocalDate.parse(date)  ) )
                   ,new QSort(QTechTechstr.techTechstr.code.asc() ));

        JsonArray  mainArray = new JsonArray();
        data.forEach((a)->{
            JsonObject firstObject = new JsonObject();

            String mode  = nodeService.getMode((int)a.getMode() );
            if (! mode.isEmpty()){
                firstObject.addProperty("code",a.getCode() ) ;
                firstObject.addProperty("mode",mode  ) ;
                mainArray.add(firstObject);


            }

    //            firstObject.addProperty("mode",nodeService.getMode((int)a.getMode() ) ) ;
            //  System.out.println("-----x-----" + a);


        });



        System.out.println("-----x-----" + mainArray);

    //        algoContoller.getcodetech("AOG.AX");

    return mainArray .toString();
    }


}
