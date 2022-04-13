package com.aca.homework.week5.abstract_phone;

public class Main {
    public static void main(String[] args) {
        PhoneService phoneService = new PhoneService();
        phoneService.create("351978946541895", Model.SAMSUNG);
        phoneService.create("45678974132187", Model.IPHONE);
        phoneService.create("04894100487866", Model.IPHONE);
        phoneService.create("99987741084444", Model.NOKIA);

        System.out.println(phoneService.getByImei("04894100487866"));
    }
}

/*

Create a SAMSUNG phone via PhoneService having IMEI 351978946541895, also
IPHONE, IMEI: 45678974132187
IPHONE, IMEI: 04894100487866
NOKIA,  IMEI: 99987741084444
invoke the getByImei method to find the phone having the IMEI 04894100487866 and print the phone.

 */
