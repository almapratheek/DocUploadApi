package com.capone.endpoints;

import com.capone.model.DocObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class DocController {

    private Map<String, String> docs = new HashMap<>();

    @RequestMapping(value = "/getDoc", method = GET, produces = "application/json")
    public ResponseEntity<DocObject> getDoc(@RequestParam("name") String imgName) {
        DocObject response = new DocObject();
        response.setImgName(imgName);
        response.setImgValue(docs.get(imgName));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/uploadDoc", method = POST,
            consumes="application/json")
    public ResponseEntity<?> postDoc(@RequestBody DocObject docObject) {
            docs.put(docObject.imgName, docObject.imgValue);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
