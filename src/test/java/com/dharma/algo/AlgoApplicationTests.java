package com.dharma.algo;

import com.dharma.algo.controller.AlgoContoller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgoApplicationTests {
    @Autowired
    AlgoContoller algoContoller;

    @Test
    public void contextLoads() {

        algoContoller.getcodetech("AOG.AX");


    }

}
