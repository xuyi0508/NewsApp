package com.example.liyuchen.information;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
    调用URL接口，从api获取新闻及其他内容
 */
public class Information {
    //singleton
    static private class InfoSingleton {
        static Information info = new Information();
    }
    private Information() {}
    protected Information getInstance() {return InfoSingleton.info;}

    private static final String epidemicInfoURL = "https://covid-dashboard.aminer.cn/api/dist/epidemic.json";
    private static final String eventsURL = "https://covid-dashboard.aminer.cn/api/dist/events.json";
    private static final String eventDetailURL = "https://covid-dashboard-api.aminer.cn/event/";
    private static final String entityQueryURL = "https://innovaapi.aminer.cn/covid/api/v1/pneumonia/entityquery";
    private static final String expertsURL = "https://innovaapi.aminer.cn/predictor/api/v1/valhalla/highlight/get_ncov_expers_list?v=2";

    private String getEventDetailURL(String eventID) {return Information.eventDetailURL + eventID;}
    private String getInfoFromInterface(String surl) throws URLInvalidException, IOException {
        URL url = null;
        String info = null;
        try {
            url = new URL(surl);
        }
        catch (MalformedURLException e) {
            throw new URLInvalidException();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            info = reader.readLine();
        }
        catch (IOException e) {
            throw new IOException();
        }
        return info;
    }

    protected String getEpidemicInfo() throws URLInvalidException, IOException {
        try {
            return this.getInfoFromInterface(Information.epidemicInfoURL);
        }
        catch (URLInvalidException e) {
            throw e;
        }
        catch (IOException ee) {
            throw ee;
        }
    }

    protected String getEventsInfo() throws URLInvalidException, IOException {
        try {
            return this.getInfoFromInterface(Information.epidemicInfoURL);
        }
        catch (URLInvalidException e) {
            throw e;
        }
        catch (IOException ee) {
            throw ee;
        }
    }

    protected String getEventDetailInfo(String eventID) throws URLInvalidException, IOException {
        try {
            return this.getInfoFromInterface(Information.epidemicInfoURL);
        }
        catch (URLInvalidException e) {
            throw e;
        }
        catch (IOException ee) {
            throw ee;
        }
    }

    protected String getEntityQueryInfo() throws URLInvalidException, IOException {
        try {
            return this.getInfoFromInterface(Information.epidemicInfoURL);
        }
        catch (URLInvalidException e) {
            throw e;
        }
        catch (IOException ee) {
            throw ee;
        }
    }

    protected String getExpertsURL() throws URLInvalidException, IOException {
        try {
            return this.getInfoFromInterface(Information.epidemicInfoURL);
        }
        catch (URLInvalidException e) {
            throw e;
        }
        catch (IOException ee) {
            throw ee;
        }
    }
}