package com.go2it.springbootapp.controller;

import com.github.openjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {



    //http://localhost:8080/
    @RequestMapping("/")
    public String index() {
        return "<div style=\"text-align:center;\">"
                + "<h1>Hello World</h1>" +
                "<p> This is my first Batman </p>" +
                "<img src=https://static.hwpi.harvard.edu/files/styles/os_files_xxlarge/public/torman_fileserver/files/batman.jpg?m=1555654555&itok=2IEsUJDz</img>"
                + "</div>";
    }

//    //+++++++++++++++++++++++  GET with query parameter
    //http://localhost:8080/user?name=Andrey
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String getHelloMessageForUser(@RequestParam String name) {
//        return "<div style=\"text-align:center;\">" + "<h1>" + "Welcome" + ", " + name + "</h1>"
//                + "<p> This is my first web-page </p>" + "</div>";
//    }
    //+++++++++++++++++++++++  GET with query 2 parameters
    //http://localhost:8080/user?name=Andrey&surname=Faigon
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getHelloMessageForUser2(@RequestParam String name,String surname) {
        return "<div style=\"text-align:center;\">" + "<h1>" + "Welcome" + ", " + name +" "+ surname+ "</h1>"
                + "<p> This is my first web-page </p>" + "</div>";
    }

    //+++++++++++++++++++++++  GET with path variable
    //http://localhost:8080/weather/canada?city=toronto
    @RequestMapping(value = "/{resource}", method = RequestMethod.GET)
    public String getHelloWorldMessageFromResource(@PathVariable String resource) {
        return "<div style=\"text-align:center;\">" + "<h1>This request was done to the resource: "
                + resource + "</h1>" + "</div>";
    }

    //+++++++++++++++++++++++++  POST with JSON body
    //localhost:8080/customizedWelcome
    @RequestMapping(value = "/customizedWelcome", method = RequestMethod.POST)
    public String getHelloWorldWithFromJSON(@RequestBody String message) {
        JSONObject json = new JSONObject (message);
        String firstName = "Albert";
        String defaultPictureAddress = "https://cdn-images-1.medium.com/fit/t/1600/672/0*n-2bW82Z6m6U2bij.jpeg";

        String firstNameFromRequest = json.getString ("firstName");
        if (StringUtils.isNotBlank (firstNameFromRequest)) {
            firstName = firstNameFromRequest;
        }
        String pictureURLFromRequest = json.getString ("pictureURL");
        if (StringUtils.isNotBlank (pictureURLFromRequest)) {
            defaultPictureAddress = pictureURLFromRequest;

        }
        // HTML
        return "<div style=\"text-align:center;\">" + "<h1>Hello world from " + firstName + "</h1>"
                + "<p> This is my first web-page </p>" + "<img src=" + defaultPictureAddress + "></img>"
                + "</div>";
    }
//+++++++++++++++++++ REQUESTS INSTANCES: POST
}
