package springboot.service;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.entity.SiteDto;
import springboot.entity.Website;
import springboot.repository.WebsiteRepository;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class WebsiteService {

    @Autowired
    private WebsiteRepository repository;
    @Autowired
    private WebExchangeClient webExchangeClient;

//    private static List<Website> items = new ArrayList<>();

//    static {
//        items.add(new Website("stackoverflow", "https://cdn.sstatic.net/Sites/stackoverflow/img/icon-48.png?v=eaeaea",
//                "https://stackoverflow.com/", "Q&A for professional and enthusiast programmers"));
//        items.add(new Website("Super User", "https://cdn.sstatic.net/Sites/superuser/img/icon-48.png?v=84d8f6",
//                "https://superuser.com/", "Q&A for computer enthusiasts and power users"));
//        items.add(new Website("Ask Ubuntu", "https://cdn.sstatic.net/Sites/askubuntu/img/icon-48.png?v=fb9266",
//                "https://askubuntu.com/", "Q&A for Ubuntu users and developers"));
//    }


//    @PostConstruct
//    //позволяет вызывать данный метод,после того как данный bean здесь был полность проинициализирован
//    //происходит это однажды, при старте приложения
//    public void init() {
//        repository.save(new Website("stackoverflow", "https://cdn.sstatic.net/Sites/stackoverflow/img/icon-48.png?v=eaeaea",
//                "https://stackoverflow.com/", "Q&A for professional and enthusiast programmers"));
//        repository.save(new Website("Super User", "https://cdn.sstatic.net/Sites/superuser/img/icon-48.png?v=84d8f6",
//                "https://superuser.com/", "Q&A for computer enthusiasts and power users"));
//        repository.save(new Website("Ask Ubuntu", "https://cdn.sstatic.net/Sites/askubuntu/img/icon-48.png?v=fb9266",
//                "https://askubuntu.com/", "Q&A for Ubuntu users and developers"));
//    }

    public List<Website> findAll() {
        return webExchangeClient.getSites().stream().map(this::toWebsite).filter(this::ignoreMeta)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(Website website) {
        return !website.getTitle().contains("Meta");
    }


    private Website toWebsite(SiteDto input) {
        //проверка на нул
        if (input == null){
            throw new NullPointerException();
        }
        return new Website(input.getName(), input.getFavicon_url(), input.getSite_url(), input.getAudience());
    }



    //    public List<Website> findAll() {
//        return repository.findAll();
//    }



}
