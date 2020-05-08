package csubbcluj.lisamunteanu.orderservice.service;

import csubbcluj.lisamunteanu.orderservice.model.CartEntry;

import java.util.Optional;

public interface CartEntryService {

    Optional<CartEntry> findById(Integer id);
}
