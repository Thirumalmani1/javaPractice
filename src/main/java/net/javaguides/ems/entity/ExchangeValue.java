package net.javaguides.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name ="exchange_value")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExchangeValue
{

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "currency_from")
    private String FromCurrency;

    @Column(name = "currency_to")
    private String ToCurrency;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    @Column(name = "port")
    private int port;

    // generating constructor using fields
    public ExchangeValue(Long id, String fromCurrency,
                         String toCurrency,
                         BigDecimal conversionMultiple)
    {
        super();
        this.id = id;
        this.FromCurrency = fromCurrency;
        this.ToCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
    }
}
