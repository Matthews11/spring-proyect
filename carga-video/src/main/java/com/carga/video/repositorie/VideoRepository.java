package com.carga.video.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carga.video.entity.Video;

@Repository("repo_video")
public interface VideoRepository extends JpaRepository<Video, Long>{

}
