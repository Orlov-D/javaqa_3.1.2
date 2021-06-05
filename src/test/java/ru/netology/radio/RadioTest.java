package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void stationOverLimit() {
        Radio service = new Radio();
//Станция не задана. Изначально ноль.
        service.setCurrentStation(10);
        assertEquals(0, service.getCurrentStation());

        service.setCurrentStation(-1);
        assertEquals(0, service.getCurrentStation());

//Зададим значение станции.
        service.setCurrentStation(4);
        service.setCurrentStation(10);
        assertEquals(4, service.getCurrentStation());

        service.setCurrentStation(-1);
        assertEquals(4, service.getCurrentStation());
    }

    @Test
    void stationButtonWorks() {
        Radio service = new Radio();
//Проверим что станция нулевая.
        assertEquals(0, service.getCurrentStation());

//Кнопка взад.
        service.prevButton();
        assertEquals(9, service.getCurrentStation());
        service.prevButton();
        assertEquals(8, service.getCurrentStation());

//Кнопка вперед.
        service.nextButton();
        assertEquals(9, service.getCurrentStation());
        service.nextButton();
        assertEquals(0, service.getCurrentStation());
        service.nextButton();
        assertEquals(1, service.getCurrentStation());
    }

    @Test
    void volumeTest() {
        Radio service = new Radio();

//Проверим что громкость на нуле.
        assertEquals(0, service.getVolume());

//Кнопка уменьшения громкости при нуле.
        service.volumeDown();
        assertEquals(0, service.getVolume());

//Изменение громкости.
        service.volumeUp();
        assertEquals(1, service.getVolume());
        service.volumeDown();
        assertEquals(0, service.getVolume());

//Кнопка увелечения громкости при максимуме.
        int i = 0;
        while (i < 10) {
            service.volumeUp();
            i++;
        }
        assertEquals(9, service.getVolume());
    }

}
