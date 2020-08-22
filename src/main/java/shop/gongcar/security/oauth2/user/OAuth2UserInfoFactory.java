package shop.gongcar.security.oauth2.user;

import shop.gongcar.exception.OAuth2AuthenticationProcessingException;
import shop.gongcar.model.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {

        System.out.println(registrationId);
        System.out.println(attributes);

        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            System.out.println("구글 : "  + attributes);
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.naver.toString())) {
            System.out.println("네이버 : "  + attributes.get("response"));
            return new NaverOAuth2UserInfo((Map<String, Object>) attributes.get("response"));
        } else if (registrationId.equalsIgnoreCase(AuthProvider.kakao.toString())) {
            System.out.println("카카오 : "  + attributes);
            return new KakaoOAuth2UserInfo(attributes);
        }
        else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
