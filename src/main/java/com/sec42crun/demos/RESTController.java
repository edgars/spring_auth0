package com.sec42crun.demos;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    Logger logger = LoggerFactory.getLogger(RESTController.class);


    @GetMapping("/xls")
    String xlsHome() {
        return "XLS Api by Skalena";
    }


    @GetMapping("/ads")
    String xlsHome2() {
        return "Protected";
    }



    @GetMapping("/proxy")
    String proxyURI(@RequestParam String path) {
       System.out.println("Log: " + "Serving from url:" + path);

        OkHttpClient client = new OkHttpClient();
          Request request = new Request.Builder()
                    .url(path)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            } catch (Exception e) {

                e.printStackTrace();
            }

            return "No proxy to route";

    }


}
