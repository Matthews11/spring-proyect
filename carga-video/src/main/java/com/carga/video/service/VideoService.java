package com.carga.video.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carga.video.entity.Video;
import com.carga.video.repositorie.VideoRepository;

@Service

public class VideoService {

	@Autowired
	private VideoRepository repo;
	
	private final String directorio = "C:\\Users\\Jared\\Desktop\\video\\";
	
	public Video guardarVideo(MultipartFile archivo) throws IOException {
		
		String nombreArchivo = archivo.getOriginalFilename();
		Path rutaArchivo = Paths.get(directorio+nombreArchivo);
		Files.copy(archivo.getInputStream(), rutaArchivo );
		
		Video video = new Video();
		video.setName(nombreArchivo);
		video.setRutaArchivo(rutaArchivo.toString());
		return repo.save(video);
		
	}
}
