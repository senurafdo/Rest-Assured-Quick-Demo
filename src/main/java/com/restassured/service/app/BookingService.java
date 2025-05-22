package com.restassured.service.app;

import com.restassured.util.RestClient;

import static com.restassured.HttpMethod.GET;
import static com.restassured.constant.ApplicationConstant.BOOKING_SERVICE_ENDPOINT;
import static com.restassured.constant.ApplicationConstant.RESTFUL_BOOKER_BASE_URL;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.http.HttpStatus.SC_OK;

public class BookingService {
    public static String getBookingIdFromBookingDb() {
        return new RestClient(RESTFUL_BOOKER_BASE_URL, BOOKING_SERVICE_ENDPOINT, EMPTY)
                .sendRequest(GET)
                .statusCode(SC_OK)
                .extract()
                .body()
                .jsonPath()
                .get("[0].bookingid")
                .toString();
    }
}