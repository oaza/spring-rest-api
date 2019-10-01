package com.november.rest.controller;

import com.november.rest.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Main api requests controller
 */
@Slf4j
@RestController
public class MainController
{

    /**
     * The method handle adding variables
     *
     * @param val1 double
     * @param val2 double
     * @return json in format {"value":double}
     */
    @PostMapping(value = "/add/{val1}/{val2}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse sumValues(@PathVariable("val1") double val1, @PathVariable("val2") double  val2) {
        log.debug("[MainController.sumValues] - welcome in endpoint add/{val1}/{val2}");

        double sum = Double.sum(val1, val2);

        log.debug(String.format("[MainController.sumValues] val1 (%s) add to val (%s) gives (%s)", val1, val2, sum));

        return new BaseResponse(sum);
    }

    /**
     * The method handle divide variables
     *
     * @param val1 double
     * @param val2 double
     * @return json in format {"value":double}
     */
    @GetMapping(path="/div/{val1}/{val2}", produces = "application/json")
    public BaseResponse divideValues(@PathVariable("val1") double val1, @PathVariable("val2") double  val2) {
        log.debug("[MainController,divideValues] welcome in endpoint div/{val1}/{val2}");

        double div = (double) (val1 / val2);

        log.debug(String.format("[MainController.divideValues] val1 (%s) divided by val (%s) gives (%s)", val1, val2, div));

        return new BaseResponse(div);
    }
}