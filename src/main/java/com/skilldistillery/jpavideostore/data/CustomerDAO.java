package com.skilldistillery.jpavideostore.data;
import java.util.List;
import com.skilldistillery.jpavideostore.entities.Address;
import com.skilldistillery.jpavideostore.entities.Customer;
public interface CustomerDAO {
    public boolean updateNullEmails();
    
    public List<Customer> getCustomersWithNullEmail();
    
    public Address createAddress(Address addr);
    
    public Address getAddress(int id);
    public boolean deleteAddress(int id);
    
    public int bulkUpdate(String oldFn, String newFn);
    public boolean bulkUpdateSlow(String oldFn, String newFn);

	public Customer createCustomerAndAddress(Customer cust, Address addr);
}
