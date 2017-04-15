package info.jonwarren.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

//    private static final Logger logger = Logger.getLogger(BlogApplication.class);

//    @Autowired 
//    PostRepository postRepository;
    
//    @Autowired
//    DataLoader dataLoader;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

//    @PostConstruct
//    void seePosts(){
//        for(Post post : postRepository.findAll() ){
//            logger.info(post.toString());
//        }
//    }

}
