package com.example.appmusiconline.Service;

public class APIService {
    private static String base_url = "https://phamminhhung99.000webhostapp.com/Server/";

    public static com.example.appmusiconline.Service.Dataservice getService(){
        return APIRetrofitClient.getClient( base_url ).create( com.example.appmusiconline.Service.Dataservice.class );
    }


}
