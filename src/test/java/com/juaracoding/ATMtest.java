package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMtest {

    private ATM atm;

    //inisiasi objek ATM
    @BeforeMethod
    public void setUp(){
        atm = new ATM(1000);
    }

    //mengecek fungsi lihatSaldo
    @Test
    public void testLihatSaldo() {
        Assert.assertEquals(atm.lihatSaldo(), 1000.0);
    }

    //mengecek fungsi setorUang. hasil total saldo = lihatSaldo + setorUang
    @Test
    public void testSetorUang() {
        atm.setorUang(1000);
        Assert.assertEquals(atm.lihatSaldo(), 2000.0);
    }

    //mengecek fungsi setorUang jika diinput value negatif
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        atm.setorUang(-1000);
    }

    //mengecek fungsi tarikUang. hasil total saldo = lihatSaldo - tarikUang
    @Test
    public void testTarikUang() {
        atm.tarikUang(500);
        Assert.assertEquals(atm.lihatSaldo(), 500);
    }

    //mengecek fungsi tarikUang jika melebihi dari nominal lihatSaldo
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangMelebihiSaldo() {
        atm.tarikUang(2000);
    }

    //mengecek fungsi tarikUang jika diinput value negatif
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-300);
    }
}
