package com.kozitski.analyser;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

public class VkApiTest {

    public static void main(String[] args) throws ClientException, ApiException {

        TransportClient transportClient = new HttpTransportClient();
        VkApiClient vk = new VkApiClient(transportClient);


//        UserAuthResponse authResponse = vk.oAuth()
//                .userAuthorizationCodeFlow(6922524, "Z7CzmmynnB2GImxQoYFl",
//                        "http://localhost", "369f3057369f3057369f30571036f6914b3369f369f30576a3e1efebe9ba301062d45e3")
//                .execute();


    }

}
