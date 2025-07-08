package com.makers.makersbnb;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LandingPageTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser(){
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext(){
        context.close();
    }

    @Test
    public void usersAreWelcomedToTheApp(){
        page.navigate("http://localhost:8080");
        Locator pageBody = page.locator("h3");
        assertThat(pageBody).containsText("100 spaces are waiting to be discovered");
    }

    @Test
    public void contactInformationIsShown(){
        page.navigate("http://localhost:8080/contact");
        Locator pageBody = page.locator("h2");
        assertThat(pageBody).containsText("test@email.com");

    }

    @Test
    public void teamInformationIsShown(){
        page.navigate("http://localhost:8080/team");
        Locator pageBody = page.locator("h1");
        assertThat(pageBody).containsText("Toby, Katerine, Sandy");
    }

    @Test
    public void checkBookingsMade(){
        page.navigate("http://localhost:8080");
        Locator pageBody = page.locator("h5");
        assertThat(pageBody).containsText("123 bookings were made");
    }

    @Test
    public void checkHoliday(){
        page.navigate("http://localhost:8080/spaces");
        Locator spaces = page.locator("p");
        assertEquals(3, spaces.count());
        List<String> texts= new ArrayList<>();
        for(int i = 0; i<spaces.count();i++){
            texts.add(spaces.nth(i).innerText());
        }
        assertTrue(texts.contains("Spain is a sunny place, cost £10.0"), "Actual paragraphs: " + texts.toString());
        assertTrue(texts.contains("Germany is a cold place, cost £5.0"));
        assertTrue(texts.contains("France is a sunny place, cost £2.0"));
    }

}
