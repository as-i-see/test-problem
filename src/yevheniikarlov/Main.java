package yevheniikarlov;

import yevheniikarlov.analyticaltool.data.parameter.Date;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	    String s = "15.10.2012";
        LocalDate localDate = LocalDate.parse(s, Date.format);
        System.out.println(localDate);
    }
}
