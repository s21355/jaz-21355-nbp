package pl.pjat.jaz21355nbp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import pl.pjat.jaz21355nbp.model.NbpResponse;
import pl.pjat.jaz21355nbp.model.Rate;
import pl.pjat.jaz21355nbp.model.RequestRecord;
import pl.pjat.jaz21355nbp.repository.RequestRecordRepository;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class RequestServiceImpl implements RequestService {
    private static final String NBP_URL = "http://api.nbp.pl/api/cenyzlota/2022-01-01/2022-01-31";

    private final RequestRecordRepository requestRecordRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public RequestServiceImpl(RequestRecordRepository requestRecordRepository, RestTemplate restTemplate) {
        this.requestRecordRepository = requestRecordRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Double getAverage(String dateStart, String dateEnd, String currencyCode) {
        LocalDate start = getValidDate(dateStart);
        LocalDate end = getValidDate(dateEnd);
        String url = NBP_URL + currencyCode + "/" + start + "/" + end;
        NbpResponse nbpResponse = restTemplate.getForObject(url, NbpResponse.class);
        Double currencyRate = nbpResponse.getRates().stream()
                .mapToDouble(Rate::getMid)
                .average().orElse(0d);
        RequestRecord requestRecord = new RequestRecord(nbpResponse.getCurrency(), start, end, currencyRate);
        requestRecordRepository.save(requestRecord);
        return currencyRate;
    }

    private LocalDate getValidDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException ex) {
            throw new InvalidDateException(date);
        }
    }
}