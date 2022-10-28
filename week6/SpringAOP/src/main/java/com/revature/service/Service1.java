package com.revature.service;

import com.revature.data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    @Autowired
    private Dao1 dao1;

    public String calculatesSomething(){
        return dao1.getSomething();
    }
}
