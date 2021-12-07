package com.yourcodereview.dev.yudin.banknote;

public enum Banknote {

    BANKNOTE1000("1000"),
    BANKNOTE500("500"),
    BANKNOTE200("200"),
    BANKNOTE100("100"),
    BANKNOTE50("50"),
    BANKNOTE20("20"),
    BANKNOTE10("10"),
    BANKNOTE5("5"),
    BANKNOTE2("2"),
    BANKNOTE1("1");

    private String banknote;

    public String getBanknote() {
        return banknote;
    }

    Banknote(String banknote) {
        this.banknote = banknote;
    }
}

