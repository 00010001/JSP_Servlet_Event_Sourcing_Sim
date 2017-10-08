package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Event implements Serializable{

    private String amount;
    private String type;
    private String date;
}