package shop.gongdal.schedule;

import shop.gongdal.service.OpenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

@Component
public class ScheduleTask {

    private final OpenApiService openApiService;

    @Autowired
    public ScheduleTask(OpenApiService openApiService) {
        this.openApiService = openApiService;
    }

    @Scheduled(fixedDelay = 2000)
    public void task1() throws IOException, URISyntaxException, ParserConfigurationException, SAXException, TransformerException {

        //System.out.println("api 호출완료" + LocalDateTime.now());
        //openApiService.getProductList();

    }
}
