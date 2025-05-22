package com.restassured.test;

import com.restassured.Category;
import com.restassured.util.RestClient;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.restassured.HttpMethod.GET;
import static com.restassured.constant.ApplicationConstant.BOOKING_SERVICE_ENDPOINT;
import static com.restassured.constant.ApplicationConstant.RESTFUL_BOOKER_BASE_URL;
import static com.restassured.test.constant.TestCategory.BOOKING;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertTrue;

public class GetAllBookingsTest extends BaseTest {
    @Category(BOOKING)
    @Test
    public void testGetAllBookings() {
        ValidatableResponse response = new RestClient(RESTFUL_BOOKER_BASE_URL, BOOKING_SERVICE_ENDPOINT,
                Collections.emptyMap(), true, Collections.emptyMap(), EMPTY)
                .sendRequest(GET)
                .statusCode(SC_OK);

        assertTrue(response.extract().body().jsonPath().getList("$").size() > 1);
    }
}