package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderID;
    private int customerID;
    private int productID;
    private String status;
    private Date dateReceived;
    private Date dateDelivered;
}