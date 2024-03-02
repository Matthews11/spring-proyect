package com.carga.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carga.video.entity.Video;
import com.carga.video.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private VideoService service;
	
	@PostMapping("/cargar")
	public ResponseEntity<?> cargarVideo(@RequestParam("video")MultipartFile archivo){
		try {
			Video video = service.guardarVideo(archivo);
			return ResponseEntity.ok(video);
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(500).body("Error cargar el video: "+ e.toString());
		}
	}
	
}
