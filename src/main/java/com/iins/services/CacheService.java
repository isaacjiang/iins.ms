package com.iins.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.util.*;


public class CacheService {

    @Autowired
    private Environment environment;
    public HashMap<String, String> Configuration = new HashMap<>();
    public final ArrayList<String> SupportedDeviceType = new ArrayList<String>(Arrays.asList("IPX","ARISTA","MELLANOX"));//{};
    private HashMap<InetAddress, Integer> ActiveList = new HashMap<InetAddress, Integer>();
    private HashMap<InetAddress, JSONObject> DeviceDetails = new HashMap<InetAddress, JSONObject>();
    public HashMap<InetAddress, JSONObject> SystemInfo = new HashMap<InetAddress, JSONObject>();
    public HashMap<InetAddress, JSONObject> InterfaceTable = new HashMap<InetAddress, JSONObject>();

    public CacheService(){}

    public void initialization() {
        this.Configuration.put("MongoDbHost", "localhost");
        this.Configuration.put("MongoDbPort", "27017");
    }

    public JSONObject getSystemInfo(InetAddress ip) {
        return SystemInfo.get(ip);
    }

    public void setSystemInfo(InetAddress ip, JSONObject jsonObject) {
        SystemInfo.put(ip, jsonObject);
    }

    public JSONObject getInterfaceTable(InetAddress ip) {
        return InterfaceTable.get(ip);
    }

    public void setInterfaceTable(InetAddress ip, JSONObject jsonObject) {
        InterfaceTable.put(ip, jsonObject);
    }

    public JSONArray getActiveList() {
        JSONArray ipList = new JSONArray();
        for (Map.Entry<InetAddress, Integer> map : ActiveList.entrySet()) {
            if (map.getValue() > 0) ipList.put(map.getKey());
        }
        return ipList;
    }

    public JSONArray getActiveList(Integer status) {
        JSONArray ipList = new JSONArray();
        for (Map.Entry<InetAddress, Integer> map : ActiveList.entrySet()) {
            if (map.getValue() <= status && map.getValue() > 0) ipList.put(map.getKey());
        }
        return ipList;
    }

    public void putActiveIP(InetAddress ip) {
        ActiveList.put(ip, 1);
    }

    public void removeActiveIP(InetAddress ip) {
        ActiveList.replace(ip, 0);
    }

    public void setActiveIP(InetAddress ip, Integer status) {
        ActiveList.put(ip, status);
    }

    public JSONObject getDeviceDetail(InetAddress ip) {
        return DeviceDetails.get(ip);
    }

    public void setDeviceDetails(InetAddress ip, JSONObject abbr) {
        DeviceDetails.put(ip, abbr);
    }
}