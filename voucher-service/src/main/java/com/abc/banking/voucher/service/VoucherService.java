package com.abc.banking.voucher.service;

import java.util.List;

import com.abc.banking.voucher.model.Voucher;
import com.abc.banking.voucher.repository.VoucherRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VoucherService {

    @Value("${vender.service.url}")
    private String venderServiceUrl;

    private final VoucherRepository repository;

    public VoucherService(VoucherRepository repository) {
        this.repository = repository;
    }

    public List<Voucher> getByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    public String getCode(Voucher newVoucher) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
            venderServiceUrl + "/get-voucher-code",
            String.class
        );
        newVoucher.setCode(response.getBody());
        return repository.save(newVoucher).getCode();
    }
}
