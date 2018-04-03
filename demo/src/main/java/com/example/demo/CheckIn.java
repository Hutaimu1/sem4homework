package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Vector;

@RestController
public class CheckIn {
    private boolean flag = false;
    private WordLadder ladder = new WordLadder();

    @RequestMapping("/test")
    public String[] test(){
        String[] ret = new String[3];
        ret[0] = "dog";
        ret[1] = "dod";
        ret[2] = "god";
        return ret;
    }

    @RequestMapping("/")
    public Vector<String> getLadder (@RequestParam(value = "start", defaultValue = "") String start,
                      @RequestParam(value = "end", defaultValue = "") String end){
        if (!flag){
            try {
                ladder.readFile();
            }
            catch (FileNotFoundException e) {
            }
        }
        return ladder.findLadder(start,end);
        //return ans;
    }
}
