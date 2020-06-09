package csubbcluj.lisamunteanu.orderservice.service.impl;

import csubbcluj.lisamunteanu.orderservice.dao.OrderDao;
import csubbcluj.lisamunteanu.orderservice.dao.OrderEntryDao;
import csubbcluj.lisamunteanu.orderservice.dao.OrderToOrderEntryDao;
import csubbcluj.lisamunteanu.orderservice.dtos.OrderEntryDTO;
import csubbcluj.lisamunteanu.orderservice.model.*;
import csubbcluj.lisamunteanu.orderservice.service.CartEntryService;
import csubbcluj.lisamunteanu.orderservice.service.CartService;
import csubbcluj.lisamunteanu.orderservice.service.OrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderEntryDao orderEntryDao;

    @Autowired
    private OrderToOrderEntryDao orderToOrderEntryDao;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartEntryService cartEntryService;

    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderDao.findById(id);
    }

    OrderEntry convertCartEntryToOrderEntry(CartEntry cartEntry) {
        OrderEntry orderEntry = new OrderEntry();
        if (Objects.nonNull(cartEntry)) {
            Integer productId = Objects.nonNull(cartEntry.getProductId()) ? cartEntry.getProductId() : -1;
            orderEntry.setProductId(productId);

            String productName = Objects.nonNull(cartEntry.getProductName()) ? cartEntry.getProductName() : StringUtils.EMPTY;
            orderEntry.setProductName(productName);

            String productImage = Objects.nonNull(cartEntry.getProductImage()) ? cartEntry.getProductImage() : StringUtils.EMPTY;
            orderEntry.setProductImage(productImage);

            String productBrand = Objects.nonNull(cartEntry.getProductBrand()) ? cartEntry.getProductBrand() : StringUtils.EMPTY;
            orderEntry.setProductBrand(productBrand);

            String productDescription = Objects.nonNull(cartEntry.getProductDescription()) ? cartEntry.getProductDescription() : StringUtils.EMPTY;
            orderEntry.setProductDescription(productDescription);

            Double priceWithoutVAT = Objects.nonNull(cartEntry.getPriceWithoutVAT()) ? cartEntry.getPriceWithoutVAT() : 0.0d;
            orderEntry.setPriceWithoutVAT(priceWithoutVAT);

            Double priceWithVAT = Objects.nonNull(cartEntry.getPriceWithVAT()) ? cartEntry.getPriceWithVAT() : 0.0d;
            orderEntry.setPriceWithVAT(priceWithVAT);

            Double discount = Objects.nonNull(cartEntry.getDiscount()) ? cartEntry.getDiscount() : 0.0d;
            orderEntry.setDiscount(discount);

        }
        return orderEntry;
    }

    List<OrderEntry> convertAllCartEntries(List<CartEntry> cartEntries) {
        List<OrderEntry> orderEntries = new ArrayList<>();
        for (CartEntry cartEntry : cartEntries) {
            OrderEntry orderEntry = this.convertCartEntryToOrderEntry(cartEntry);
            orderEntries.add(orderEntry);
        }
        return orderEntries;
    }

    void populateOrder(Order order, String deliveryMode, String paymentMode, List<OrderEntry> orderEntries, Integer customerId) {
        order.setDate(LocalDateTime.now());
        order.setDeliveryMode(deliveryMode);
        order.setPaymentMode(paymentMode);
        Double deliveryCost = deliveryMode.equals("home-delivery") ? 20.0 : 5.0;
        order.setDeliveryMode(deliveryMode);
        order.setDeliveryCost(deliveryCost);
        order.setUserId(customerId);
        Double productsTotal = 0.0d;
        Double totalDiscount = 0.0d;
        Double totalPrice = 0.0d;

        for (OrderEntry orderEntry : orderEntries) {
            productsTotal = productsTotal + orderEntry.getPriceWithVAT();
            totalDiscount = totalDiscount + orderEntry.getDiscount();
        }
        totalPrice = productsTotal + deliveryCost;

        order.setProductsTotal(productsTotal);
        order.setTotalDiscount(totalDiscount);
        order.setTotalPrice(totalPrice);
    }


    @Override
    public Order placeOrder(List<CartEntry> cartEntries, Integer customerId, String deliveryMode, String paymentMode, Integer quantity) {
        List<OrderEntry> orderEntries = this.convertAllCartEntries(cartEntries);
        Order order = new Order();
        populateOrder(order, deliveryMode, paymentMode, orderEntries, customerId);
        Order orderWithId = orderDao.save(order);
        for (OrderEntry orderEntry : orderEntries) {
            OrderEntry orderEntryWithId = orderEntryDao.save(orderEntry);
            OrderToOrderEntryId orderToOrderEntryId = new OrderToOrderEntryId(orderWithId.getId(), orderEntryWithId.getId());

            OrderToOrderEntryRelation orderToOrderEntryRelation = new OrderToOrderEntryRelation(orderToOrderEntryId, order, orderEntry, quantity);
            orderToOrderEntryDao.save(orderToOrderEntryRelation);
        }
        cartEntryService.deleteCartEntries(cartEntries, customerId);
        cartService.deleteCart(customerId);

        return orderWithId;
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderDao.findByUserId(userId);
    }

    @Override
    public List<OrderEntry> getAllOrderEntries() {
        return orderEntryDao.findAll();
    }

    @Override
    public List<OrderEntryDTO> getAllOrderEntriesWithID() {
        List<Object[]> orderEntriesObj = orderEntryDao.findAllWithOrderId();
        List<OrderEntryDTO> result = new ArrayList<>();
        for (Object[] o : orderEntriesObj) {
            OrderEntryDTO dto = new OrderEntryDTO();
            if (Objects.nonNull(o[0])) {
                dto.setId(Integer.parseInt(o[0].toString()));
            }
            if (Objects.nonNull(o[1])) {
                dto.setProductName(o[1].toString());
            }
            if (Objects.nonNull(o[2])) {
                dto.setProductBrand(o[2].toString());
            }
            if (Objects.nonNull(o[3])) {
                dto.setProductDescription(o[3].toString());
            }
            if (Objects.nonNull(o[4])) {
                dto.setProductId(Integer.parseInt(o[4].toString()));
            }
            if (Objects.nonNull(o[5])) {
                dto.setPriceWithVAT(Double.parseDouble(o[5].toString()));
            }
            if (Objects.nonNull(o[6])) {
                dto.setPriceWithoutVAT(Double.parseDouble(o[6].toString()));
            }
            if (Objects.nonNull(o[7])) {
                dto.setDiscount(Double.parseDouble(o[7].toString()));
            }
            if (Objects.nonNull(o[8])) {
                dto.setProductPriceVAT(Double.parseDouble(o[8].toString()));
            }
            if (Objects.nonNull(o[9])) {
                dto.setOrderId(Integer.parseInt(o[9].toString()));
            }
            if (Objects.nonNull(o[10])) {
                dto.setCustomerId(Integer.parseInt(o[10].toString()));
            }
            if (Objects.nonNull(o[11])) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                dto.setOrderDate(LocalDateTime.parse(o[11].toString(),formatter));
            }
            result.add(dto);
        }
        return result;
    }

}
