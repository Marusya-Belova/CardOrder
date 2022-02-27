package ru.netology;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {

    @Test
    void shouldReturnOK() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id='name'] input").setValue("Белова Мария");
        form.$("[data-test-id='phone'] input").setValue("+79175797050");
        form.$("[data-test-id='agreement']").click();
        form.$(".button").click();
        $("[data-test-id='order-success']").shouldHave(text("Ваша заявка успешно отправлена!"));
    }
}