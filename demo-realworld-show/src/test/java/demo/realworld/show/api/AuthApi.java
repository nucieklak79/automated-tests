package demo.realworld.show.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AuthApi {
    public static String getJwtToken(Playwright playwright, String email, String password) {
        APIRequestContext apiContext = playwright.request().newContext();

        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);

        Map<String, Object> payload = new HashMap<>();
        payload.put("user", credentials);

        APIResponse response = apiContext.post("https://api.realworld.show/api/users/login", RequestOptions
                .create()
                .setData(payload));

        if (!response.ok()) {
            throw new RuntimeException("Failed to login");
        }

        JsonObject jsonResponse = JsonParser.parseString(response.text()).getAsJsonObject();
        return jsonResponse.getAsJsonObject("user").get("token").getAsString();
    }
}
