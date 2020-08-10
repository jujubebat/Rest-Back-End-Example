package com.jujubebat.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.JstlUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GetApiData {

    public void GetData() throws UnsupportedEncodingException, URISyntaxException {
        /*
        String serviceKey = "TkWnKo4m9%2Bg22VKIj4%2B8C6Y%2BGwnrqO6QbFL5gvsi97hijXief5DvTU5rwE79p9wmY%2BpZVwwfqWBPT%2Fs9e%2BxvVQ%3D%3D";
        String url = "http://openapi.onbid.co.kr/openapi/services/KamcoPblsalThingInquireSvc/getKamcoPlnmPbctList";

        // ?serviceKey="+serviceKey+ "&numOfRows=10&pageNo=1&PRPT_DVSN_CD=0001&";

        String decodeServiceKey = URLDecoder.decode(serviceKey, "UTF-8");

        */

        RestTemplate  restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        /*// Response Header to UTF-8
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("serviceKey", serviceKey)
                .queryParam("numOfRows", "10")
                .queryParam("pageNo", "1")
                .queryParam("PRPT_DVSN_CD", "0001")
                .build(false); // 자동 Encoding 막기*/



        String uri = "http://openapi.onbid.co.kr/openapi/services/KamcoPblsalThingInquireSvc/getKamcoPlnmPbctList?serviceKey=TkWnKo4m9%2Bg22VKIj4%2B8C6Y%2BGwnrqO6QbFL5gvsi97hijXief5DvTU5rwE79p9wmY%2BpZVwwfqWBPT%2Fs9e%2BxvVQ%3D%3D&numOfRows=10&pageNo=1&PRPT_DVSN_CD=0001";

        URI uri2 = new URI(uri);
        System.out.println("uri : " + uri2);

        //Object response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class);
        String response = restTemplate.getForObject(uri2, String.class);

        System.out.println(response);

    }
}
