package org.example.wmswps.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/wms")
public class WmsController {

    @GetMapping("/getMap")
    public ResponseEntity<byte[]> getMap(
            @RequestParam String layers,
            @RequestParam String bbox,
            @RequestParam int width,
            @RequestParam int height,
            @RequestParam String format) throws IOException {

        // 这里只是返回一张本地图片模拟地图返回
        ClassPathResource imgFile = new ClassPathResource("static/sample_map.png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}

