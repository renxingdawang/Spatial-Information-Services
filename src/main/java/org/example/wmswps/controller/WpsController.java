package org.example.wmswps.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wps")
public class WpsController {

    @GetMapping("/buffer")
    public ResponseEntity<Map<String, Object>> buffer(
            @RequestParam double x,
            @RequestParam double y,
            @RequestParam double radius) {

        // 模拟生成缓冲区 GeoJSON
        Map<String, Object> geoJson = new HashMap<>();
        geoJson.put("type", "Feature");
        geoJson.put("geometry", Map.of(
                "type", "Polygon",
                "coordinates", List.of(
                        List.of(
                                List.of(x - radius, y),
                                List.of(x, y + radius),
                                List.of(x + radius, y),
                                List.of(x, y - radius),
                                List.of(x - radius, y) // 关闭环
                        )
                )
        ));
        geoJson.put("properties", Map.of("buffer_radius", radius));

        return ResponseEntity.ok(geoJson);
    }
}

