package com.abc.banking.voucher.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voucher {

    private @Id @GeneratedValue Long id;
    private String phone;
    private String code;

    public Voucher() {
    }

    public Voucher(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }

    public Long getId() {
        return this.id;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getCode() {
        return this.code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String phone) {
        this.phone = phone;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Voucher)) {
            return false;
        }
        Voucher voucher = (Voucher) o;
        return Objects.equals(this.id, voucher.id) && Objects.equals(this.phone, voucher.phone)
                && Objects.equals(this.code, voucher.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.phone, this.code);
    }

    @Override
    public String toString() {
        return "Voucher{" + "id=" + this.id + ", phone='" + this.phone + '\'' + ", code='" + this.code + '\'' + '}';
    }
}
