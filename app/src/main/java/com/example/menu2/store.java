package com.example.menu2;

public class store {

    public String items[] = {""};
    public String prices[] = {""};

    public int data(int i){
        if (items[i] == "") {
            return(0);
        }
        else {
            return (1);
        }

    }
}
