package csubbcluj.lisamunteanu.exportservice.utils;

import com.opencsv.CSVWriter;
import csubbcluj.lisamunteanu.exportservice.data.OrderEntryExportData;
import csubbcluj.lisamunteanu.exportservice.data.OrderExportData;
import org.apache.commons.lang.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class ScheduledWriter {
    String pathToCSV;
    FileWriter fileWriter;
    CSVWriter csvWriter;

    public ScheduledWriter(String pathToCSV) {
        this.pathToCSV = pathToCSV;
        setCsvWriter();
    }

    public void setCsvWriter() {
        try {
            this.fileWriter = new FileWriter(pathToCSV,false);
            this.csvWriter = new CSVWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeOrderHeader() {

        String[] header = {"Id comanda", "Id client", "Data", "Mod livrare", "Mod plata", "Total produse", "Reducere",
                "Cost livrare", "Pret total"};
        csvWriter.writeNext(header);

    }

    public void writeOrderEntryHeadr() {

        String[] header = {"Id", "Nume produs", "Brand produs", "Descriere produs", "Id produs", "Pret cu TVA", "Pret fara TVA",
                "Reducere", "Procentaj TVA","Id comanda", "Id client","Data comanda"};
        csvWriter.writeNext(header);

    }

    public void writeOrderLine(OrderExportData orderExportData) {
        if (Objects.isNull(orderExportData.getUserId())) {
            orderExportData.setUserId(-1);
        }
        if (Objects.isNull(orderExportData.getDeliveryMode())) {
            orderExportData.setDeliveryMode(StringUtils.EMPTY);
        }
        if (Objects.isNull(orderExportData.getPaymentMode())) {
            orderExportData.setPaymentMode(StringUtils.EMPTY);
        }
        if (Objects.isNull(orderExportData.getProductsTotal())) {
            orderExportData.setProductsTotal(0.0d);
        }
        if (Objects.isNull(orderExportData.getTotalDiscount())) {
            orderExportData.setTotalDiscount(0.0d);
        }
        if (Objects.isNull(orderExportData.getDeliveryCost())) {
            orderExportData.setDeliveryCost(0.0d);
        }
        if (Objects.isNull(orderExportData.getTotalPrice())) {
            orderExportData.setTotalPrice(0.0d);
        }
        String[] orderItem = {orderExportData.getId().toString(),
                orderExportData.getUserId().toString(), orderExportData.getDate().toString(),
                orderExportData.getDeliveryMode(), orderExportData.getPaymentMode(),
                orderExportData.getProductsTotal().toString(), orderExportData.getTotalDiscount().toString(),
                orderExportData.getDeliveryCost().toString(), orderExportData.getTotalPrice().toString()};
        csvWriter.writeNext(orderItem);

    }

    public void writeOrderEntryLine(OrderEntryExportData orderEntryData) {
        if (Objects.isNull(orderEntryData.getProductName())) {
            orderEntryData.setProductName(StringUtils.EMPTY);
        }
        if (Objects.isNull(orderEntryData.getProductBrand())) {
            orderEntryData.setProductBrand(StringUtils.EMPTY);
        }
        if (Objects.isNull(orderEntryData.getProductDescription())) {
            orderEntryData.setProductDescription(StringUtils.EMPTY);
        }
        if (Objects.isNull(orderEntryData.getProductId())) {
            orderEntryData.setProductId(-1);
        }
        if (Objects.isNull(orderEntryData.getPriceWithVAT())) {
            orderEntryData.setPriceWithVAT(0.0d);
        }
        if (Objects.isNull(orderEntryData.getPriceWithoutVAT())) {
            orderEntryData.setPriceWithoutVAT(0.0d);
        }
        if (Objects.isNull(orderEntryData.getProductPriceVAT())) {
            orderEntryData.setProductPriceVAT(0.0d);
        }
        if (Objects.isNull(orderEntryData.getDiscount())) {
            orderEntryData.setDiscount(0.0d);
        }
        if (Objects.isNull(orderEntryData.getOrderId())) {
            orderEntryData.setOrderId(-1);
        }
        if (Objects.isNull(orderEntryData.getCustomerId())) {
            orderEntryData.setCustomerId(-1);
        }
        String[] data = {orderEntryData.getId().toString(), orderEntryData.getProductName(), orderEntryData.getProductBrand(),
                orderEntryData.getProductDescription(), orderEntryData.getProductId().toString(), orderEntryData.getPriceWithVAT().toString(),
                orderEntryData.getPriceWithoutVAT().toString(), orderEntryData.getDiscount().toString(), orderEntryData.getProductPriceVAT().toString(),
                orderEntryData.getOrderId().toString(), orderEntryData.getCustomerId().toString(),orderEntryData.getOrderDate().toString()};
        csvWriter.writeNext(data);
    }

    public CSVWriter getCsvWriter() {
        return csvWriter;
    }
}