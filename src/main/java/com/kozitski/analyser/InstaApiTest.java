package com.kozitski.analyser;

import me.postaddict.instagram.scraper.Instagram;
import me.postaddict.instagram.scraper.MediaUtil;
import me.postaddict.instagram.scraper.cookie.CookieHashSet;
import me.postaddict.instagram.scraper.cookie.DefaultCookieJar;
import me.postaddict.instagram.scraper.interceptor.ErrorInterceptor;
import me.postaddict.instagram.scraper.model.*;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

/**
 * --- Can receive:
 * ==> comments by media
 * ==> all posts form page
 * ==> all commentators[ can be key for searching all strong connected persons] (possible to create graph of coments)
 */
public class InstaApiTest {

    public static void main(String[] args) throws IOException, IllegalAccessException {

//        InstagramService instagramService = new InstagramAuthService()
//                .apiKey("8a5fdd90bcc94cd399ce20081d845662")  // client ID
//                .apiSecret("4a2a02b37743419ea3722621d634c7f7")  // your_client_secret
//                .callback("http://localhost:3000/")  //
//                .scope("likes comments")
//                .build();
//
//        String authorizationUrl = instagramService.getAuthorizationUrl();
//        Verifier verifier = new Verifier("verifier you get from the user");
//        Token accessToken = instagramService.getAccessToken(verifier);


//        Instagram instagram = new Instagram("9270751001.8a5fdd9.08443931159d4973bcd7c52aed0f9471",
//                "4a2a02b37743419ea3722621d634c7f7", "http://localhost:3000/");



//        Instagram instagram = new Instagram("5815808155");
//        instagram.setAccessToken(new Token("9270751001.8a5fdd9.08443931159d4973bcd7c52aed0f9471", "4a2a02b37743419ea3722621d634c7f7"));
//
//        UserInfo userInfo = instagram.getUserInfo("9270751001");
//        System.out.println(userInfo.getData().getFirstName());
//        System.out.println(userInfo.getData().getBio());
//        System.out.println(userInfo.getData().getUsername());

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .addInterceptor(new ErrorInterceptor())
                .cookieJar(new DefaultCookieJar(new CookieHashSet()))
                .build();

        Instagram instagram = new Instagram(httpClient);
        Account account = instagram.getAccountByUsername("koneckonca");

//        Media media = instagram.getMediaByUrl("https://www.instagram.com/p/B0RYyrXCYW4");
//        System.out.println(media.getOwner().getUsername());



        PageObject<Account> followers = instagram.getFollowers(5815808155L, 100);

        PageObject<Media> medias = instagram.getMedias("koneckonca", 100);
        PageObject<Comment> comment = instagram.getCommentsByMediaCode("Bz1IA64oOCn", 100);
        comment.getNodes().forEach(c -> System.out.println("         " + c.getText() + "  "  + c.getOwner().getUsername()));


    }

}


// 12892271435  -- koneckonca ID
// https://www.instagram.com/stories/koneckonca/2100992672004114816/?utm_source=ig_story_item_share&igshid=15uwdsfwbqy54

// All info about dimas_gerasim
// https://www.instagram.com/dimas_gerasim/?__a=1
