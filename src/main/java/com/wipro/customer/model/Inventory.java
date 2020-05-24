package com.wipro.customer.model;

import java.util.Date;


import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
   	@GeneratedValue(strategy=GenerationType.AUTO)   	 
    @Column(name="Inventory_Id", unique = true, nullable = false)
    private Long inventoryId;
	
	
    @Column(name="Product_Id", nullable = false)
    private Long productId;
    

    
    @Column(name="numberOfItems")
    private Integer numberOfItems;
    

    @Column(name="Created_Date")
    @CreationTimestamp
    private Date creationDate;
    
	@Column(name="NextUpdationDate")
	@UpdateTimestamp
    private Date nextUpdationDate;


    
    public Inventory( Long inventoryId,Long productId,  Integer numberOfItems) {
		super();
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.numberOfItems = numberOfItems;
		
		
	}
    
    
    public Inventory( Long productId, Integer numberOfItems) {
		super();
		this.productId = productId;
		this.numberOfItems = numberOfItems;
				
	}
    public Inventory(Long inventoryId) {
		super();
		this.inventoryId = inventoryId;
		
		
	}

	public Inventory() {
		super();
		
		
	}
    
	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	
	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	
	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCretionDate() {
		return creationDate;
	}

	public void setNextUpdationDate(Date nextUpdationDate) {
		this.nextUpdationDate = nextUpdationDate;
	}



	
}
