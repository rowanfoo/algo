package com.dharma.algo;

import com.dharma.algo.controller.AlgoContoller;
import com.dharma.algo.data.entity.QTechTechstr;
import com.dharma.algo.data.entity.TechTechstr;
import com.dharma.algo.data.repo.TechStrRepo;
import com.dharma.algo.service.ModeService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.querydsl.QSort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgoApplicationTests {
    @Autowired
    AlgoContoller algoContoller;
@Autowired
    TechStrRepo techStrRepo;


    @Test
    public void contextLoads() {

        algoContoller.getcodetech("AOG.AX");


    }


    @Test
    public void alltechr() {
        List<String> arr = new ArrayList<>();
        arr.add("bhp.ax");
        arr.add("rio.ax");
        arr.add("fmg.ax");


        Iterable<TechTechstr> alltechs =  techStrRepo.findAll(
                QTechTechstr.techTechstr.code.in( arr)
                        .and(QTechTechstr.techTechstr.date.eq(LocalDate.now().minusDays(1) )  )

        );

        alltechs.forEach((a)-> {
            System.out.println(a);



        });


    }
@Autowired
    ModeService nodeService;

    @Test
    public void listalgobycodeanddate() {

//        ArrayList<String> arr = new ArrayList<>();
//        arr.add("ptm.ax");
//        arr.add("csr.ax");
//
        String  codes = "ptm.ax , csr.ax";
        String arr[] =codes.split(",");

        Iterable<TechTechstr> data = techStrRepo.findAll(  QTechTechstr.techTechstr.code.in(arr)
             //   .and(QTechTechstr.techTechstr.date.eq (LocalDate.now().minusDays(2) ))
                        .and(QTechTechstr.techTechstr.date.eq (LocalDate.parse("2018-12-14")  ) )



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


    }







}
