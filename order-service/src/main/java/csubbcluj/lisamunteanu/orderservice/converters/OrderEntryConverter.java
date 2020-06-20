package csubbcluj.lisamunteanu.orderservice.converters;

import csubbcluj.lisamunteanu.orderservice.dtos.CartEntryDTO;
import csubbcluj.lisamunteanu.orderservice.dtos.OrderEntryDTO;
import csubbcluj.lisamunteanu.orderservice.model.OrderEntry;
import org.springframework.stereotype.Component;

@Component
public class OrderEntryConverter extends BaseConverter<OrderEntry,OrderEntryDTO> {

    @Override
    public OrderEntryDTO convertModelToDto(OrderEntry orderEntry) {
        OrderEntryDTO dto = new OrderEntryDTO();
        dto.setId(orderEntry.getId());
        return dto;
    }

    @Override
    public OrderEntry convertDtoToModel(OrderEntryDTO orderEntryDTO) {
        OrderEntry entry = new OrderEntry();
        entry.setId(orderEntryDTO.getId());
        entry.setDiscount(orderEntryDTO.getDiscount());
        entry.setPriceWithVAT(orderEntryDTO.getPriceWithVAT());
        entry.setPriceWithoutVAT(orderEntryDTO.getPriceWithoutVAT());
        entry.setProductDescription(orderEntryDTO.getProductDescription());
        entry.setProductBrand(orderEntryDTO.getProductBrand());
        entry.setProductName(orderEntryDTO.getProductName());
        entry.setProductId(orderEntryDTO.getProductId());
        entry.setProductImage(orderEntryDTO.getProductImage());
        entry.setProductPriceVAT(orderEntryDTO.getProductPriceVAT());
        return entry;
    }
}
