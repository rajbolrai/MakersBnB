package com.makers.makersbnb;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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

}
