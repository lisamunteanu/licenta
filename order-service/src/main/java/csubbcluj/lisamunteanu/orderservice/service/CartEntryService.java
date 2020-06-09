package csubbcluj.lisamunteanu.orderservice.service;

import csubbcluj.lisamunteanu.orderservice.model.CartEntry;

import java.util.List;
import java.util.Optional;

public interface CartEntryService {

    Optional<CartEntry> findById(Integer id);

    void deleteCartEntries(List<CartEntry> cartEntries, Integer customerId);
}
