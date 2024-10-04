package ie.atu.week4.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    private String productName;
    private String productDescription;
    private int productPrice;
    private int productCode;
}
