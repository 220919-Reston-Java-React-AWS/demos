package com.revature.service;

import com.revature.data.Dao1;
import com.revature.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service2 {
    @Autowired
    private Dao2 dao2;

    public String calculatesSomething(){
        return dao2.getSomething();
    }
}
