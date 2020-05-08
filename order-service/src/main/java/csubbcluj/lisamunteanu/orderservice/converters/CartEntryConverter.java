package csubbcluj.lisamunteanu.orderservice.converters;

import csubbcluj.lisamunteanu.orderservice.dtos.CartEntryDTO;
import csubbcluj.lisamunteanu.orderservice.model.CartEntry;
import org.springframework.stereotype.Component;

@Component
public class CartEntryConverter extends BaseConverter<CartEntry, CartEntryDTO> {

    @Override
    public CartEntryDTO convertModelToDto(CartEntry cartEntry) {
        CartEntryDTO dto = new CartEntryDTO();
        dto.setId(cartEntry.getId());
        dto.setProductName(cartEntry.getProductName());
        dto.setProductDescription(cartEntry.getProductDescription());
        dto.setProductBrand(cartEntry.getProductBrand());
        dto.setProductImage(cartEntry.getProductImage());
//        dto.setQuantity(1);//de modificat-->getQuantityForCartEntry
        return dto;
    }

    @Override
    public CartEntry convertDtoToModel(CartEntryDTO cartEntryDTO) {
        CartEntry cartEntry = new CartEntry();
        cartEntry.setProductId(cartEntryDTO.getProductId());
        cartEntry.setProductName(cartEntryDTO.getProductName());
        cartEntry.setProductDescription(cartEntryDTO.getProductDescription());
        cartEntry.setProductImage(cartEntryDTO.getProductImage());
        cartEntry.setProductBrand(cartEntryDTO.getProductBrand());
        return cartEntry;
    }
}

