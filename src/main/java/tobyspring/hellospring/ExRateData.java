package tobyspring.hellospring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true) //없는 데이터는 무시
public record ExRateData(String result, Map<String, BigDecimal> rates) { //json데이터를 map으로

}
