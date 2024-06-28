package tobyspring.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class PaymentService {
    private final ExRateProvider exRateProvider;

    public PaymentService(ExRateProvider exRateProvider){
        this.exRateProvider = exRateProvider;
        //이제는 이 친구를 계속 변경해야함 얘가 책임을 가지고 있는 것임
        //생성자는 의존관계의 역전
    }
    public Payment prepare(Long orderId,String currency, BigDecimal foreignCurrencyAmount) throws IOException {
         //매번 prepare할 떄마다 오브젝트 생성?!
        BigDecimal exRate = exRateProvider.getExRate(currency); //여기도 바꿔야함!
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);
        return new Payment(orderId,currency,  foreignCurrencyAmount,exRate,convertedAmount, validUntil);
    }
    //abstract BigDecimal getExRate(String currency) throws IOException; 상속할떄!
}
