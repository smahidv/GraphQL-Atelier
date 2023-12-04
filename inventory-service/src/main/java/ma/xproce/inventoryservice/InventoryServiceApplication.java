package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
		return args -> {
			List<Creator> creators = List.of(Creator.builder().name("oumaima")
					.email("oumaima@gmail.com").build(), Creator.builder().name("haana")
					.email("haana@gmail.com").build(), Creator.builder().name("sabrine")
					.email("sabrine@gmail.com").build());
			for (Creator creator : creators) {
				creatorRepository.save(creator);
			}

			List<Video> videos = List.of(Video.builder().name("1")
					.url("firstVideo.com").datePublication(new Date())
					.description("this is video 1").creator(creators.get(1))
					.build(), Video.builder().name("2").url("secondvideo.com")
					.datePublication(new Date()).description("this is video 2")
					.creator(creators.get(0)).build(), Video.builder().name("3")
					.url("thirdvideo.com").datePublication(new Date())
					.description("this is video 3")
					.creator(creators.get(2)).build());
			for (Video video : videos) {
				videoRepository.save(video);
			}
		};
	}
}